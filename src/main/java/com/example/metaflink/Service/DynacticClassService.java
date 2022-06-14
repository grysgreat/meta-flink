package com.example.metaflink.Service;

import com.example.metaflink.database.config.DynaticClass;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface DynacticClassService {

    public boolean InsertDynasticJavaClass(DynaticClass dynaticClass);

    public List<DynaticClass> ListAllDynasticclass();//查询全部的内容

    public boolean DeleteDynasticclass(Integer id);
}
