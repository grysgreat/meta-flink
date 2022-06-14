package com.example.metaflink.controller;

import com.example.metaflink.Service.DataBaseConfigService;
import com.example.metaflink.Service.DynacticClassService;
import com.example.metaflink.database.config.DatabaseConfig;
import com.example.metaflink.database.config.DynaticClass;
import com.example.metaflink.database.config.Table;
import com.example.metaflink.util.DataBaseUtil;
import com.google.gson.Gson;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
@Api(tags="数据库到表转换管理")
@RestController
@RequestMapping("/dbtoclass")
@CrossOrigin
public class DataBaseConfigToTableController {
    @Autowired
    private DataBaseConfigService dataBaseConfigService;
    @Autowired
    private DynacticClassService dynacticClassService;
    @RequestMapping("/ChangeToTable/{id}")
    @ApiOperation(value = "根据id值将数据库信息转换成表单")
    public Table ChangeToTable(@PathVariable Integer id)
    {
        DatabaseConfig databaseConfig=dataBaseConfigService.ListDataBaseConfigById(id);//先根据id查
        DatabaseConfig dataBaseConfig1=new DatabaseConfig();
        dataBaseConfig1.setUrl("jdbc:mysql://"+databaseConfig.getUrl()+":"+databaseConfig.getPort().toString()+
                "/"+ databaseConfig.getBasename()+"?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8&useSSL=false");
        //        dc.setUrl("jdbc:mysql://192.168.73.139:3306/test?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8&useSSL=false");

        dataBaseConfig1.setPassword(databaseConfig.getPassword());
        dataBaseConfig1.setDriverClassName(databaseConfig.getDriverClassName());
        dataBaseConfig1.setUsername(databaseConfig.getUsername());
        dataBaseConfig1.setBasename(databaseConfig.getBasename());
        dataBaseConfig1.setTablename(databaseConfig.getTablename());
        JdbcTemplate jd = DataBaseUtil.getJdbcTemplate(dataBaseConfig1);
        Table table = null;
        try {
            table = DataBaseUtil.getTableMetaInfo(jd ,"select * from "+  dataBaseConfig1.getTablename(),null);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
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


    @PostMapping("/jsontoclass")
    @ApiOperation(value = "json转换为类")
    public Table JsontoClass(@RequestParam(value = "metajson")  String metajson){
        Table jsontable = new Gson().fromJson(metajson,Table.class);
        jsontable.Convert2JavaObject();//TODO: 先不做数据库存储了
        return jsontable;
    }
}
