package com.example.metaflink.Service;

import com.example.metaflink.database.config.DynaticClass;


import java.util.List;

public interface DynacticClassService {

    public boolean InsertDynasticJavaClass(DynaticClass dynaticClass);

    public List<DynaticClass> ListAllDynasticclass();//查询全部的内容

    public boolean DeleteDynasticclass(Integer id);
}
