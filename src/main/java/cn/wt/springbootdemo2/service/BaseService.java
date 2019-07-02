package cn.wt.springbootdemo2.service;

import cn.wt.springbootdemo2.entity.BaseEntity;
import cn.wt.springbootdemo2.entity.PageView;
import cn.wt.springbootdemo2.entity.PmsPersonInfo;
import cn.wt.springbootdemo2.mapper.BaseMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;


public abstract class BaseService<T extends BaseEntity,M extends BaseMapper<T>>{

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    public M dao;



    public Page<T> selectPage(T model, int page, int rows, String sort, String order) {

        Page<T> pageHelper = PageHelper.startPage(page,rows,order);
        return dao.selectPage(model);
    }

    @Transactional
    public List<T> selectList(T obj) {

        return dao.selectList(obj);
    }
    @Transactional
    public T selectOne(Integer id) {

        return dao.selectOne(id);
    }
    @Transactional
    public int update(T obj) {
        return dao.update(obj);
    }
    @Transactional
    public int save(T obj){
        return dao.save(obj);
    }
    @Transactional
    public int delete(Integer id) {
        return dao.delete(id);
    }
    @Transactional
    public int delete(T obj) {
        return dao.delete(obj);
    }



}
