
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
		},
		readyon(){
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
			console.log(JSON.stringify(data))
		},

		is() {
			return this._socket !== null
		}

	}

	const term = Xterm.init()
	/**
	 * 关于连接后自动进行连接
	 * 这里是解决方案一 用一个布尔值标识有没有进行sql-client客户端的启动
	 * @type {boolean}
	 */
    var sql_init =false;
	// document.getElementById('sql-init-Btn').onclick = ()=>{
	// 	Socket.send({
	// 		type: 'command',
	// 		message: "bash /opt/module/flink-1.13.2/bin/sql-client.sh\r\n" //TODO：这里的命令需要再详细
	// 	})
	// }
	$(document).ready(function(){
		const
			host = "localhost",
			port = 12315,
			username = "root",
			password = "xiaogu"
		term.reset()
		Socket.close()
		const socket = Socket.create()
		socket.onmessage = e => {
			console.log(e.data)
			if (e.data.endsWith("Connection failed.")) {
				Socket.close()
			}
		 // 解决添加了cols属性后，文本超出时没有折行并将文本覆盖原有内容的bug
			if (e.data.length === 3) {
				term.write(e.data.trim())
			}else if(e.data.toLocaleString().includes("已停止")){
				//用户主动关闭sql-client时，我们需要刷新页面
				//刷新页面
				location.reload();
			}else {
				term.write(e.data)
			}

			term.focus()
		}
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
		}
	})




	term.on('data', data => {
		if (!Socket.is()) {
			return
		}
		if(!sql_init){
			Socket.send({
				type: 'command',
				message: 'bash /opt/module/flink-1.13.2/bin/sql-client.sh\r'
			})
			sql_init=true;
			return
		}
		Socket.send({
			type: 'command',
			message: data
		})
	})


})