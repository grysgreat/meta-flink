package com.example.metaflink.mapper;

import com.example.metaflink.database.config.UserConfig;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Mapper
public interface UserConfigMapper {

    @Select("select * from test.user")
    public List<UserConfig> ListAllUser();//查询全部的内容


    @Insert("insert into test.user values (#{id},#{name}, #{pwd},#{priority})")
    @Transactional
    public void InsertUser(UserConfig userConfig);//增加数据库


    @Select("select * from test.user where name=#{name}")
    public List<UserConfig> ListUserByName(String name);//根据表名来查询表


    @Delete("delete from test.user where id=#{id}")
    @Transactional
    public boolean DeleteUserById(Integer id);//根据表名删除对应的表


    @Delete("delete from test.user")
    @Transactional
    public boolean DeleteAllUser();//删除全部的表


}
