package com.example.metaflink;

import com.example.metaflink.Service.*;
import com.example.metaflink.database.config.*;
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
    HdfsConfigService hdfsConfigService;
    @Test
    void HdfsConfigTest() {
        HdfsConfig hd=new HdfsConfig();
        hd.setType("ababa");
        hd.setId(5);
        hd.setUrl("localhost");
        List<HdfsConfig>hdfsConfigs=hdfsConfigService.FindAllHdfsConfigs();
        for(HdfsConfig i:hdfsConfigs)
        {
            System.out.println(i);
        }
        System.out.println("------------The SelectAll Function has been tested!----------------");
        System.out.println(hdfsConfigService.FindHdfsConfigById(2));
        System.out.println("-------------The Select by id Function has been tested!-------------");
        hdfsConfigService.Insert(hd);
        List<HdfsConfig>hdfsConfigs1=hdfsConfigService.FindAllHdfsConfigs();
        for(HdfsConfig i:hdfsConfigs1)
        {
            System.out.println(i);
        }
        System.out.println("-------------The Insert Function has been tested!-------------");
        hdfsConfigService.DeleteHdfsConfigsById(2);
        List<HdfsConfig>hdfsConfigs2=hdfsConfigService.FindAllHdfsConfigs();
        for(HdfsConfig i:hdfsConfigs2)
        {
            System.out.println(i);
        }
        System.out.println("-------------The Delete By id Function has been tested!-------------");
        hdfsConfigService.DeleteAllHdfsConfigs();
        List<HdfsConfig>hdfsConfigs3=hdfsConfigService.FindAllHdfsConfigs();
        if(hdfsConfigs3==null)
            System.out.println("Empty!");
        else
        {
            for(HdfsConfig i:hdfsConfigs3)
            {
                System.out.println(i);
            }
        }
        System.out.println("-------------The DeleteAll Function has been tested!-------------");


    }
    @Autowired
    RedisService redisService;
    @Test
    void RedisConfigTest()
    {
        RedisConfig1 rd=new RedisConfig1();
        rd.setId(8);
        rd.setTablename("ababba");
        rd.setTopic("nanasnda");
        rd.setUrl("localhost");
        rd.setPassword("1145134");
        rd.setUsername("ashidhaosdhas");
        rd.setPort(112);
        List<RedisConfig1>redisConfig1s=redisService.ListAllRedisConfig();
        for(RedisConfig1 i:redisConfig1s)
        {
            System.out.println(i);
        }
        System.out.println("------------The SelectAll Function has been tested!----------------");
        System.out.println(redisService.ListRedisConfigById(2));
        System.out.println("-------------The Select by id Function has been tested!-------------");
        redisService.InsertRedis(rd);
        List<RedisConfig1>redisConfig1s1=redisService.ListAllRedisConfig();
        for(RedisConfig1 i:redisConfig1s1)
        {
            System.out.println(i);
        }
        System.out.println("-------------The Insert Function has been tested!-------------");
        redisService.DeleteRedisConfigById(3);
        List<RedisConfig1>redisConfig1s2=redisService.ListAllRedisConfig();
        for(RedisConfig1 i:redisConfig1s2)
        {
            System.out.println(i);
        }
        System.out.println("-------------The Delete By id Function has been tested!-------------");
        redisService.DeleteAllRedisConfig();
        List<RedisConfig1>redisConfig1s3=redisService.ListAllRedisConfig();
        if(redisConfig1s3==null)
            System.out.println("Empty!");
        else
        {
            for(RedisConfig1 i:redisConfig1s2)
            {
                System.out.println(i);
            }
        }
        System.out.println("-------------The DeleteAll Function has been tested!-------------");


    }
    @Autowired
    SocketService socketService;
    @Test
    void SocketTest()
    {
        Socket socket=new Socket();
        socket.setPort(111);
        socket.setId(5);
        socket.setUrl("asdasd");
        List<Socket>sockets=socketService.ListAllSocket();
        for(Socket i:sockets)
        {
            System.out.println(i);
        }
        System.out.println("------------The SelectAll Function has been tested!----------------");
        System.out.println(socketService.ListSocketById(2));
        System.out.println("-------------The Select by id Function has been tested!-------------");
        socketService.InsertSocket(socket);
        List<Socket>sockets1=socketService.ListAllSocket();
        for(Socket i:sockets)
        {
            System.out.println(i);
        }
        System.out.println("-------------The Insert Function has been tested!-------------");
        socketService.DeleteSocketById(2);
        List<Socket>sockets2=socketService.ListAllSocket();
        for(Socket i:sockets)
        {
            System.out.println(i);
        }
        System.out.println("-------------The Delete By id Function has been tested!-------------");
        socketService.DeleteAllSocket();
        List<Socket>sockets3=socketService.ListAllSocket();
        if(sockets3==null)
            System.out.println("Empty!");
        else
        {
            for(Socket i:sockets3)
            {
                System.out.println(i);
            }
        }
        System.out.println("-------------The DeleteAll Function has been tested!-------------");

    }
    @Autowired
    KafKAService kafKAService;
    @Test
    void KafKATest()
    {
        KafKAConfig kafKAConfig=new KafKAConfig();
        kafKAConfig.setId(5);
        kafKAConfig.setTopic("asdas");
        kafKAConfig.setPort(114);
        kafKAConfig.setUrl("localhost");
        List<KafKAConfig>kafKAConfigs=kafKAService.FindAllKafKaConfigs();
        for(KafKAConfig i:kafKAConfigs)
        {
            System.out.println(i);
        }
        System.out.println("------------The SelectAll Function has been tested!----------------");
        System.out.println(kafKAService.FindKafKaConfigById(2));
        System.out.println("-------------The Select by id Function has been tested!-------------");
        kafKAService.InsertKafKAConfig(kafKAConfig);
        List<KafKAConfig>kafKAConfigs1=kafKAService.FindAllKafKaConfigs();
        for(KafKAConfig i:kafKAConfigs1)
        {
            System.out.println(i);
        }
        System.out.println("-------------The Insert Function has been tested!-------------");
        kafKAService.DeleteKafKAConfigById(2);
        List<KafKAConfig>kafKAConfigs2=kafKAService.FindAllKafKaConfigs();
        for(KafKAConfig i:kafKAConfigs2)
        {
            System.out.println(i);
        }
        System.out.println("-------------The Delete By id Function has been tested!-------------");
        kafKAService.DeleteAllKafKAConfigs();
        List<KafKAConfig>kafKAConfigs3=kafKAService.FindAllKafKaConfigs();
        if(kafKAConfigs3==null)
            System.out.println("Empty!");
        else
        {
            for(KafKAConfig i:kafKAConfigs2)
            {
                System.out.println(i);
            }
        }
        System.out.println("-------------The DeleteAll Function has been tested!-------------");

    }
    @Autowired
    JobFlowService jobFlowService;
    @Test
    void JobFlowTest()
    {
        JobFlow jobFlow=new JobFlow();
        jobFlow.setJobid("01d6ed9ba6d646d0acfa66380aacd47a");
        jobFlow.setJobjson("sdadhaisdhaodhiad");
        jobFlow.setJsondata("asidhoahdoaid");
        List<JobFlow>jobFlows=jobFlowService.SelectJobflow();
        for(JobFlow i:jobFlows)
        {
            System.out.println(i);
        }
        System.out.println("------------The SelectAll Function has been tested!----------------");
        System.out.println(jobFlowService.SelectJobflowByid("01d6ed9ba6d646d0acfa66380aacd47f"));
        System.out.println("-------------The Select by id Function has been tested!-------------");
        jobFlowService.InsertJobflow(jobFlow);
        List<JobFlow>jobFlows1=jobFlowService.SelectJobflow();
        for(JobFlow i:jobFlows1)
        {
            System.out.println(i);
        }
        System.out.println("-------------The Insert Function has been tested!-------------");
    }







}
