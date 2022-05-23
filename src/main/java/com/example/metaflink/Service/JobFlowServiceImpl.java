package com.example.metaflink.Service;

import com.example.metaflink.database.config.JobFlow;
import com.example.metaflink.mapper.JobflowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class JobFlowServiceImpl implements JobFlowService{


    @Autowired
    private  JobflowMapper jobflowMapper;

    @Override
    public void InsertJobflow(JobFlow jobFlow) {
        jobflowMapper.InsertJobflow(jobFlow);
    }

    @Override
    public List<JobFlow> SelectJobflow() {
        return this.jobflowMapper.SelectJobflow();
    }
}
