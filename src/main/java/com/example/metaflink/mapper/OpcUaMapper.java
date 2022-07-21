package com.example.metaflink.mapper;

import com.example.metaflink.database.config.OpcUaConfig;
import org.apache.ibatis.annotations.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Mapper
public interface OpcUaMapper {
    @Select("select * from test.opcua")
    List<OpcUaConfig> AllOpcUaConfig();

    @Select("select * from test.opcua where ID=#{id}")
    OpcUaConfig ListOpcUaConfigById(Integer id);

    @Insert("insert into test.opcua(serverUrl,userName,password,isAnonymous,identifier) " +
            "values (#{serverUrl},#{userName},#{password},#{isAnonymous},#{identifier})")
    @Transactional
    boolean InsertOpcUaConfig(OpcUaConfig opcUaConfig);

    @Delete("delete form test.opcua where Id=#{id}")
    boolean DeleteOpcUaConfigById(Integer id);

    @Update("update test.opcua set Id=#{id}," +
            "serverUrl=#{serverUrl}," +
            "userName=#{userName}," +
            "password=#{password}," +
            "isAnonymous=#{isAnonymous},"+
            "identifier=#{identifier}" +
            " where Id=#{id}")
    @Transactional
    boolean UpdateOpcUaConfig(OpcUaConfig opcUaConfig);
}
