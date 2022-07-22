package com.example.metaflink.database.config.modbus;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModbusConfig {
    private Integer port;
    private Integer id;
    private String url;
    private String data;
    private String types="modbus";
}
