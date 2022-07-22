package com.example.metaflink.controller;

import com.example.metaflink.database.config.RtmpConfig;
import com.example.metaflink.database.config.modbus.ModbusConfig;
import com.example.metaflink.mapper.ModbusMapper;
import com.example.metaflink.mapper.RtmpaRtspMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/modbus")
@CrossOrigin
public class ModBudController {

    @Autowired
    private ModbusMapper modbusMapper;
    @RequestMapping(value = "/all")
    public List<ModbusConfig> findAllModbus(){
        return modbusMapper.ListAllModbusConfig();
    }

    @RequestMapping(value = "/insert")
    public boolean InsertModbus(@RequestParam(value="url") String url,
                              @RequestParam(value ="port",required = false)Integer port,
                              @RequestParam(value ="data",required = false)String data){

        ModbusConfig modbusConfig = new ModbusConfig();
        modbusConfig.setPort(port);
        modbusConfig.setUrl(url);
        modbusConfig.setData(data);
        modbusMapper.InsertModbusConfig(modbusConfig);
        return true;
    }
    @RequestMapping(value = "/delete/{id}")
    public boolean DeleteModbus(@PathVariable Integer id){
        return modbusMapper.DeleteModbusConfig(id);
    }
}
