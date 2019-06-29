package cn.wt.springbootdemo2.dao;

import cn.wt.springbootdemo2.entity.PmsPersonInfo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class PmsPersonInfoDao {
    private final ConcurrentMap<Integer, PmsPersonInfo> personMap = new ConcurrentHashMap<>();

    private final static AtomicInteger idGen = new AtomicInteger();

    public boolean save(PmsPersonInfo person){

        Integer id  = idGen.incrementAndGet();
        person.setId(id);
        personMap.put(id,person);
        return  personMap.put(id,person)==null;
}


    public PmsPersonInfo selectOne(Integer id){
        return personMap.get(id);
    }

}
