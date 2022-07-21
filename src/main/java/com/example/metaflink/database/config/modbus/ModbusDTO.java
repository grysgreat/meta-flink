package com.example.metaflink.database.config.modbus;

import java.util.List;

public class ModbusDTO {
    private Integer port;
    private Integer id;
    private String types="modbus";
    private List<ModbusData> dataList;

    public ModbusDTO() {}

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

    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types;
    }

    public List<ModbusData> getDataList() {
        return dataList;
    }

    public void setDataList(List<ModbusData> dataList) {
        this.dataList = dataList;
    }
}
