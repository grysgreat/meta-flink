package com.example.metaflink.mapper;


import com.example.metaflink.database.config.JobFlow;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface JobflowMapper {


    @Insert("INSERT INTO  test.jobflow values(#{jobid},#{jsondata},#{jobjson})")
    public void InsertJobflow(JobFlow jobFlow);

    @Select("SELECT * FROM test.jobflow")
    public List<JobFlow> SelectJobflow();

    @Select("SELECT * FROM test.jobflow where jobid =#{id}")
    public JobFlow SelectJobflowBYid(String id);
}
