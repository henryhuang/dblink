package org.dblink.utils;

import java.util.List;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisUtil {

    JedisPool pool;
    Jedis jedis;
    
    public JedisUtil() {
    	setUp();
	}
    
    private static JedisUtil instance = null;
    
    public static JedisUtil getInstance() {
    	if(instance == null) {
    		instance = new JedisUtil();
    	}
    	
    	return instance;
    }
    
    public void setUp() {
        pool = new JedisPool(new JedisPoolConfig(), "127.0.0.1", 6379);
        jedis = pool.getResource();
    }
    
    public void markDisShowStatus(String relPath) {
    	jedis.lpush("dblinkdisshow", relPath);    	
    	jedis.save();
    }
    
    public List<String> getMarkDisShowList() {
    	return jedis.lrange("dblinkdisshow", 0, -1);
    }
}
