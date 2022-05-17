package com.example.metaflink.controller;

import com.example.metaflink.Service.DataBaseConfigService;
import com.example.metaflink.database.config.DatabaseConfig;
import com.example.metaflink.database.config.Table;
import com.example.metaflink.util.DataBaseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@RequestMapping("/DataBaseConfigToTable")
@CrossOrigin
public class DataBaseConfigToTableController {

    /*@RequestMapping("/ChangeToTable")
    public Table ChangeToTable(@RequestParam(value = "DriverClassName")String driverClassName,
                               @RequestParam(value ="Password")String password,
                               @RequestParam(value = "Username")String username,
                               @RequestParam(value = "Ip")String ip,
                               @RequestParam(value = "Port")String port,
                               @RequestParam(value = "DataBasename")String dataBasename,
                               @RequestParam(value = "ServerTimezone")String serverTimezone,
                               @RequestParam(value = "UseUnicode")boolean useUnicode,
                               @RequestParam(value = "CharacterEncoding")String characterEncoding,
                               @RequestParam(value = "UseSSL")boolean useSSL)
    {
        DatabaseConfig dc = new DatabaseConfig();
        String url="jdbc:mysql://"+ip+":"+port+"/"+dataBasename+"?"+
                "serverTimezone="+serverTimezone+"&useUnicode="+useUnicode+
                "&characterEncoding="+characterEncoding+"&useSSL="+useSSL;
        dc.setDriverClassName(driverClassName);
        dc.setUsername(username);
        dc.setPassword(password);
        dc.setUrl(url);
        JdbcTemplate jd = DataBaseUtil.getJdbcTemplate(dc);
        Table table = null;
        try {
            table = DataBaseUtil.getTableMetaInfo(jd ,"select * from redis",null);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return table;



    }*/
    @Autowired
    private DataBaseConfigService dataBaseConfigService;
    @RequestMapping("/ChangeToTable/{id}")
    public Table ChangeToTable(@PathVariable Integer id)
    {
        DatabaseConfig databaseConfig=dataBaseConfigService.ListDataBaseConfigById(id);//先根据id查
        DatabaseConfig dataBaseConfig1=new DatabaseConfig();
        dataBaseConfig1.setUrl(databaseConfig.getUrl());
        dataBaseConfig1.setPassword(databaseConfig.getPassword());
        dataBaseConfig1.setDriverClassName(databaseConfig.getDriverClassName());
        dataBaseConfig1.setUsername(databaseConfig.getUsername());
        JdbcTemplate jd = DataBaseUtil.getJdbcTemplate(dataBaseConfig1);
        Table table = null;
        try {
            table = DataBaseUtil.getTableMetaInfo(jd ,"select * from redis",null);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return table;

    }

}
