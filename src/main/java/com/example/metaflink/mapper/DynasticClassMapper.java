package com.example.metaflink.mapper;

import com.example.metaflink.database.config.DatabaseConfig;
import com.example.metaflink.database.config.DynaticClass;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Mapper
public interface DynasticClassMapper {
    @Insert("insert into test.dynasticclass(Classname,javacontext) values (#{ClassName},#{javacontext})")
    @Transactional
    public boolean InsertDynasticJavaClass(DynaticClass dynaticClass);

    @Select("select * from test.dynasticclass")
    public List<DynaticClass> ListAllDynasticclass();//查询全部的内容

    @Delete("delete from test.dynasticclass where id=#{id}")
    @Transactional
    public boolean DeleteDynasticclass(Integer id);
}
