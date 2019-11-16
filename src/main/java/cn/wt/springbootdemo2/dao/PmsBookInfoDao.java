
package cn.wt.springbootdemo2.dao;

import cn.wt.springbootdemo2.mapper.BaseMapper;;
import org.apache.ibatis.annotations.Mapper;;
import cn.wt.springbootdemo2.entity.PmsBookInfo;
/**
* ********************************************************
* @ClassName: PmsBookInfoDao
* @Description: id
* @author 数据查询接口
* @date 2019-11-16 下午 03:17:24 
*******************************************************
*/
@Mapper
public interface PmsBookInfoDao extends BaseMapper<PmsBookInfo>{

}

