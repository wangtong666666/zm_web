package cn.wt.springbootdemo2.config;


import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionIdGenerator;

import java.io.Serializable;
import java.util.UUID;

public class CustomSessionIdGenerator implements SessionIdGenerator {

    @Override
    public Serializable generateId(Session session) {
        return  "xdclass"+ UUID.randomUUID().toString().replace("-","");
    }
}
