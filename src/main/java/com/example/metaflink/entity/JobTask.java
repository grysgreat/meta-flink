package com.example.metaflink.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * "tasks":
 *  *        {"total":3,
 *  *        "created":0,
 *  *        "scheduled":0,
 *  *        "deploying":0,
 *  *        "running":3,
 *  *        "finished":0,
 *  *        "canceling":0,
 *  *        "canceled":0,
 *  *        "failed":0,
 *  *        "reconciling":0,
 *  *        "initializing":0}
 *  *        }]}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobTask {
       int total;
       int created;
       int scheduled;
       int deploying;
       int running;
       int finished;
       int canceling;
       int canceled;
       int failed;
       int reconciling;
       int initializing;
}
