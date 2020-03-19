
package cn.wt.zmweb.dao;

import cn.wt.zmweb.mapper.BaseMapper;;
import org.apache.ibatis.annotations.Mapper;;
import cn.wt.zmweb.entity.TSysPermission;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

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

    @Select("select p.*,rp.role_id from t_sys_role_permission rp left join t_sys_permission p on p.id = rp.permission_id where role_id = #{roleId}")
    public List<TSysPermission> findPermissionByRoleId(@Param("roleId") Integer roleId);

}

