package cn.wt.springbootdemo2.shiro;

import cn.wt.springbootdemo2.entity.TSysPermission;
import cn.wt.springbootdemo2.entity.TSysRole;
import cn.wt.springbootdemo2.entity.TSysUser;
import cn.wt.springbootdemo2.service.TSysUserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class CustomRealm extends AuthorizingRealm {
    @Autowired
    private TSysUserService tSysUserService;


    /**
     *权限校验时调用
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        String userName = (String) principalCollection.getPrimaryPrincipal();
        TSysUser user = tSysUserService.findAllUserInfoByUserName(userName);
        List<String> stringRoleList = new ArrayList<String>();
        List<String> stringPermissionList = new ArrayList<String>();

        List<TSysRole> roleList = user.getRoleList();
        for(TSysRole role:roleList){
            stringRoleList.add(role.getName());
            for(TSysPermission permission:role.getPermissionList()){
                if(permission!=null){
                    stringPermissionList.add(permission.getName());
                }
            }
        }

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.addRoles(stringRoleList);
        simpleAuthorizationInfo.addStringPermissions(stringPermissionList);

        return simpleAuthorizationInfo;
    }


    /**
     * 用户登录时调用
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        String userName = (String) authenticationToken.getPrincipal();
        TSysUser user =tSysUserService.findAllUserInfoByUserName(userName);
        if(user == null){
            return null;
        }
        if(user.getPassword() == null || "".equals(user.getPassword())){
            return null;
        }
        return new SimpleAuthenticationInfo(userName,user.getPassword(),this.getClass().getName());
    }
}
