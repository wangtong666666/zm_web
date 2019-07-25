package cn.wt.springbootdemo2.redis;

import cn.wt.springbootdemo2.config.RedisConfig;
import cn.wt.springbootdemo2.util.SpringContextUtil;
import org.apache.ibatis.cache.Cache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.cache.RedisCache;
import org.springframework.data.redis.connection.ConnectionUtils;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.jedis.JedisConnection;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.util.CollectionUtils;

import java.sql.Connection;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;


public class MybatisRedisCache implements Cache //实现类
{
    private static final Logger logger = LoggerFactory.getLogger(RedisCache.class);

    private RedisTemplate<String,Object> redisTemplate = null;

    private String id;

    public void getSpringContextRedisTemplate(){
        if(redisTemplate == null){
            redisTemplate = SpringContextUtil.getBean("redisTemplateJson");
        }

    }



    /**
     * The {@code ReadWriteLock}.
     */
    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock(true);

    public MybatisRedisCache(final String id) {
        if (id == null) {
            throw new IllegalArgumentException("Cache instances require an ID");
        }
        logger.debug("MybatisRedisCache:id=" + id);
        this.id = id;
    }

    @Override
    public String getId(){
        return this.id;
    }

    @Override
    public void putObject(Object key, Object value){
        if(value != null){
            this.getSpringContextRedisTemplate();
        }
        redisTemplate.opsForValue().set(key.toString(),value,1, TimeUnit.DAYS);
    }


    @Override
    public Object getObject(Object key){
        try {
            if(key!=null){
                this.getSpringContextRedisTemplate();
                Object o = redisTemplate.opsForValue().get(key.toString());
                return o;
            }

        }catch (Exception e){
            logger.error("redis getObject of MyBatis");
        }
        return null;
    }



    @Override
    public Object removeObject(Object key){
        try {
            if(key !=null){
                this.getSpringContextRedisTemplate();
                redisTemplate.delete(key.toString());
            }
        }catch(Exception e){
            logger.error("redis getObject of MyBatis");
        }


        return null;
    }


    @Override
    public void clear() {

        if(logger.isDebugEnabled()){
            logger.debug("清除缓存");
        }

        try {
            this.getSpringContextRedisTemplate();
            Set<String> keys = redisTemplate.keys("*:" + this.id + "*");
            if(!CollectionUtils.isEmpty(keys)){
                redisTemplate.delete(keys);
            }
        }catch(Exception e){

        }
    }

    @Override
    public ReadWriteLock getReadWriteLock()
    {
        return this.readWriteLock;
    }

    @Override
    public int getSize() {
        this.getSpringContextRedisTemplate();
        Long size = redisTemplate.execute(new RedisCallback<Long>(){
            @Override
            public Long doInRedis(RedisConnection redisConnection) throws DataAccessException {
                return redisConnection.dbSize();
            }
        });

        return size.intValue();
    }



}
