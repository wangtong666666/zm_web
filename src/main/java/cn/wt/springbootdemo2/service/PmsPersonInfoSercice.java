package cn.wt.springbootdemo2.service;

import cn.wt.springbootdemo2.dao.PmsPersonInfoDao;
import cn.wt.springbootdemo2.entity.PmsPersonInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PmsPersonInfoSercice {
    @Autowired
    private PmsPersonInfoDao pmsPersonInfoDao;

    public PmsPersonInfo selectOne(Integer id){
        return pmsPersonInfoDao.selectOne(id);
    }

    public boolean save(PmsPersonInfo personInfo){
        return pmsPersonInfoDao.save(personInfo);
    }

}
