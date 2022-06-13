package com.example.metaflink.controller;

import com.example.metaflink.Service.JobFlowService;
import com.example.metaflink.Service.JobFlowServiceImpl;
import com.example.metaflink.database.config.JobFlow;
import com.sun.tools.corba.se.idl.IncludeGen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @RequestMapping("/lookfor/{id}")
    public JobFlow selectJobflowbyID(@PathVariable String id){
        return this.jobFlowService.SelectJobflowByid(id);
    };

    @RequestMapping("/insert")
    public JobFlow insert(   @RequestParam(value = "jobid") String jobid,
                             @RequestParam(value = "jsondata") String jsondata){
        JobFlow jobFlow =new JobFlow(jobid,jsondata);
        jobFlowService.InsertJobflow(jobFlow);
        return jobFlow ;
    }
}
