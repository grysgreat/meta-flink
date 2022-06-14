package com.example.metaflink.controller;

import com.example.metaflink.Service.JobFlowService;
import com.example.metaflink.Service.JobFlowServiceImpl;
import com.example.metaflink.database.config.JobFlow;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Api(tags = "工作流管理")
@RestController
@RequestMapping(value="/jobflow")
@CrossOrigin
public class JobFlowController {

    @Autowired
    private JobFlowService jobFlowService;

    @RequestMapping("/showall")
    @ApiOperation(value = "获取工作流信息",notes = "获取全部工作流信息")
    public List<JobFlow> selectAlljobflow(){
        return jobFlowService.SelectJobflow();
    }
    @RequestMapping("/lookfor/{id}")
    @ApiOperation(value = "获取工作流信息",notes = "根据id值获取工作流信息")
    public JobFlow selectJobflowbyID(@PathVariable String id){
        return this.jobFlowService.SelectJobflowByid(id);
    };

    @RequestMapping("/insert")
    @ApiImplicitParams
    ({
                    @ApiImplicitParam(paramType = "query", dataType = "Long", name = "jobid", value = "job编号", required = true, example = "1"),
                    @ApiImplicitParam(paramType = "query", dataType = "String", name = "jsondata", value = "json数据", required = false)

    })
            @ApiOperation(value = "插入新的工作流信息",notes="根据传过来的工作流信息来插入一个新的工作流详细信息")
    public JobFlow insert(   @RequestParam(value = "jobid") String jobid,
                             @RequestParam(value = "jsondata") String jsondata){
        JobFlow jobFlow =new JobFlow(jobid,jsondata);
        jobFlowService.InsertJobflow(jobFlow);
        return jobFlow ;
    }
}
