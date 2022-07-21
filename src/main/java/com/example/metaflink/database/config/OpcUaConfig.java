package com.example.metaflink.database.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OpcUaConfig {
    private Integer id;
    //服务器地址
    private String serverUrl;
    //用户名
    private String userName;
    //密码
    private String password;
    //是否为匿名登录，匿名登录则为true，反之为false
    private Boolean isAnonymous;
    //数据标识符
    private String identifier;

    public  String types = "opcua";
}
