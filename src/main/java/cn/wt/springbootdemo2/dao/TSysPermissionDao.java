
package cn.wt.springbootdemo2.dao;

import cn.wt.springbootdemo2.mapper.BaseMapper;;
import org.apache.ibatis.annotations.Mapper;;
import cn.wt.springbootdemo2.entity.TSysPermission;
/**
* ********************************************************
* @ClassName: TSysPermissionDao
* @Description: id
* @author 数据查询接口
* @date 2019-10-09 上午 06:21:34 
*******************************************************
*/
@Mapper
public interface TSysPermissionDao extends BaseMapper<TSysPermission>{

}

