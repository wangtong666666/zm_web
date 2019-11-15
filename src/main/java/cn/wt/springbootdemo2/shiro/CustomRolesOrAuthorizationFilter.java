package cn.wt.springbootdemo2.shiro;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.CollectionUtils;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.util.Set;

public class CustomRolesOrAuthorizationFilter extends AuthorizationFilter {

    public CustomRolesOrAuthorizationFilter() {

    }

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {

        Subject subject = this.getSubject(request, response);
        String[] rolesArray = (String[])((String[])mappedValue);
        if (rolesArray != null && rolesArray.length != 0) {
            Set<String> roles = CollectionUtils.asSet(rolesArray);
            for(String s:roles){
                if(subject.hasRole(s)){
                    return true;
                }
            }
        } else {
            return true;
        }

        return false;
    }
}
