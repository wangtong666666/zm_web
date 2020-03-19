package cn.wt.zmweb.redis;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class RedisFactoryJson {

    @Autowired
    private RedisTemplate<Object,Object> redisTemplateJson;

    //返回剩余生存时间
    public long ttl(String key){
        return redisTemplateJson.getExpire(key);
    }

    //设置过期时间 单位秒
    public void expire(String key,long timeout){
        redisTemplateJson.expire(key,timeout, TimeUnit.MINUTES);
    }

    public void del(String key){
        redisTemplateJson.delete(key);
    }

    public Object get(String key){
        return redisTemplateJson.opsForValue().get(key);
    }

    public void set(String key,Object value){
        redisTemplateJson.opsForValue().set(key,value);
    }

    public void set(String key,Object value,long timeout){
        redisTemplateJson.opsForValue().set(key,value,timeout);
    }





}
