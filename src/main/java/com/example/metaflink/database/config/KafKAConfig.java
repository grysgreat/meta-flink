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

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
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
    public  String types = "kafka";


    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types;
    }

    private String Url;
    private Integer port;
    private String Topic;
    private Integer Id;

    @Override
    public String toString() {
        return "KafKAConfig{" +
                "Url='" + Url + '\'' +
                ", DestPort=" + port +
                ", Topic='" + Topic + '\'' +
                ", Id=" + Id +
                '}';
    }
}
