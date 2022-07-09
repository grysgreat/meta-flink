package com.example.metaflink;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.metaflink.entity.FlinkJob;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@SpringBootTest
public class HttpRestModuleTest {
    @Autowired
    private RestTemplate restTemplate;
    @Test
    public void testDemoforflink1(){
        /**
         * getForObject
         *
         * 参数1 要请求的地址的url  必填项
         * 参数2 响应数据的类型 是String 还是 Map等 必填项
         * 参数3 请求携带参数 选填
         *
         * getForObject 方法的返回值就是 被调用接口响应的数据
         */
        String result = restTemplate.getForObject("http://100.132.0.91:8081/config", String.class);

        System.out.println(result);
    }
    @Value("${flink.baseurl}")
    private String flinkurl ;
    @Test
    public void testJobListApi(){
        //{"jobs":[{"id":"73564e22205d5eebeb0de5e0e66e26a9","status":"RUNNING"}]}
        String result = "{\"jobs\":[{\"jid\":\"39b2e738ec5b1099a4cdb5e9e45c810c\",\"name\":\"Click Event Count\",\"state\":\"RUNNING\",\"start-time\":1657374564457,\"end-time\":-1,\"duration\":2365194,\"last-modification\":1657376886152,\"tasks\":{\"total\":3,\"created\":0,\"scheduled\":0,\"deploying\":0,\"running\":3,\"finished\":0,\"canceling\":0,\"canceled\":0,\"failed\":0,\"reconciling\":0,\"initializing\":0}}]}";
        JSONObject jobs = JSON.parseObject(result);
        List<FlinkJob> jobsarray = JSON.parseArray(jobs.getString("jobs"),FlinkJob.class);
        String output = JSON.toJSONString(jobsarray);
        System.out.println(output);
    }
}
