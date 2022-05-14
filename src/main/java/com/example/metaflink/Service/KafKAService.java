package com.example.metaflink.Service;

import com.example.metaflink.database.config.KafKAConfig;

import java.util.List;

public interface KafKAService {

    public List<KafKAConfig> FindAllKafKaConfigs();

    public KafKAConfig FindKafKaConfigById(Integer id);

    public void DeleteAllKafKAConfigs();

    public void DeleteKafKAConfigById(Integer id);

    public void InsertKafKAConfig(KafKAConfig kafKAConfig);

    public void UpdateKafKAConfig(KafKAConfig kaConfig);

}
