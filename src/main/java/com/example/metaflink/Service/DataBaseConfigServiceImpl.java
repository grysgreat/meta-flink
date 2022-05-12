package com.example.metaflink.Service;

import com.example.metaflink.mapper.DataBaseConfigMapper;
import com.example.metaflink.database.config.DatabaseConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DataBaseConfigServiceImpl implements DataBaseConfigService {
    @Autowired
    private DataBaseConfigMapper dataBaseConfigMapper;
    @Override
    public void InsertDatabaseConfig(DatabaseConfig databaseConfig) {
            dataBaseConfigMapper.InsertDatabaseConfig(databaseConfig);
    }
    @Override
    public List<DatabaseConfig> ListAllDataBaseConfig() {
        return dataBaseConfigMapper.ListAllDataBaseConfig();
    }

    @Override
    public DatabaseConfig ListDataBaseConfigById(Integer id) {
        return dataBaseConfigMapper.ListDataBaseConfigById(id);
    }

    @Override
    public void DeleteDataBaseConfigById(Integer id) {
         dataBaseConfigMapper.DeleteDataBaseConfigById(id);
    }

    @Override
    public void DeleteAllDataBaseConfig() {
         dataBaseConfigMapper.DeleteAllDataBaseConfig();
    }

}
