package com.example.metaflink.database.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KafKAConfig {
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

    private String Url;
    private Integer DestPort;
    private String Topic;
    private Integer Id;

    @Override
    public String toString() {
        return "KafKAConfig{" +
                "Url='" + Url + '\'' +
                ", DestPort=" + DestPort +
                ", Topic='" + Topic + '\'' +
                ", Id=" + Id +
                '}';
    }
}