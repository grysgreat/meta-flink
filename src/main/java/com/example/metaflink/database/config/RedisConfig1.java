package com.example.metaflink.database.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RedisConfig1 {

    private Integer Id;
    private  Integer port;
    private String Username;
    private String Password;
    private  String Url;
    private String Tablename;
    private  String Topic;
    public  String types = "redis";


    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getTablename() {
        return Tablename;
    }

    public void setTablename(String tablename) {
        Tablename = tablename;
    }

    public String getTopic() {
        return Topic;
    }

    public void setTopic(String topic) {
        Topic = topic;
    }

    @Override
    public String toString() {
        return "RedisConfig1{" +
                "Url='" + Url + '\'' +
                ", DestPort=" + port +
                ", Topic='" + Topic + '\'' +
                ", Id=" + Id +
                ", Username='" + Username + '\'' +
                ", Password='" + Password + '\'' +
                ", Tablename='" + Tablename + '\'' +
                '}';
    }
}
