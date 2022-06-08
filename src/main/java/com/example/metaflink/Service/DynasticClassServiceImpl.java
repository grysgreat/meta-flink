package com.example.metaflink.Service;

import com.example.metaflink.database.config.DynaticClass;
import com.example.metaflink.mapper.DynasticClassMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DynasticClassServiceImpl implements DynacticClassService{


    @Autowired
    DynasticClassMapper dynasticClassMapper;
    @Override
    public boolean InsertDynasticJavaClass(DynaticClass dynaticClass) {
        return dynasticClassMapper.InsertDynasticJavaClass(dynaticClass);
    }

    @Override
    public List<DynaticClass> ListAllDynasticclass() {
        return dynasticClassMapper.ListAllDynasticclass();
    }

    @Override
    public boolean DeleteDynasticclass(Integer id) {
        return dynasticClassMapper.DeleteDynasticclass(id);
    }
}
