package com.example.metaflink;

import com.example.metaflink.Service.DataBaseConfigServiceImpl;
import com.example.metaflink.Service.UserConfigService;
import com.example.metaflink.database.config.*;
import com.example.metaflink.mapper.UserConfigMapper;
import com.example.metaflink.mapper.UserJobConfigMapper;
import com.example.metaflink.util.ClassRuner;
import com.example.metaflink.util.DataBaseUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;


import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@SpringBootTest
class MetaflinkApplicationTests {

    @Test
    void contextLoads() {
        System.out.println("Hello world!");
    }

    /**
     * @transation： 命令执行的测试
     * @throws IOException
     * @throws InterruptedException
     */



    /**
     * @transation： 元数据处理测试
     * @throws SQLException
     * @result : 成功@@@@@@！！！！！！！！
     * MetaInfo{column=[
     * Field{name='id', typeName='INT', type=4, pk=true},
     * Field{name='name', typeName='VARCHAR', type=12, pk=false},
     * Field{name='birth', typeName='DATE', type=91, pk=false}],
     * count=1}
     *
     * Table{name='student',
     * column=[Field{name='id', typeName='INT', type=4, pk=true},
     * Field{name='name', typeName='VARCHAR', type=12, pk=false},
     * Field{name='birth', typeName='DATE', type=91, pk=false}],
     * count=3}
     */

    void testdatabase() throws SQLException {
        DatabaseConfig dc = new DatabaseConfig();
        dc.setDriverClassName("com.mysql.jdbc.Driver");
        dc.setPassword("123456");
        dc.setUsername("root");
        dc.setUrl("jdbc:mysql://localhost:3306/test?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8&useSSL=false");

        JdbcTemplate jd = DataBaseUtil.getJdbcTemplate(dc);
        MetaInfo metaInfo =DataBaseUtil.getMetaInfo(jd ,"select * from redis",null);
        System.out.println(metaInfo);

        Table table = DataBaseUtil.getTableMetaInfo(jd ,"select * from redis",null);
        System.out.println(table);
    }


    /**
     * @attention: !!!!! 需要给java包添加 tool.jar 包
     * 位置在 /jre/lib/tool.jar
     * @throws Exception
     */
    @Test
    void clasrunertest() throws Exception {
        String sourcse = "import java.util.Arrays;" +
                "public class Main" +
                "{" +
                "public static void main(String[] args) {" +
                "System.out.println(Arrays.toString(args));" +
                "}" +
                "}";
        ClassRuner.run(sourcse, "1", "2");
    }
    @Autowired
    DataBaseConfigServiceImpl dataBaseConfigService;

    void DataBaseConfigtest() throws SQLException {
        DatabaseConfig dc = new DatabaseConfig();
        dc.setDriverClassName("com.mysql");
        dc.setPassword("123456");
        dc.setUsername("nidefuqin");
        dc.setUrl("localhost");
        //dc.setId((long)(8));
        dc.setSql("abababab");
        //测试列出全部DataBaseConfig的信息
        List<DatabaseConfig>databaseConfigs=dataBaseConfigService.ListAllDataBaseConfig();
        for(DatabaseConfig i:databaseConfigs)
        {
            System.out.println(i);
        }
        System.out.println("------------The SelectAll Function has been tested!----------------");
        //测试根据id列出DataBaseConfig的信息
        System.out.println(dataBaseConfigService.ListDataBaseConfigById(2));
        System.out.println("-------------The Select by id Function has been tested!-------------");
        //测试插入操作
        dataBaseConfigService.InsertDatabaseConfig(dc);
        List<DatabaseConfig>databaseConfigs1=dataBaseConfigService.ListAllDataBaseConfig();
        for(DatabaseConfig i:databaseConfigs1)
        {
            System.out.println(i);
        }
        System.out.println("-------------The Insert Function has been tested!-------------");
        dataBaseConfigService.DeleteDataBaseConfigById(4);
        List<DatabaseConfig>databaseConfigs2=dataBaseConfigService.ListAllDataBaseConfig();
        for(DatabaseConfig i:databaseConfigs2)
        {
            System.out.println(i);
        }
        System.out.println("-------------The Delete By id Function has been tested!-------------");
        dataBaseConfigService.DeleteAllDataBaseConfig();
        List<DatabaseConfig>databaseConfigs3=dataBaseConfigService.ListAllDataBaseConfig();
        if(databaseConfigs3==null)
            System.out.println("Empty!");
        else
        {
            for(DatabaseConfig i:databaseConfigs3)
            {
                System.out.println(i);
            }
        }
        System.out.println("-------------The DeleteAll Function has been tested!-------------");



    }

    @Autowired
    UserConfigMapper userConfigMapper;

    @Test
    void test() throws Exception {
        List<UserConfig> users = userConfigMapper.ListAllUser();
        for (UserConfig user : users) {
            System.out.println(user);
        }
    }

    @Autowired
    UserJobConfigMapper userJobConfigMapper;

    @Test
    void test2() throws Exception {
        List<UserJobConfig> users = userJobConfigMapper.ListJobById(1233);
        for (UserJobConfig user : users) {
            System.out.println(user);
        }

        UserJobConfig userJobConfig = new UserJobConfig();
        userJobConfig.setUserId(1233);
        userJobConfig.setJobId("wqseewwqe");
        userJobConfigMapper.InsertJob(userJobConfig);
    }

    @Test
    void TestJobidUserNAme(){
        String jobid ="wqe";
        String username = this.userJobConfigMapper.FindJobuser(jobid);
        if(username!=null){
            System.out.println(username);
        }
    }

    @Autowired
    UserConfigService userConfigService;

    @Test
    void test3() throws Exception {
        List<UserConfig> userConfigs = userConfigService.ListUserByName("a");
        System.out.println(userConfigs.size());
        System.out.println(userConfigs.get(0));
    }

}
