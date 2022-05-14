package com.example.metaflink.Service;

import com.example.metaflink.database.config.HdfsConfig;
import com.example.metaflink.mapper.HdfsConfigMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class HdfsConfigConfigImpl implements HdfsConfigService {

    @Autowired
    private HdfsConfigMapper hdfsConfigMapper;
    @Override
    public List<HdfsConfig> FindAllHdfsConfigs() {

        return hdfsConfigMapper.ListAllHdfsConfigs();
    }

    @Override
    public HdfsConfig FindHdfsConfigById(Integer id) {
        return hdfsConfigMapper.ListHdfsConfigById(id);
    }

    @Override
    public void DeleteAllHdfsConfigs() {
        hdfsConfigMapper.DeleteAllHdfsConfig();
    }

    @Override
    public void DeleteHdfsConfigsById(Integer id) {
        hdfsConfigMapper.DeleteHdfsConfigById(id);
    }

    @Override
    public void Insert(HdfsConfig hdfsConfig) {
        hdfsConfigMapper.InsertHdfsConfig(hdfsConfig);
    }

    @Override
    public void Update(HdfsConfig hdfsConfig) {
        hdfsConfigMapper.UpdateHdfsConfigs(hdfsConfig);
    }
}
