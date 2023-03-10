package com.example.metaflink.controller;

import com.example.metaflink.Service.DataBaseConfigService;
import com.example.metaflink.Service.DynacticClassService;
import com.example.metaflink.database.config.DatabaseConfig;
import com.example.metaflink.database.config.DynaticClass;
import com.example.metaflink.database.config.Table;

import com.example.metaflink.util.DataBaseUtil;
import com.google.gson.Gson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@RequestMapping("/dbtoclass")
@CrossOrigin
public class DataBaseConfigToTableController {
    @Autowired
    private DataBaseConfigService dataBaseConfigService;
    @Autowired
    private DynacticClassService dynacticClassService;
    @RequestMapping(value = "/ChangeToTable/{id}",method = {RequestMethod.GET,RequestMethod.POST,RequestMethod.OPTIONS})
    public Table ChangeToTable(@PathVariable Integer id)
    {
        DatabaseConfig databaseConfig=dataBaseConfigService.ListDataBaseConfigById(id);//先根据id查
        DatabaseConfig dataBaseConfig1=new DatabaseConfig();
        dataBaseConfig1.setUrl("jdbc:mysql://"+databaseConfig.getUrl()+":"+databaseConfig.getPort().toString()+
                "/"+ databaseConfig.getBasename()+"?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8&useSSL=false");

        dataBaseConfig1.setPassword(databaseConfig.getPassword());
        dataBaseConfig1.setDriverClassName(databaseConfig.getDriverClassName());
        dataBaseConfig1.setUsername(databaseConfig.getUsername());
        dataBaseConfig1.setBasename(databaseConfig.getBasename());
        dataBaseConfig1.setTablename(databaseConfig.getTablename());
        JdbcTemplate jd = DataBaseUtil.getJdbcTemplate(dataBaseConfig1);
        Table table = null;
        try {
            table = DataBaseUtil.getTableMetaInfo(jd ,"select * from "+  dataBaseConfig1.getTablename(),null);
        } catch (SQLException ignored) {

        }
        if(table!=null){
            String javacontext = table.Convert2JavaObject();
            DynaticClass dynaticClass = new DynaticClass();
            dynaticClass.setClassName(table.getName());
            dynaticClass.setJavacontext(javacontext);
            this.dynacticClassService.InsertDynasticJavaClass(dynaticClass);
            return table;
        }
        return table;

    }


    @RequestMapping (value = "/jsontoclass",method = {RequestMethod.GET,RequestMethod.POST,RequestMethod.OPTIONS})
    public Table JsontoClass(@RequestParam(value = "metajson")  String metajson){
        Table jsontable = new Gson().fromJson(metajson,Table.class);
        jsontable.Convert2JavaObject();
        return jsontable;
    }
}
