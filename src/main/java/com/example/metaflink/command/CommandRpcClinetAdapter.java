package com.example.metaflink.command;

import com.example.metaflink.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 进行指令的发送行为
 * TODO ： 需要结合log使用 记录各种信息
 */
@Service
@Slf4j
public class CommandRpcClinetAdapter {
    /**
     * 直接进行一个命令的发布
     * @attention : 不能执行交互式命令
     * @param command
     */
    public static String SubmitCommand(Command command)  {
       // Process pcs = Runtime.getRuntime().exec(command);
        //int rs = pcs.waitFor(); 返回进程id
        /**
         * Process 是执行进程的类
         */
        StringBuilder outs = new StringBuilder();
        log.info(" command ={} ", command);
        try {
            Process pcs = Runtime.getRuntime().exec(command.getCommandMsg());
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(pcs.getInputStream(), "gbk"));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                outs.append(line).append("\n");
            }
            int rs = pcs.waitFor();//TODO : 需要解决死锁
            if (rs != 0) {
                throw new RuntimeException("执行异常 is error  rs=" + rs);
            }
        }catch (IOException | RuntimeException | InterruptedException e){
            log.error("----------命令执行异常-----command-- " +command.getCommandMsg()+"--output--"+outs);
        }
        return outs.toString();

    }
}
