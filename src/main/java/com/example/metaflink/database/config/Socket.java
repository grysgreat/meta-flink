package com.example.metaflink.database.config;

public class Socket {
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Socket{" +
                "url='" + url + '\'' +
                ", port=" + port +
                ", id=" + id +
                '}';
    }

    private Integer port;
    private Integer id;
}
