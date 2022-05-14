package com.example.metaflink.Service;

import com.example.metaflink.database.config.KafKAConfig;
import com.example.metaflink.mapper.KafKAMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class KafKAServiceImpl implements KafKAService{

    @Autowired
    private KafKAMapper kafKAMapper;
    @Override
    public List<KafKAConfig> FindAllKafKaConfigs() {

        return kafKAMapper.ListAllKafKAConfigs();
    }

    @Override
    public KafKAConfig FindKafKaConfigById(Integer id) {
        return kafKAMapper.ListKaFKAConfigById(id);
    }

    @Override
    public void DeleteAllKafKAConfigs() {
        kafKAMapper.DeleteAllKaFKAConfig();
    }

    @Override
    public void DeleteKafKAConfigById(Integer id) {
        kafKAMapper.DeleteKaFKAConfigById(id);
    }

    @Override
    public void InsertKafKAConfig(KafKAConfig kafKAConfig) {
        kafKAMapper.InsertKafKAConfig(kafKAConfig);
    }

    @Override
    public void UpdateKafKAConfig(KafKAConfig kaConfig) {
        kafKAMapper.UpdateKaFKAConfigs(kaConfig);
    }
}
