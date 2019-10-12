
package cn.wt.springbootdemo2.dao;

import cn.wt.springbootdemo2.mapper.BaseMapper;;
import org.apache.ibatis.annotations.*;;
import cn.wt.springbootdemo2.entity.TSysUser;
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
    @Results(value = {
            @Result(property = "trueName",column = "true_name"),
            @Result(property = "userName",column = "user_name")
    })
    public TSysUser findById(@Param("id") Integer id);

    @Select("select * from t_sys_user where user_name = #{userName}")
     @Results(value = {
             @Result(property = "trueName",column = "true_name"),
             @Result(property = "userName",column = "user_name")
     })
    public TSysUser findByUserName(@Param("userName") String userName);

    @Select("select * from t_sys_user where user_name = #{userName} and passwork = #{password}")
    @Results(value = {
            @Result(property = "trueName",column = "true_name"),
            @Result(property = "userName",column = "user_name")
    })
    public TSysUser findByUserNameAndPWD(@Param("userName") String userName,@Param("password") String password);


}

