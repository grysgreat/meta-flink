package com.example.metaflink.controller;

import com.example.metaflink.Service.JobFlowService;
import com.example.metaflink.Service.JobFlowServiceImpl;
import com.example.metaflink.database.config.JobFlow;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/jobflow")
@CrossOrigin
public class JobFlowController {

    @Autowired
    private JobFlowService jobFlowService;

    @RequestMapping(value = "/showall",method = {RequestMethod.GET, RequestMethod.POST,RequestMethod.OPTIONS})
    public List<JobFlow> selectAlljobflow(){
        return jobFlowService.SelectJobflow();
    }
    @RequestMapping(value = "/lookfor/{id}",method = {RequestMethod.GET, RequestMethod.POST,RequestMethod.OPTIONS})
    public JobFlow selectJobflowbyID(@PathVariable String id){
        return this.jobFlowService.SelectJobflowByid(id);
    };

    @RequestMapping(value = "/insert",method = {RequestMethod.GET, RequestMethod.POST,RequestMethod.OPTIONS})
    public JobFlow insert(   @RequestParam(value = "jobid") String jobid,
                             @RequestParam(value = "jsondata") String jsondata,
                        @RequestParam(value = "jobjson") String jobjson){
        JobFlow jobFlow =new JobFlow(jobid,jsondata ,jobjson);
        jobFlowService.InsertJobflow(jobFlow);
        return jobFlow ;
    }
}
