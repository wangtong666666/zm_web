package cn.wt.springbootdemo2.mapper;

import cn.wt.springbootdemo2.entity.BaseEntity;
import cn.wt.springbootdemo2.entity.PageView;
import com.github.pagehelper.Page;

import java.util.List;


public interface BaseMapper<T extends BaseEntity> {

    public int save(T t);


    public int update(T t);


    public int delete(int id);


    public int delete(T t);


    public T  selectOne(Integer id);


    public List<T> selectList(T t);


    Page<T> selectPage(T t);



}
