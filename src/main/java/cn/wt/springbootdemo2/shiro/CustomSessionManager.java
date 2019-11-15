package cn.wt.springbootdemo2.shiro;

import jdk.nashorn.internal.parser.Token;
import org.apache.shiro.session.mgt.SessionKey;
import org.apache.shiro.web.servlet.ShiroHttpServletRequest;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.apache.shiro.web.util.WebUtils;
import org.apache.tomcat.util.http.parser.Authorization;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.Serializable;

public class CustomSessionManager extends DefaultWebSessionManager {

    private static final String AUTHORICATION = "token";

    @Override
    public Serializable getSessionId(ServletRequest request, ServletResponse response) {
        String sessionId = WebUtils.toHttp(request).getHeader(AUTHORICATION);
        if(sessionId != null){
            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_SOURCE,
                    ShiroHttpServletRequest.COOKIE_SESSION_ID_SOURCE);
            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID, sessionId);

            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_IS_VALID, Boolean.TRUE);
            return sessionId;

        }

        return super.getSessionId(request,response);
    }
}
