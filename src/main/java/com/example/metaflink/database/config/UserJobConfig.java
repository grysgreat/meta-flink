package com.example.metaflink.database.config;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserJobConfig {

    int id;

    String jobId;

    int userId;

}
