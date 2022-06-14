package com.example.metaflink.database.config;

public class JobFlow {
    private String jobid;
    private  String jsondata;
    private String jobjson;

    public JobFlow(String jobid, String jsondata, String jobjson) {
        this.jobid = jobid;
        this.jsondata = jsondata;
        this.jobjson = jobjson;
    }

    public String getJobjson() {
        return jobjson;
    }

    public void setJobjson(String jobjson) {
        this.jobjson = jobjson;
    }

    public String getJobid() {
        return jobid;
    }

    public void setJobid(String jobid) {
        this.jobid = jobid;
    }

    public String getJsondata() {
        return jsondata;
    }

    public JobFlow(String jobid, String jsondata) {
        this.jobid = jobid;
        this.jsondata = jsondata;
    }
    public JobFlow() {
    }

    public void setJsondata(String jsondata) {
        this.jsondata = jsondata;
    }
}
