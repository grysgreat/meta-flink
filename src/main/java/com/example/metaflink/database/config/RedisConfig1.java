package com.example.metaflink.database.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RedisConfig1 {

    private Integer Id;
    private String Username;
    private String Password;
    private  String Url;
    private  Integer DestPort;
    private String Tablename;
    private  String Topic;

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

    public Integer getDestPort() {
        return DestPort;
    }

    public void setDestPort(Integer destPort) {
        DestPort = destPort;
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
                ", DestPort=" + DestPort +
                ", Topic='" + Topic + '\'' +
                ", Id=" + Id +
                ", Username='" + Username + '\'' +
                ", Password='" + Password + '\'' +
                ", Tablename='" + Tablename + '\'' +
                '}';
    }
}
