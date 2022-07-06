package com.example.metaflink.mapper;

import com.example.metaflink.database.config.UserConfig;
import com.example.metaflink.database.config.UserJobConfig;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Mapper
public interface UserJobConfigMapper {

    @Select("select * from test.userjob")
    public List<UserJobConfig> ListAllJob();//查询全部的内容


    @Insert("insert into test.userjob values (#{id},#{jobId}, #{userId})")
    @Transactional
    public void InsertJob(UserJobConfig userConfig);//增加数据库


    @Select("select * from test.userjob where userId=#{userId}")
    public UserJobConfig ListJobById(int userId);//根据表名来查询表


    @Delete("delete from test.userjob where jobId=#{jobId}")
    @Transactional
    public boolean DeleteJobById(String jobId);//根据表名删除对应的表


}
