package com.example.metaflink.database.config;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserConfig {

    int id;

    String name;

    String pwd;

    int priority;

}
