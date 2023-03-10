package com.example.metaflink.Service;

import com.example.metaflink.database.config.UserConfig;


import java.util.List;

public interface UserConfigService {


    public List<UserConfig> ListAllUser();//查询全部的内容


    public void InsertUser(UserConfig userConfig);//增加数据库


    public List<UserConfig>  ListUserByName(String name);//根据表名来查询表

    public List<UserConfig> ListUserByNameandPwd(String name,String pwd);//根据表名来查询表


    public boolean DeleteUserById(Integer id);//根据表名删除对应的表

    public boolean DeleteUserByName(String name);//根据表名删除对应的表

    public boolean DeleteAllUser();//删除全部的表

}
