package cn.wt.springbootdemo2;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import sun.java2d.pipe.SpanShapeRenderer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CustomRealm extends AuthorizingRealm {


    private final Map<String,String> userInfoMap = new HashMap<>();
    {
        userInfoMap.put("jack","123456");
        userInfoMap.put("xdclass","456");
    }

    //role -> permission
    private final Map<String,Set<String>> permissionMap = new HashMap<>();
    {

        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();

        set1.add("video:find");
        set1.add("video:buy");

        set2.add("video:add");
        set2.add("video:delete");

        permissionMap.put("jack",set1);
        permissionMap.put("xdclass",set2);

    }

    //user -> role
    private final Map<String,Set<String>> roleMap = new HashMap<>();
    {

        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();

        set1.add("role1");
        set1.add("role2");

        set2.add("root");

        roleMap.put("jack",set1);
        roleMap.put("xdclass",set2);

    }



    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        System.out.println("Authorization");

        String name  = (String)principalCollection.getPrimaryPrincipal();

        Set<String> permissions = getPermissionsByNameFromDB(name);
        Set<String> roles = getRolesByNameFromDB(name);

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.setStringPermissions(permissions);
        simpleAuthorizationInfo.setRoles(roles);

        return simpleAuthorizationInfo;
    }


    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("Authentication");


        String name = (String)authenticationToken.getPrincipal();
        //模拟从数据库中取密码
        String pwd = getPwdByUserNameFromDB(name);

        if( pwd == null || "".equals(pwd)){
            return null;
        }


        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(name, pwd, this.getName());




        return simpleAuthenticationInfo;
    }



    /**
     * 模拟从数据库获取用户角色集合
     * @param name
     * @return
     */
    private Set<String> getRolesByNameFromDB(String name) {
        return roleMap.get(name);

    }

    /**
     *  模拟从数据库获取权限集合
     * @param name
     * @return
     */
    private Set<String> getPermissionsByNameFromDB(String name) {
        return permissionMap.get(name);
    }


    private String getPwdByUserNameFromDB(String name) {

        return userInfoMap.get(name);
    }



}
