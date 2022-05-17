package com.example.metaflink.mapper;

import com.example.metaflink.database.config.KafKAConfig;
import com.example.metaflink.database.config.RedisConfig1;
import org.apache.ibatis.annotations.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Mapper
public interface KafKAMapper {
    @Select("select * from test.KaFKA")
    public List<KafKAConfig> ListAllKafKAConfigs();//查询全部的内容
    @Insert("insert into test.KaFKA values (#{Url},#{DestPort},#{Topic})")
    @Transactional
    public void InsertKafKAConfig(KafKAConfig kaConfig);//增加数据库
    @Select("select * from test.KaFKA where Id=#{id}")
    public KafKAConfig ListKaFKAConfigById(Integer id);//根据表名来查询表
    @Update("Update test.KaFKA SET Id=#{Id}," +
            "Url=#{Url},DestPort=#{DestPort},Topic=#{Topic}" +
            " WHERE Id =#{Id}")
    @Transactional
    public void UpdateKaFKAConfigs(KafKAConfig kafKAConfig);//更新数据库
    @Delete("delete from test.KaFKA where Id=#{id}")
    @Transactional
    public boolean DeleteKaFKAConfigById(Integer id);//根据表名删除对应的表
    @Delete("delete  from test.KaFKA")
    @Transactional
    public boolean DeleteAllKaFKAConfig();//删除全部的表
}
