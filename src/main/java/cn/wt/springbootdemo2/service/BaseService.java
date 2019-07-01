package cn.wt.springbootdemo2.service;

import cn.wt.springbootdemo2.entity.BaseEntity;
import cn.wt.springbootdemo2.entity.PageView;
import cn.wt.springbootdemo2.mapper.BaseMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

public abstract class BaseService<T extends BaseEntity,M extends BaseMapper<T>>{

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private M dao;



/*    public PageView selectPage(PageView pageView) {
        return dao.getPageView(pageView);
    }*/

 //  @Transactional(priopagation = Propagaton.SUPPORTS)
    public List<T> selectList(T obj) {

        return dao.selectList(obj);
    }

    public T selectOne(Integer id) {

        return dao.selectOne(id);
    }

    public int update(T obj) {
        return dao.update(obj);
    }

    public int save(T obj){
        return dao.save(obj);
    }
    public int delete(Integer id) {
        return dao.delete(id);
    }

    public int delete(T obj) {
        return dao.delete(obj);
    }



}
