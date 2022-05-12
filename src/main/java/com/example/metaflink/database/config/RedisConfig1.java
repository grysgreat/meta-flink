package com.example.metaflink.database.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RedisConfig1 {
    public String getIp() {
        return Ip;
    }

    public void setIp(String ip) {
        Ip = ip;
    }

    public Integer getDestport() {
        return DestPort;
    }

    public void setDestport(Integer destport) {
        DestPort = destport;
    }

    public String getTopic() {
        return Topic;
    }

    public void setTopic(String topic) {
        Topic = topic;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    private Integer Id;

    private  String Ip;
    private  Integer DestPort;
    private  String Topic;
    public String toString() {
        return "RedisConfig1{" +
                "Ip='" + Ip + '\'' +
                ", Destport='" + DestPort + '\'' +
                ", Topic='" + Topic +
                '}';
    }
}
