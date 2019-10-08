
package cn.wt.springbootdemo2.dao;

import cn.wt.springbootdemo2.mapper.BaseMapper;;
import org.apache.ibatis.annotations.Mapper;;
import cn.wt.springbootdemo2.entity.TSysRole;
/**
* ********************************************************
* @ClassName: TSysRoleDao
* @Description: id
* @author 数据查询接口
* @date 2019-10-09 上午 06:20:17 
*******************************************************
*/
@Mapper
public interface TSysRoleDao extends BaseMapper<TSysRole>{

}

