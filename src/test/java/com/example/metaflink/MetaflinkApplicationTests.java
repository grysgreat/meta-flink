package com.example.metaflink;

import com.example.metaflink.command.Command;
import com.example.metaflink.command.CommandRpcClinetAdapter;
import com.example.metaflink.database.config.DatabaseConfig;
import com.example.metaflink.database.config.MetaInfo;
import com.example.metaflink.database.config.Table;
import com.example.metaflink.util.DataBaseUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.IOException;
import java.sql.SQLException;

@SpringBootTest
class MetaflinkApplicationTests {

    @Test
    void contextLoads() {
    }

    /**
     * @transation： 命令执行的测试
     * @throws IOException
     * @throws InterruptedException
     */
    @Test
    void processcommand() throws IOException, InterruptedException {
        Command c = new Command("ping www.baidu.com");
        String out = CommandRpcClinetAdapter.SubmitCommand(c);
        System.out.println(out);
    }

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
    @Test
    void testdatabase() throws SQLException {
        DatabaseConfig dc = new DatabaseConfig();
        dc.setDriverClassName("com.mysql.jdbc.Driver");
        dc.setPassword("123456");
        dc.setUsername("root");
        dc.setUrl("jdbc:mysql://localhost:13306/test?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8&useSSL=false");

        JdbcTemplate jd = DataBaseUtil.getJdbcTemplate(dc);
        MetaInfo metaInfo =DataBaseUtil.getMetaInfo(jd ,"select * from student",null);
        System.out.println(metaInfo);

        Table table = DataBaseUtil.getTableMetaInfo(jd ,"select * from student",null);
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





}
