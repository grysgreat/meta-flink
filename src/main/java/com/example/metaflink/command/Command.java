package com.example.metaflink.command;

import lombok.Data;
import org.springframework.stereotype.Component;


import org.springframework.stereotype.Component;

/**
 * @author : luxian
 * @time : 22.04.28
 * @description 发送指令类
 *
 * 指令需要进行发送的时候的处理
 * 期望能处理为字符串的格式
 * command 到时候会有各种不同的类型 比如调用各种不同的库
 * 所以需要进行相关的配置
 *
 */
@Data
public class Command {
    String CommandMsg;
    public Command(String s){this.CommandMsg=s;}
}
