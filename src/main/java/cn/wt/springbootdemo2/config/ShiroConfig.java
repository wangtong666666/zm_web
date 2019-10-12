package cn.wt.springbootdemo2.config;


import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.LinkedHashMap;
import java.util.Map;


@Configuration
public class ShiroConfig {


    @Bean
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager){

        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        shiroFilterFactoryBean.setSecurityManager(securityManager);

        //调用需要登录的接口 确没登录时调
        shiroFilterFactoryBean.setLoginUrl("");

        //登录成功时调
        shiroFilterFactoryBean.setSuccessUrl("");

        //没有权限时调用
        shiroFilterFactoryBean.setUnauthorizedUrl("");

        //拦截器拦截的路径
        Map<String,String> filterChainDefinitionMap = new LinkedHashMap<>();

        //退出过滤器
        filterChainDefinitionMap.put("/logout","logout");

        //未登录也可以访问
        filterChainDefinitionMap.put("/pub/**","anon");

        //登录才能访问
        filterChainDefinitionMap.put("/authc/**","authc");

        //某角色才能访问 例：admin角色
        filterChainDefinitionMap.put("/admin/**","roles[admin]");

        //有某权限才能访问 例：video_update 权限
        filterChainDefinitionMap.put("/video/update","perms[video_udpate]");


        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);

        return shiroFilterFactoryBean;


    }


    /**
     * 自定义
     * @return
     */
    @Bean
    public SecurityManager securityManager(){

        DefaultSecurityManager securityManager = new DefaultSecurityManager();

        //设置session管理器 前后端不分离无需设置
        securityManager.setSessionManager(sessionManager());

        //设置realm
        securityManager.setRealm(customRealm());

        return securityManager;

    }


    /**
     * 自定义realm
     * @return
     */
    @Bean
    public CustomRealm customRealm(){
        CustomRealm customRealm = new CustomRealm();

        customRealm.setCredentialsMatcher(credentialsMatcher());

        return customRealm;
    }

    /**
     * 密码加解密规则
     * @return
     */
    @Bean
    public HashedCredentialsMatcher credentialsMatcher(){

        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        //设置加密方式
        hashedCredentialsMatcher.setHashAlgorithmName("md5");
        //次数
        hashedCredentialsMatcher.setHashIterations(1);

        return hashedCredentialsMatcher;
    }


    @Bean
    public SessionManager sessionManager(){
        CustomSessionManager customSessionManager = new CustomSessionManager();

        //超时时间，默认 30分钟，会话超时；方法里面的单位是毫秒
        //customSessionManager.setGlobalSessionTimeout(20000);

        return customSessionManager;
    }




}
