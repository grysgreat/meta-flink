package com.example.metaflink.mapper;

import com.example.metaflink.database.config.Socket;
import com.example.metaflink.database.config.modbus.ModbusConfig;
import org.apache.ibatis.annotations.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Mapper
public interface ModbusMapper {
    @Select("select * from test.modbus")
    public List<ModbusConfig> ListAllModbusConfig();//查询全部的内容

    @Insert("insert into test.modbus values (#{id},#{port},#{data},#{url})")
    @Transactional
    public void InsertModbusConfig(ModbusConfig ModbusConfig);//增加数据库

    @Delete("delete from test.modbus where Id=#{id}")
    @Transactional
    public boolean DeleteModbusConfig(Integer id);//根据表名删除对应的表

}
