package com.example.metaflink.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.metaflink.entity.FlinkJob;
import com.example.metaflink.mapper.UserJobConfigMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FlinkMiddleware {

    @Value("${flink.baseurl}")
    private String flinkurl ;

    @Autowired
    private  RestTemplate restTemplate;
    
    @Autowired
    private UserJobConfigMapper userJobConfigMapper;

    public List<FlinkJob> GetAllJobListApi(int userid){
        //{"jobs":[{"id":"73564e22205d5eebeb0de5e0e66e26a9","status":"RUNNING"}]}
        String result = restTemplate.getForObject(flinkurl+"/jobs/overview", String.class);
        JSONObject jobs = JSON.parseObject(result);
        List<String> userjobs = this.userJobConfigMapper.ListJobidByuserid(userid);
        List<FlinkJob> alljobs = JSON.parseArray(jobs.getString("jobs"),FlinkJob.class);
        alljobs.removeIf(job -> !userjobs.contains(job.getJid()));
        return alljobs;
    }

}
