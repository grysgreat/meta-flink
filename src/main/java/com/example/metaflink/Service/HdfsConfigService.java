package com.example.metaflink.Service;

import com.example.metaflink.database.config.HdfsConfig;

import java.util.List;

public interface HdfsConfigService {
    public List<HdfsConfig> FindAllHdfsConfigs();

    public HdfsConfig FindHdfsConfigById(Integer id);

    public void DeleteAllHdfsConfigs();

    public void DeleteHdfsConfigsById(Integer id);

    public void Insert(HdfsConfig hdfsConfig);

    public void Update(HdfsConfig hdfsConfig);
}
