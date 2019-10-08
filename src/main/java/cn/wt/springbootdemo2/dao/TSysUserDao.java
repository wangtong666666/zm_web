
package cn.wt.springbootdemo2.dao;

import cn.wt.springbootdemo2.mapper.BaseMapper;;
import org.apache.ibatis.annotations.Mapper;;
import cn.wt.springbootdemo2.entity.TSysUser;
/**
* ********************************************************
* @ClassName: TSysUserDao
* @Description: id
* @author 数据查询接口
* @date 2019-10-09 上午 06:17:54 
*******************************************************
*/
@Mapper
public interface TSysUserDao extends BaseMapper<TSysUser>{

}

