package cn.wt.springbootdemo2.redis;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class RedisFactoryString {

    @Autowired
    private StringRedisTemplate redisTemplate;

    public long ttl(String key){
        return redisTemplate.getExpire(key);
    }

    public void expire(String key,long timeout){
        redisTemplate.expire(key,timeout, TimeUnit.MINUTES);
    }

    public long incr(String key,long delta){
        return redisTemplate.opsForValue().increment(key,delta);
    }

    public Long getIncr(String key,int timeout,int maxnil){
        Long id = null;
        id = redisTemplate.opsForValue().increment(key,1);

        if(timeout>0){
            redisTemplate.expire(key,timeout,TimeUnit.SECONDS);
        }

        if(id > maxnil){
            redisTemplate.delete(key);
        }

        return id;
    }

    public void del(String key){
        redisTemplate.delete(key);
    }


    public void set(String key,String value){
        redisTemplate.opsForValue().set(key,value);
    }

    public void set(String key,String value,long timeout){
        redisTemplate.opsForValue().set(key,value,timeout);
    }


    public String get(String key){
        return redisTemplate.opsForValue().get(key);
    }

}
