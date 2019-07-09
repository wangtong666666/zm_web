package cn.wt.springbootdemo2.dao;

import cn.wt.springbootdemo2.entity.PmsPersonInfo;
import cn.wt.springbootdemo2.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PmsPersonInfoDao extends BaseMapper<PmsPersonInfo> {
}
