package cn.wt.zmweb;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Before;
import org.junit.Test;

public class QuickStartTest {

    private DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
    private SimpleAccountRealm simpleAccountRealm = new SimpleAccountRealm();
    private CustomRealm customRealm = new CustomRealm();

    @Before
    public void init(){
     /*   simpleAccountRealm.addAccount("13687629088","123456","admin");
        simpleAccountRealm.addAccount("13600000000","123456","student");
*/
       // defaultSecurityManager.setRealm(simpleAccountRealm);
        defaultSecurityManager.setRealm(customRealm);
        SecurityUtils.setSecurityManager(defaultSecurityManager);

    }


    @Test
    public void testAuthentication(){

        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken("jack","123456");

        Subject subject = SecurityUtils.getSubject();

        try {
            subject.login(usernamePasswordToken);
            if(subject.isAuthenticated()){
                System.out.println("登录成功！");
                System.out.println("当前登录用户："+subject.getPrincipal());
            }
        } catch ( UnknownAccountException uae ) {
            System.out.println("用户名不存在");
        } catch ( IncorrectCredentialsException ice ) {
            System.out.println("密码错误");
        } catch ( LockedAccountException lae ) {
            System.out.println("用户被锁定，不能登录");
        } catch (AuthenticationException ae ) {
            System.out.println("严重的错误");
        }

        System.out.println("是否有对应的角色:"+subject.hasRole("role1"));

        System.out.println("是否有对应的权限:"+subject.isPermitted("video:add"));



    }


}
