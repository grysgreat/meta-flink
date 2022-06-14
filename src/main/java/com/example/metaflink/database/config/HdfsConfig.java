package com.example.metaflink.database.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HdfsConfig {

    public  String types = "text";


    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private String url;
    private Integer id;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    private String type;


    @Override
    public String toString() {
        return "HdfsConfig{" +
                "url='" + url + '\'' +
                ", id=" + id +
                ", type='" + type + '\'' +
                '}';
    }
}
