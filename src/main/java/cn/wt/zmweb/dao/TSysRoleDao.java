
package cn.wt.zmweb.dao;

import cn.wt.zmweb.mapper.BaseMapper;;
import org.apache.ibatis.annotations.*;;
import cn.wt.zmweb.entity.TSysRole;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

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
    @Select("select r.* from t_sys_role_user ru left join t_sys_role r on r.id = ru.role_id where ru.user_id = #{userId}")
    @Results(value={
            @Result(id=true,property="id",column="id"),
            @Result(property="name",column="name"),
            @Result(property="description",column="description"),
            @Result(property="permissionList",column="id",many=@Many(select="cn.wt.springbootdemo2.dao.TSysPermissionDao.findPermissionByRoleId",fetchType = FetchType.DEFAULT))
    })

    public List<TSysRole> findRoleListByUserId(@Param("userId") Integer userId);

}

