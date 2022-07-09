package com.example.metaflink.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * {"jobs":[{"jid":"39b2e738ec5b1099a4cdb5e9e45c810c",
 * "name":"Click Event Count",
 * "state":"RUNNING",
 * "start-time":1657374564457,
 * "end-time":-1,
 * "duration":2365194,
 * "last-modification":1657376886152,
 * "tasks":
 *        {"total":3,
 *        "created":0,
 *        "scheduled":0,
 *        "deploying":0,
 *        "running":3,
 *        "finished":0,
 *        "canceling":0,
 *        "canceled":0,
 *        "failed":0,
 *        "reconciling":0,
 *        "initializing":0}
 *        }]}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlinkJob {
    @JSONField(name = "jid")
    String jid;

    @JSONField(name = "status")
    JobStatus status;

    @JSONField(name = "name")
    String name;

    @JSONField(name ="start-time")
    Long starTime;
    @JSONField(name ="end-time")
    Long endTime;
    @JSONField(name ="duration")
    Long duration;
    @JSONField(name ="last-modification")
    Long last_modification;

    @JSONField(name ="tasks")
    JobTask jobTask;
}
