
package cn.wt.springbootdemo2.dao;

import cn.wt.springbootdemo2.mapper.BaseMapper;;
import org.apache.ibatis.annotations.Mapper;;
import cn.wt.springbootdemo2.entity.TSysUser;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.shiro.authc.UsernamePasswordToken;

import java.util.List;

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

    @Select("select * from t_sys_user where id = #{id}")
    public TSysUser findById(@Param("id") Integer id);

    @Select("selecct * from t_sys_user where user_name = #{userName}")
    public TSysUser findByUserName(@Param("userName") String userName);

    @Select("select * from t_sys_user where user_name = #{userName} and passwork = #{password}")
    public TSysUser findByUserNameAndPWD(@Param("userName") String userName,@Param("password") String password);


}

