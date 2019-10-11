
package cn.wt.springbootdemo2.dao;

import cn.wt.springbootdemo2.mapper.BaseMapper;;
import org.apache.ibatis.annotations.Mapper;;
import cn.wt.springbootdemo2.entity.TSysRole;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

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
    public List<TSysRole> findRoleListByUserId(@Param("userId") Integer userId);

}

