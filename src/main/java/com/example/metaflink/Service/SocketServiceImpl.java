package com.example.metaflink.Service;

import com.example.metaflink.database.config.Socket;
import com.example.metaflink.mapper.SocketMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SocketServiceImpl implements SocketService{

    @Autowired
    private SocketMapper socketMapper;
    @Override
    public void InsertSocket(Socket socket) {
        socketMapper.InsertSocket(socket);
    }

    @Override
    public List<Socket> ListAllSocket() {
        return socketMapper.ListAllSocket();
    }

    @Override
    public Socket ListSocketById(Integer id) {
        return socketMapper.ListSocketById(id);
    }

    @Override
    public void DeleteSocketById(Integer id) {
        socketMapper.DeleteSocketById(id);
    }

    @Override
    public void DeleteAllSocket() {
        socketMapper.DeleteAllSocket();
    }

    @Override
    public void UpdateSocket(Socket socket) {
        socketMapper.UpdateSocket(socket);
    }
}
