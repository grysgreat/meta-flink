package com.example.metaflink.mapper;

import com.example.metaflink.database.config.HdfsConfig;
import com.example.metaflink.database.config.KafKAConfig;
import org.apache.ibatis.annotations.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Mapper
public interface HdfsConfigMapper {
    @Select("select * from test.Hdfs")
    public List<HdfsConfig> ListAllHdfsConfigs();//查询全部的内容
    @Insert("insert into test.Hdfs values (#{url})")
    @Transactional
    public void InsertHdfsConfig(HdfsConfig hdfsConfig);//增加数据库
    @Select("select * from test.Hdfs where Id=#{id}")
    public HdfsConfig ListHdfsConfigById(Integer id);//根据表名来查询表
    @Update("Update test.Hdfs SET Id=#{id}," +
            "url=#{url}" +
            " WHERE Id =#{id}")
    @Transactional
    public void UpdateHdfsConfigs(HdfsConfig hdfsConfig);//更新数据库
    @Delete("delete from test.Hdfs where Id=#{id}")
    @Transactional
    public boolean DeleteHdfsConfigById(Integer id);//根据表名删除对应的表
    @Delete("delete  from test.Hdfs")
    @Transactional
    public boolean DeleteAllHdfsConfig();//删除全部的表
}
