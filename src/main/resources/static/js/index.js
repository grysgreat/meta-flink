$(function() {

	const Xterm = {

		_term: null,

		init() {
			this._term = new Terminal({
				cursorBlink: true,
				cursorStyle: "block",
				scrollback: 1200,
				screenKeys: true,
				cursor: 'help',
				rows: 49,
				cols: 150
			})

			this._term.open(document.getElementById("terminal"), true)
			this._consoleBase()

			/* this._term.on('data', data => {
				this._term.write(data)
			}) */

			return this._term
		},

		reset() {
			this._term.reset()
			this._consoleBase()
		},

		_consoleBase() {
			this._term.writeln('Welcome to FLink-Sql Client')
			this._term.write('You can click on the connect button to connect to the FLink-Sql Client...')
		}
	}

	const Socket = {

		_socket: null,

		create() {
			if (this._socket) {
				this.close()
			}

			let protocol = window.location.protocol
			if (protocol.endsWith('http:')) {
				protocol = 'ws://'
			} else {
				protocol = 'wss://'
			}

			this._socket = new WebSocket(protocol + window.location.host + '/ssh')
			// this._socket = new WebSocket(protocol + window.location.hostname + ':8000/ssh')

			return this._socket
		},

		close() {
			if (this.is()) {
				this._socket.close()
				this._socket = null
			}
		},

		send(data) {
			this._socket.send(JSON.stringify(data))
		},

		is() {
			return this._socket !== null
		}

	}

	const term = Xterm.init()

	term.on('data', data => {
		if (!Socket.is()) {
			return
		}
		Socket.send({
			type: 'command',
			message: data
		})
	})

	document.getElementById('connectBtn').onclick = () => {
		const
			host = "192.168.0.102",
			port = 12315,
			username ="root",
			password ="xiaogu"

		term.reset()
		Socket.close()

		const socket = Socket.create()
		socket.onopen = () => {

			term.write(`Connecting to ${host}:${port}...`)
			Socket.send({
				type: 'connect',
				message: {
					host,
					port,
					username,
					password
				}
			})
			// 这里在连接后直接运行sql-client   注意要使用bash函数  不然sh文件会报错
			Socket.send({
				type: 'command',
				message: "bash /opt/module/flink/bin/sql-client.sh" //TODO：这里的命令需要再详细
			})

		}

		socket.onmessage = e => {
			if (e.data.endsWith("Connection failed.")) {
				Socket.close()
			}
			//TODO：这里需要添加功能 ： 如果推出sql-client客户端 则需要断开ssh连接
			else if(e.data.endsWith("^Z") ||e.data.endsWith("^C") ){
				Socket.close()
			}
			
			// 解决添加了cols属性后，文本超出时没有折行并将文本覆盖原有内容的bug
			if (e.data.length === 3) {
				term.write(e.data.trim())
			} else {
				term.write(e.data)	
			}
			
			term.focus()
		}
	}

})
