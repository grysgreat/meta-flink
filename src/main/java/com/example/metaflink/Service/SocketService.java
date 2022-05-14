package com.example.metaflink.Service;

import com.example.metaflink.database.config.RedisConfig1;
import com.example.metaflink.database.config.Socket;

import java.util.List;

public interface SocketService {
    public void InsertSocket(Socket socket);//增加表

    public List<Socket> ListAllSocket();//查询全部的表

    public Socket ListSocketById(Integer id);//根据表名来查询表

    public void DeleteSocketById(Integer id);//根据表名删除对应的表

    public void DeleteAllSocket();//删除全部的表

    public void UpdateSocket(Socket socket);
}
