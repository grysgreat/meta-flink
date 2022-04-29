/**
 * Copyright 2020-9999 the original author or authors.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.metaflink.database.utils;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.*;

import java.io.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author binghe
 * @version 1.0.0
 * @description Redis工具类，支持单机集群连接
 */
public class RedisUtils {

    private static final Logger logger = LoggerFactory.getLogger(RedisUtils.class);

    private static JedisPoolConfig getJedisPoolConfig(Integer maxTotal, Integer maxIdle, Integer minIdle) {
        JedisPoolConfig c = new JedisPoolConfig();
        //最大连接数
        c.setMaxTotal(null == maxTotal ? 100 : maxTotal);
        //在jedispool中最大的idle状态(空闲的)的jedis实例的个数
        c.setMaxIdle(null == maxIdle ? 50 : maxIdle);
        //在jedispool中最小的idle状态(空闲的)的jedis实例的个数
        c.setMinIdle(null == minIdle ? 20 : minIdle);
        // 等待时间
        c.setMaxWaitMillis(3000);
        //在borrow一个jedis实例的时候，是否要进行验证操作，如果赋值true。则得到的jedis实例肯定是可以用的。
        c.setTestOnBorrow(false);
        //在return一个jedis实例的时候，是否要进行验证操作，如果赋值true。则放回jedispool的jedis实例肯定是可以用的。
        c.setTestOnReturn(false);
        //连接耗尽的时候，是否阻塞，false会抛出异常，true阻塞直到超时。默认为true。
        c.setBlockWhenExhausted(false);
        return c;
    }

    public static JedisPool getJedisPool(String ip, Integer port) {
        return getJedisPool(ip, port, null);
    }

    public static JedisPool getJedisPool(String ip, Integer port, String password) {
        return getJedisPool(ip, port, password, null, null, null);
    }

    public static JedisPool getJedisPool(String ip, Integer port, String password, Integer maxTotal, Integer maxIdle, Integer minIdle) {
        if (StringUtils.isBlank(ip) || null == port) {
            return null;
        }
        // 设置连接池配置
        JedisPoolConfig c = getJedisPoolConfig(maxTotal, maxIdle, minIdle);

        //jedis连接池
        JedisPool jedisPool = new JedisPool(c, ip, port);

        // 验证密码有效性
        if (StringUtils.isNotBlank(password)) {
            /**
             * If the password is invalid, it will throw an JedisDataException as follows, otherwise return OK.
             * redis.clients.jedis.exceptions.JedisDataException: ERR invalid password
             */
            Jedis jedis = jedisPool.getResource();
            jedis.auth(password);
            // 关闭管道
            close(jedis);
        }
        return jedisPool;
    }

    public static JedisCluster getJedisCluster(List<String[]> servers, String password) {
        return getJedisCluster(servers, null, null, null, password);
    }

    /**
     * TODO:此处有BUG 不知道怎么配置连接池 好在这个模块暂时用不到
     * @param servers
     * @param maxTotal
     * @param maxIdle
     * @param minIdle
     * @param password
     * @return
     */
    public static JedisCluster getJedisCluster(List<String[]> servers, Integer maxTotal, Integer maxIdle, Integer minIdle, String password) {
        if (null == servers || servers.isEmpty()) {
            return null;
        }
        // 设置连接池配置
        JedisPoolConfig c = getJedisPoolConfig(maxTotal, maxIdle, minIdle);

        // 根据服务列表明设置连接node
        Set<HostAndPort> jedisClusterNodes = new HashSet<HostAndPort>();
        String ip;
        Integer port;
        for (String[] server : servers) {
            ip = server[0];
            port = Integer.parseInt(server[1]);
            // 如果不能ping
            if (!PingUtils.ping(ip, port)) {
                String err = "Can't connect " + ip + ":" + port;
                throw new IllegalArgumentException(err);
            }
            jedisClusterNodes.add(new HostAndPort(ip, port));
        }
        return new JedisCluster(jedisClusterNodes);
    }

    public static void close(JedisPool pool) {
        if (null != pool) {
            pool.destroy();
        }
    }

    public static void close(Jedis jedis) {
        if (jedis != null) {
            jedis.close();
        }
    }

    public static void close(JedisCluster cluster) {
        if (null != cluster) {
            try {
                cluster.close();
            } catch (Exception e) {
                logger.error(e.getLocalizedMessage());
            }
        }
    }

    public static byte[] serializeObj(Object value) {
        byte[] result = null;
        if (value == null) {
            logger.error("Can't serialize null");
            return result;
        }
        ByteArrayOutputStream bos = null;
        ObjectOutputStream os = null;
        try {
            bos = new ByteArrayOutputStream();
            os = new ObjectOutputStream(bos);
            os.writeObject(value);
            result = bos.toByteArray();
        } catch (IOException e) {
            logger.error("Non-serializable object", e);
        } finally {
            close(os);
            close(bos);
        }
        return result;
    }

    public static Object deserializeObj(byte[] in) {
        Object result = null;
        ByteArrayInputStream bis = null;
        ObjectInputStream is = null;
        try {
            if (in != null) {
                bis = new ByteArrayInputStream(in);
                is = new ObjectInputStream(bis);
                result = is.readObject();
            }
        } catch (IOException e) {
            logger.error("Non-serializable object", e);

        } catch (ClassNotFoundException e) {
            logger.error("Non-serializable object", e);
        } finally {
            close(is);
            close(bis);
        }
        return result;
    }

    private static void close(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e) {
                throw new IllegalArgumentException("Non-serializable object", e);
            }
        }
    }
}
