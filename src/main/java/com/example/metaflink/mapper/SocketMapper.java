package com.example.metaflink.mapper;
import com.example.metaflink.database.config.Socket;
import org.apache.ibatis.annotations.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Mapper
public interface SocketMapper {
    @Select("select * from test.Sockets")
    public List<Socket> ListAllSocket();//查询全部的内容
    @Insert("insert into test.Sockets values (#{port}, #{url})")
    @Transactional
    public void InsertSocket(Socket socket);//增加数据库
    @Select("select * from test.Sockets where Id=#{id}")
    public Socket ListSocketById(Integer id);//根据表名来查询表
    @Delete("delete from test.Sockets where Id=#{id}")
    @Transactional
    public boolean DeleteSocketById(Integer id);//根据表名删除对应的表
    @Delete("delete  from test.Sockets")
    @Transactional
    public boolean DeleteAllSocket();//删除全部的表

    @Update("Update test.Sockets SET id=#{id}," +
            "port=#{port},url=#{url}"+
            " WHERE id =#{id}")
    @Transactional
    public void UpdateSocket(Socket socket);
}
