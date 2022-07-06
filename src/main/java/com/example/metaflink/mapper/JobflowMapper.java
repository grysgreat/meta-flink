package com.example.metaflink.mapper;


import com.example.metaflink.database.config.JobFlow;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface JobflowMapper {


    @Insert("INSERT INTO  test.jobflow values(#{jobid},#{jsondata})")
    public void InsertJobflow(JobFlow jobFlow);

    @Select("SELECT * FROM test.jobflow")
    public List<JobFlow> SelectJobflow();
}
