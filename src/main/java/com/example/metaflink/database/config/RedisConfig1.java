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
        return Destport;
    }

    public void setDestport(Integer destport) {
        Destport = destport;
    }

    public String getTopic() {
        return Topic;
    }

    public void setTopic(String topic) {
        Topic = topic;
    }

    private  String Ip;
    private  Integer Destport;
    private  String Topic;
    public String toString() {
        return "RedisConfig1{" +
                "Ip='" + Ip + '\'' +
                ", Destport='" + Destport + '\'' +
                ", Topic='" + Topic +
                '}';
    }
}
