
package cn.wt.springbootdemo2.service;

import cn.wt.springbootdemo2.dao.TSysRoleDao;
import cn.wt.springbootdemo2.entity.TSysRole;
import cn.wt.springbootdemo2.entity.TSysUser;
import cn.wt.springbootdemo2.dao.TSysUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* ********************************************************
* @ClassName: TSysUserService
* @Description: id
* @author 生成service类
* @date 2019-10-09 上午 06:17:54 
*******************************************************
*/
@Service
public class TSysUserService extends BaseService<TSysUser,TSysUserDao>{

    @Autowired
    private TSysRoleDao tSysRoleDao;

    public TSysUser findAllUserInfoByUserName(String userName){
        TSysUser user = dao.findByUserName(userName);
        List<TSysRole> roleList = tSysRoleDao.findRoleListByUserId(user.getId());
        user.setRoleList(roleList);
        return user;
    }


    public TSysUser findById(Integer userId){
        return dao.findById(userId);
    }

    public TSysUser findByUserName(String userName){
        return dao.findByUserName(userName);
    }

    public TSysUser findByUserNameAndPWD(String userName,String password){
        return dao.findByUserNameAndPWD(userName,password);
    }




}

