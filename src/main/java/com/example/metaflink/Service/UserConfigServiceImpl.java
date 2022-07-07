package com.example.metaflink.Service;

import com.example.metaflink.database.config.UserConfig;
import com.example.metaflink.database.config.UserJobConfig;
import com.example.metaflink.mapper.UserConfigMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserConfigServiceImpl implements UserConfigService {

    @Autowired
    private UserConfigMapper userConfigMapper;
    @Override
    public List<UserConfig> ListAllUser() {
        return userConfigMapper.ListAllUser();
    }

    @Override
    public void InsertUser(UserConfig userConfig) {
        userConfigMapper.InsertUser(userConfig);
    }

    @Override
    public UserConfig ListUserById(int id) {
        return this.userConfigMapper.ListUserById(id);
    }

    @Override
    public boolean DeleteUserById(Integer id) {
        return this.userConfigMapper.DeleteUserById(id);
    }

    @Override
    public boolean DeleteAllUser() {
        return this.userConfigMapper.DeleteAllUser();
    }
}
