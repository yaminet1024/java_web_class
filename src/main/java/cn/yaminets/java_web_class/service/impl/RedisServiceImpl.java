package cn.yaminets.java_web_class.service.impl;

import cn.yaminets.java_web_class.service.RedisService;
import cn.yaminets.java_web_class.utils.RedisConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;


@Service
public class RedisServiceImpl implements RedisService {

    //默认过期时间为2天
    private static final int TOKEN_EXPIRE = 3600*24*2;

    @Autowired
    RedisConfig redisConfig;

    @Override
    public <T> T getValue(String key, Class<T> value) {
        Jedis jedis = null;
        try {
            jedis = redisConfig.redisPoolFactory().getResource();
            T t = (T) jedis.get(key);
            return t;
        }finally {
            returnToPool(jedis);
        }
    }

    private void returnToPool(Jedis jedis) {
        if (jedis!=null){
            jedis.close();
        }
    }

    @Override
    public <T> void setValue(String key, T value) {
        Jedis jedis = null;
        try {
            jedis = redisConfig.redisPoolFactory().getResource();
            jedis.setex(key,TOKEN_EXPIRE,value.toString());
        }finally {
            returnToPool(jedis);
        }
    }

    @Override
    public void removeKey(String key) {
        Jedis jedis = null;
        try {
            jedis = redisConfig.redisPoolFactory().getResource();
            jedis.del(key);
        }finally {
            returnToPool(jedis);
        }
    }


}
