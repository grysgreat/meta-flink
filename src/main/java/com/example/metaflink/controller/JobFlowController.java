package com.example.metaflink.controller;

import com.example.metaflink.Service.JobFlowService;
import com.example.metaflink.Service.JobFlowServiceImpl;
import com.example.metaflink.database.config.JobFlow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/jobflow")
@CrossOrigin
public class JobFlowController {

    @Autowired
    private JobFlowService jobFlowService;

    @RequestMapping("/showall")
    public List<JobFlow> selectAlljobflow(){
        return jobFlowService.SelectJobflow();
    }
    @RequestMapping("/insert")
    public JobFlow insert(   @RequestParam(value = "jobid") String jobid,
                             @RequestParam(value = "jsondata") String jsondata){
        JobFlow jobFlow =new JobFlow(jobid,jsondata);
        jobFlowService.InsertJobflow(jobFlow);
        return jobFlow ;
    }
}
