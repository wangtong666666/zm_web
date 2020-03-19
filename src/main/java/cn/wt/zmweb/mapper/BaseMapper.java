package cn.wt.zmweb.mapper;

import cn.wt.zmweb.entity.BaseEntity;


import java.util.List;


public interface BaseMapper<T extends BaseEntity> {

    public int save(T t);


    public int update(T t);


    public int delete(int id);



    public T  selectOne(Integer id);


    public List<T> selectList(T t);


    List<T> selectPage(T t);



}
