package com.example.metaflink.database.query;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TableQuery {
    private Integer pageNum=1;  //当前页码
    private Integer pagesize=4; //每页显示的数量
    private String name;    //根据表名查询


}
