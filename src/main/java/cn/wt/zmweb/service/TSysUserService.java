
package cn.wt.zmweb.service;

import cn.wt.zmweb.dao.TSysRoleDao;
import cn.wt.zmweb.dao.TSysUserDao;
import cn.wt.zmweb.entity.TSysRole;
import cn.wt.zmweb.entity.TSysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public TSysRoleDao tSysRoleDao;

    @Transactional
    public TSysUser findAllUserInfoByUserName(String userName){
        TSysUser user = dao.findByUserName(userName);
        if(user == null){
            return null;
        }

        List<TSysRole> roleList = tSysRoleDao.findRoleListByUserId(user.getId());
        user.setRoleList(roleList);
        return user;
    }

    @Transactional
    public TSysUser findById(Integer userId){
        return dao.findById(userId);
    }
    @Transactional
    public TSysUser findByUserName(String userName){
        return dao.findByUserName(userName);
    }
    @Transactional
    public TSysUser findByUserNameAndPWD(String userName,String password){
        return dao.findByUserNameAndPWD(userName,password);
    }




}

