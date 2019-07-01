package cn.wt.springbootdemo2.dao;

import cn.wt.springbootdemo2.entity.PmsPersonInfo;
import cn.wt.springbootdemo2.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public interface PmsPersonInfoDao extends BaseMapper<PmsPersonInfo> {


}
