package com.example.metaflink.mapper;

import com.example.metaflink.database.config.RtmpConfig;
import com.example.metaflink.database.config.RtspConfig;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface RtmpaRtspMapper {
    @Select("select * from test.rtmp")
    List<RtmpConfig> AllRtmpConfig();
    @Select("select * from test.rtsp")
    List<RtspConfig> AllRtspConfig();

    @Insert("insert into test.rtmp(Url) values (#{Url})")
    boolean InsertRtmp(String Url);
    @Insert("insert into test.rtsp(Url) values (#{Url})")
    boolean InsertRtsp(String Url);

    @Delete("delete from test.rtmp where Id=#{id}")
    boolean DeleteRtmp(Integer id);
    @Delete("delete from test.rtsp where Id=#{id}")
    boolean DeleteRtsp(Integer id);

    @Update("Update test.rtmp SET Url=#{url}"+
            " WHERE Id =#{id}")
    boolean updateRtmp(RtmpConfig rtmpConfig);
    @Update("Update test.rtmp SET Url=#{url}"+
            " WHERE Id =#{id}")
    boolean updateRtsp(RtspConfig rtspConfig);
}
