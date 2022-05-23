package com.example.metaflink.Service;

import com.example.metaflink.database.config.JobFlow;

import java.util.List;

public interface JobFlowService {

    public  void InsertJobflow(JobFlow jobFlow);
    public List<JobFlow> SelectJobflow();
}
