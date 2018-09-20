package com.dzjk.ams.core.common.util;

import org.apache.commons.lang.StringUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.exceptions.JedisException;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

public class RedisUtil {  
    /** 
     * 默认日志打印logger
     */  
	public static Logger logger = Logger.getLogger("logger_jedis_default");  

	//redis 配置信息
	//Redis服务器IP  
	private static String redisHost = "r-zm0cb150cb4e4314.redis.rds.aliyuncs.com";  
	//Redis的端口号  
	private static int redisPort = 6379;  
	//Redis的端口号  
	private static String redisPassword = "maiziJF2017";  
	//超时时间
	private static int redisTimeOut = 3000; 
	//可用连接实例的最大数目，默认值为8；  
	//如果赋值为-1，则表示不限制；如果pool已经分配了maxActive个jedis实例，则此时pool的状态为exhausted(耗尽)。  
	private static int redisMaxActive = 2000;  
	//控制一个pool最多有多少个状态为idle(空闲的)的jedis实例，默认值也是8。  
	private static int redisMaxIdle = 200;  
	//等待可用连接的最大时间，单位毫秒，默认值为-1，表示永不超时。如果超过等待时间，则直接抛出JedisConnectionException；  
	private static int redisMaxWait = 10000;  
	//在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的；  
	private static boolean testOnBorrow = true;  
	private static boolean testOnReturn= false;
    
    /** 
     * 初始化Redis连接池 
     */    
    private static JedisPool jedisPool = null;  
    
    
     static {  
         try {  
              JedisPoolConfig config = new JedisPoolConfig();  
              config.setMaxTotal(redisMaxActive);  
              config.setMaxIdle(redisMaxIdle);  
              config.setMaxWaitMillis(redisMaxWait);  
              config.setTestOnBorrow(testOnBorrow);  
              config.setTestOnReturn(testOnReturn);
              System.out.println("redisHost:  ----"+redisHost);
              jedisPool = new JedisPool(config, redisHost, redisPort,redisTimeOut, redisPassword);  
         } catch (Exception e) {  
              e.printStackTrace();  
         }  
     }  
       
     /** 
      * 获取Jedis实例 
      * @return 
      */  
     public synchronized static Jedis getJedis() throws JedisException{  
         try {  
             if (jedisPool != null) {  
            	 System.out.println("redisHost:  ----"+redisHost);
                 Jedis resource = jedisPool.getResource();  
                 return resource;  
             } else {  
                 return null;  
             }  
         } catch (Exception e) {  
             e.printStackTrace(); 
             logger.info(e.getMessage());  
             return null;  
         }  
     }  
            
     /** 
      * 释放jedis资源 
      * @param jedis 
      */  
      public static void returnResource(final Jedis jedis) {  
          if (jedis != null) {  
               jedisPool.returnResourceObject(jedis);  
          }  
      }  
      
      /** 
       * 获取缓存 
       * @param key 键 
       * @return 值 
       */  
      public static String get(String key) {  
          String value = null;  
          Jedis jedis = null;  
          try {  
              jedis = getJedis();  
              if (jedis.exists(key)) {  
                  value = jedis.get(key);  
                  value = StringUtils.isNotBlank(value) && !"nil".equalsIgnoreCase(value) ? value : null;
                  logger.info("get" +" "+ key+":"+value);  
              }  
          } catch (Exception e) {  
              logger.info("get" +" "+ key+":"+value +"failed as "+ e.getMessage());   
          } finally {  
              returnResource(jedis);  
          }  
          return value;  
      }  
        
      /** 
       * 获取缓存 
       * @param key 键 
       * @return 值 
       */  
//      public static Object getObject(String key) {  
//          Object value = null;  
//          Jedis jedis = null;  
//          try {  
//              jedis = getJedis();  
//              if (jedis.exists(getBytesKey(key))) {  
//                  value = toObject(jedis.get(getBytesKey(key)));  
//                  logger.info("get" +" "+ key+":"+value);  
//              }  
//          } catch (Exception e) {  
//        	  logger.info("get" +" "+ key+":"+value +"failed as "+ e.getMessage());   
//          } finally {  
//              returnResource(jedis);  
//          }  
//          return value;  
//      }  
        
      /** 
       * 设置缓存 
       * @param key 键 
       * @param value 值 
       * @param cacheSeconds 超时时间，0为不超时 
       * @return 
       */  
      public static String set(String key, String value, int cacheSeconds) {  
          String result = null;  
          Jedis jedis = null;  
          try {  
              jedis = getJedis();  
              result = jedis.set(key, value);  
              if (cacheSeconds != 0) {  
                  jedis.expire(key, cacheSeconds);  
              }  
              logger.info("get" +" "+ key+":"+value);  
          } catch (Exception e) {  
        	  logger.info("get" +" "+ key+":"+value +"failed as "+ e.getMessage());   
          } finally {  
              returnResource(jedis);  
          }  
          return result;  
      }  
        
      /** 
       * 设置缓存 
       * @param key 键 
       * @param value 值 
       * @param cacheSeconds 超时时间，0为不超时 
       * @return 
       */  
//      public static String setObject(String key, Object value, int cacheSeconds) {  
//          String result = null;  
//          Jedis jedis = null;  
//          try {  
//              jedis = getJedis();  
//              result = jedis.set(getBytesKey(key), toBytes(value));  
//              if (cacheSeconds != 0) {  
//                  jedis.expire(key, cacheSeconds);  
//              }  
//              logger.info("get" +" "+ key+":"+value);  
//          } catch (Exception e) {  
//        	  logger.info("get" +" "+ key+":"+value +"failed as "+ e.getMessage());   
//          } finally {  
//              returnResource(jedis);  
//          }  
//          return result;  
//      }  
//        
      /** 
       * 获取List缓存 
       * @param key 键 
       * @return 值 
       */  
      public static List<String> getList(String key) {  
          List<String> value = null;  
          Jedis jedis = null;  
          try {  
              jedis = getJedis();  
              if (jedis.exists(key)) {  
                  value = jedis.lrange(key, 0, -1);  
                  logger.info("get" +" "+ key+":"+value);   
              }  
          } catch (Exception e) {  
        	  logger.info("get" +" "+ key+":"+value +"failed as "+ e.getMessage());   
          } finally {  
              returnResource(jedis);  
          }  
          return value;  
      }  
        
      /** 
       * 获取List缓存 
       * @param key 键 
       * @return 值 
       */  
//      public static List<Object> getObjectList(String key) {  
//          List<Object> value = null;  
//          Jedis jedis = null;  
//          try {  
//              jedis = getJedis();  
//              if (jedis.exists(getBytesKey(key))) {  
//                  List<byte[]> list = jedis.lrange(getBytesKey(key), 0, -1);  
//                  value = Lists.newArrayList();  
//                  for (byte[] bs : list){  
//                      value.add(toObject(bs));  
//                  }  
//                  logger.debug("getObjectList {} = {}", key, value);  
//              }  
//          } catch (Exception e) {  
//        	  logger.info("get" +" "+ key+":"+value +"failed as "+ e.getMessage());   
//          } finally {  
//              returnResource(jedis);  
//          }  
//          return value;  
//      }  
        
      /** 
       * 设置List缓存 
       * @param key 键 
       * @param value 值 
       * @param cacheSeconds 超时时间，0为不超时 
       * @return 
       */  
      public static long setList(String key, List<String> value, int cacheSeconds) {  
          long result = 0;  
          Jedis jedis = null;  
          try {  
              jedis = getJedis();  
              if (jedis.exists(key)) {  
                  jedis.del(key);  
              }  
              result = jedis.rpush(key, (String[])value.toArray());  
              if (cacheSeconds != 0) {  
                  jedis.expire(key, cacheSeconds);  
              }  
              logger.info("set" +" "+ key+":"+value);  
          } catch (Exception e) {  
        	  logger.info("set" +" "+ key+":"+value +"failed as "+ e.getMessage());   
          } finally {  
              returnResource(jedis);  
          }  
          return result;  
      }  
        
      /** 
       * 设置List缓存 
       * @param key 键 
       * @param value 值 
       * @param cacheSeconds 超时时间，0为不超时 
       * @return 
       */  
//      public static long setObjectList(String key, List<Object> value, int cacheSeconds) {  
//          long result = 0;  
//          Jedis jedis = null;  
//          try {  
//              jedis = getJedis();  
//              if (jedis.exists(getBytesKey(key))) {  
//                  jedis.del(key);  
//              }  
//              List<byte[]> list = Lists.newArrayList();  
//              for (Object o : value){  
//                  list.add(toBytes(o));  
//              }  
//              result = jedis.rpush(getBytesKey(key), (byte[][])list.toArray());  
//              if (cacheSeconds != 0) {  
//                  jedis.expire(key, cacheSeconds);  
//              }  
//              logger.debug("setObjectList {} = {}", key, value);  
//          } catch (Exception e) {  
//        	  logger.info("set" +" "+ key+":"+value +"failed as "+ e.getMessage());  
//          } finally {  
//              returnResource(jedis);  
//          }  
//          return result;  
//      }  
        
      /** 
       * 向List缓存中添加值 
       * @param key 键 
       * @param value 值 
       * @return 
       */  
      public static long listAdd(String key, String... value) {  
          long result = 0;  
          Jedis jedis = null;  
          try {  
              jedis = getJedis();  
              result = jedis.rpush(key, value);  
              logger.info("add" +" "+ key+":"+value);   
          } catch (Exception e) {  
        	  logger.info("set" +" "+ key+":"+value +"failed as "+ e.getMessage());  
          } finally {  
              returnResource(jedis);  
          }  
          return result;  
      }  
        
//      /** 
//       * 向List缓存中添加值 
//       * @param key 键 
//       * @param value 值 
//       * @return 
//       */  
//      public static long listObjectAdd(String key, Object... value) {  
//          long result = 0;  
//          Jedis jedis = null;  
//          try {  
//              jedis = getJedis();  
//              List<byte[]> list = Lists.newArrayList();  
//              for (Object o : value){  
//                  list.add(toBytes(o));  
//              }  
//              result = jedis.rpush(getBytesKey(key), (byte[][])list.toArray());  
//              logger.debug("listObjectAdd {} = {}", key, value);  
//          } catch (Exception e) {  
//        	  logger.info("add" +" "+ key+":"+value +"failed as "+ e.getMessage());  
//          } finally {  
//              returnResource(jedis);  
//          }  
//          return result;  
//      }  
    
      /** 
       * 获取缓存 
       * @param key 键 
       * @return 值 
       */  
      public static Set<String> getSet(String key) {  
          Set<String> value = null;  
          Jedis jedis = null;  
          try {  
              jedis = getJedis();  
              if (jedis.exists(key)) {  
                  value = jedis.smembers(key);  
                  logger.info("get" +" "+ key+":"+value);  
              }  
          } catch (Exception e) {  
        	  logger.info("get" +" "+ key+":"+value +"failed as "+ e.getMessage());  
          } finally {  
              returnResource(jedis);  
          }  
          return value;  
      }  
//        
//      /** 
//       * 获取缓存 
//       * @param key 键 
//       * @return 值 
//       */  
//      public static Set<Object> getObjectSet(String key) {  
//          Set<Object> value = null;  
//          Jedis jedis = null;  
//          try {  
//              jedis = getJedis();  
//              if (jedis.exists(getBytesKey(key))) {  
//                  value = Sets.newHashSet();  
//                  Set<byte[]> set = jedis.smembers(getBytesKey(key));  
//                  for (byte[] bs : set){  
//                      value.add(toObject(bs));  
//                  }  
//                  logger.debug("getObjectSet {} = {}", key, value);  
//              }  
//          } catch (Exception e) {  
//        	  logger.info("get" +" "+ key+":"+value +"failed as "+ e.getMessage()); 
//          } finally {  
//              returnResource(jedis);  
//          }  
//          return value;  
//      }  
        
      /** 
       * 设置Set缓存 
       * @param key 键 
       * @param value 值 
       * @param cacheSeconds 超时时间，0为不超时 
       * @return 
       */  
      public static long setSet(String key, Set<String> value, int cacheSeconds) {  
          long result = 0;  
          Jedis jedis = null;  
          try {  
              jedis = getJedis();  
              if (jedis.exists(key)) {  
                  jedis.del(key);  
              }  
              result = jedis.sadd(key, (String[])value.toArray());  
              if (cacheSeconds != 0) {  
                  jedis.expire(key, cacheSeconds);  
              }  
              logger.info("set" +" "+ key+":"+value);   
          } catch (Exception e) {  
        	  logger.info("set" +" "+ key+":"+value +"failed as "+ e.getMessage());  
          } finally {  
              returnResource(jedis);  
          }  
          return result;  
      }  
        
//      /** 
//       * 设置Set缓存 
//       * @param key 键 
//       * @param value 值 
//       * @param cacheSeconds 超时时间，0为不超时 
//       * @return 
//       */  
//      public static long setObjectSet(String key, Set<Object> value, int cacheSeconds) {  
//          long result = 0;  
//          Jedis jedis = null;  
//          try {  
//              jedis = getJedis();  
//              if (jedis.exists(getBytesKey(key))) {  
//                  jedis.del(key);  
//              }  
//              Set<byte[]> set = Sets.newHashSet();  
//              for (Object o : value){  
//                  set.add(toBytes(o));  
//              }  
//              result = jedis.sadd(getBytesKey(key), (byte[][])set.toArray());  
//              if (cacheSeconds != 0) {  
//                  jedis.expire(key, cacheSeconds);  
//              }  
//              logger.debug("setObjectSet {} = {}", key, value);  
//          } catch (Exception e) {  
//        	  logger.info("set" +" "+ key+":"+value +"failed as "+ e.getMessage());   
//          } finally {  
//              returnResource(jedis);  
//          }  
//          return result;  
//      }  
        
      /** 
       * 向Set缓存中添加值 
       * @param key 键 
       * @param value 值 
       * @return 
       */  
      public static long setSetAdd(String key, String... value) {  
          long result = 0;  
          Jedis jedis = null;  
          try {  
              jedis = getJedis();  
              result = jedis.sadd(key, value);  
              logger.info("set" +" "+ key+":"+value);   
          } catch (Exception e) {  
        	  logger.info("set" +" "+ key+":"+value +"failed as "+ e.getMessage()); 
          } finally {  
              returnResource(jedis);  
          }  
          return result;  
      }  
//    
//      /** 
//       * 向Set缓存中添加值 
//       * @param key 键 
//       * @param value 值 
//       * @return 
//       */  
//      public static long setSetObjectAdd(String key, Object... value) {  
//          long result = 0;  
//          Jedis jedis = null;  
//          try {  
//              jedis = getJedis();  
//              Set<byte[]> set = Sets.newHashSet();  
//              for (Object o : value){  
//                  set.add(toBytes(o));  
//              }  
//              result = jedis.rpush(getBytesKey(key), (byte[][])set.toArray());  
//              logger.debug("setSetObjectAdd {} = {}", key, value);  
//          } catch (Exception e) {  
//        	  logger.info("set" +" "+ key+":"+value +"failed as "+ e.getMessage());  
//          } finally {  
//              returnResource(jedis);  
//          }  
//          return result;  
//      }  
        
      /** 
       * 获取Map缓存 
       * @param key 键 
       * @return 值 
       */  
      public static Map<String, String> getMap(String key) {  
          Map<String, String> value = null;  
          Jedis jedis = null;  
          try {  
              jedis = getJedis();  
              if (jedis.exists(key)) {  
                  value = jedis.hgetAll(key);  
                  logger.info("get" +" "+ key+":"+value);   
              }  
          } catch (Exception e) {  
        	  logger.info("get" +" "+ key+":"+value +"failed as "+ e.getMessage()); 
          } finally {  
              returnResource(jedis);  
          }  
          return value;  
      }  
        
      /** 
       * 获取Map缓存 
       * @param key 键 
       * @return 值 
       */  
//      public static Map<String, Object> getObjectMap(String key) {  
//          Map<String, Object> value = null;  
//          Jedis jedis = null;  
//          try {  
//              jedis = getJedis();  
//              if (jedis.exists(getBytesKey(key))) {  
//                  value = Maps.newHashMap();  
//                  Map<byte[], byte[]> map = jedis.hgetAll(getBytesKey(key));  
//                  for (Map.Entry<byte[], byte[]> e : map.entrySet()){  
//                      value.put(StringUtils.toString(e.getKey()), toObject(e.getValue()));  
//                  }  
//                  logger.info("get" +" "+ key+":"+value);   
//              }  
//          } catch (Exception e) {  
//        	  logger.info("get" +" "+ key+":"+value +"failed as "+ e.getMessage());   
//          } finally {  
//              returnResource(jedis);  
//          }  
//          return value;  
//      }  
        
      /** 
       * 设置Map缓存 
       * @param key 键 
       * @param value 值 
       * @param cacheSeconds 超时时间，0为不超时 
       * @return 
       */  
      public static String setMap(String key, Map<String, String> value, int cacheSeconds) {  
          String result = null;  
          Jedis jedis = null;  
          try {  
              jedis = getJedis();  
              if (jedis.exists(key)) {  
                  jedis.del(key);  
              }  
              result = jedis.hmset(key, value);  
              if (cacheSeconds != 0) {  
                  jedis.expire(key, cacheSeconds);  
              }  
              logger.info("set" +" "+ key+":"+value);   
          } catch (Exception e) {  
        	  logger.info("set" +" "+ key+":"+value +"failed as "+ e.getMessage()); 
          } finally {  
              returnResource(jedis);  
          }  
          return result;  
      }  
        
//      /** 
//       * 设置Map缓存 
//       * @param key 键 
//       * @param value 值 
//       * @param cacheSeconds 超时时间，0为不超时 
//       * @return 
//       */  
//      public static String setObjectMap(String key, Map<String, Object> value, int cacheSeconds) {  
//          String result = null;  
//          Jedis jedis = null;  
//          try {  
//              jedis = getJedis();  
//              if (jedis.exists(getBytesKey(key))) {  
//                  jedis.del(key);  
//              }  
//              Map<byte[], byte[]> map = Maps.newHashMap();  
//              for (Map.Entry<String, Object> e : value.entrySet()){  
//                  map.put(getBytesKey(e.getKey()), toBytes(e.getValue()));  
//              }  
//              result = jedis.hmset(getBytesKey(key), (Map<byte[], byte[]>)map);  
//              if (cacheSeconds != 0) {  
//                  jedis.expire(key, cacheSeconds);  
//              }  
//              logger.debug("setObjectMap {} = {}", key, value);  
//          } catch (Exception e) {  
//        	  logger.info("set" +" "+ key+":"+value +"failed as "+ e.getMessage());  
//          } finally {  
//              returnResource(jedis);  
//          }  
//          return result;  
//      }  
        
      /** 
       * 向Map缓存中添加值 
       * @param key 键 
       * @param value 值 
       * @return 
       */  
      public static String mapPut(String key, Map<String, String> value) {  
          String result = null;  
          Jedis jedis = null;  
          try {  
              jedis = getJedis();  
              result = jedis.hmset(key, value);  
              logger.info("get" +" "+ key+":"+value);   
          } catch (Exception e) {  
        	  logger.info("add" +" "+ key+":"+value +"failed as "+ e.getMessage()); 
          } finally {  
              returnResource(jedis);  
          }  
          return result;  
      }  
        
//      /** 
//       * 向Map缓存中添加值 
//       * @param key 键 
//       * @param value 值 
//       * @return 
//       */  
//      public static String mapObjectPut(String key, Map<String, Object> value) {  
//          String result = null;  
//          Jedis jedis = null;  
//          try {  
//              jedis = getJedis();  
//              Map<byte[], byte[]> map = Maps.newHashMap();  
//              for (Map.Entry<String, Object> e : value.entrySet()){  
//                  map.put(getBytesKey(e.getKey()), toBytes(e.getValue()));  
//              }  
//              result = jedis.hmset(getBytesKey(key), (Map<byte[], byte[]>)map);  
//              logger.debug("mapObjectPut {} = {}", key, value);  
//          } catch (Exception e) {  
//        	  logger.info("add" +" "+ key+":"+value +"failed as "+ e.getMessage()); 
//          } finally {  
//              returnResource(jedis);  
//          }  
//          return result;  
//      }  
        
      /** 
       * 移除Map缓存中的值 
       * @param key 键 
       * @param value 值 
       * @return 
       */  
      public static long mapRemove(String key, String mapKey) {  
          long result = 0;  
          Jedis jedis = null;  
          try {  
              jedis = getJedis();  
              result = jedis.hdel(key, mapKey);  
              logger.info("get" +" "+ key+":"+mapKey);   
          } catch (Exception e) {  
        	  logger.info("remove" +" "+ key+":"+mapKey +"failed as "+ e.getMessage());  
          } finally {  
              returnResource(jedis);  
          }  
          return result;  
      }  
        
//      /** 
//       * 移除Map缓存中的值 
//       * @param key 键 
//       * @param value 值 
//       * @return 
//       */  
//      public static long mapObjectRemove(String key, String mapKey) {  
//          long result = 0;  
//          Jedis jedis = null;  
//          try {  
//              jedis = getJedis();  
//              result = jedis.hdel(getBytesKey(key), getBytesKey(mapKey));  
//              logger.info("remove"+key+":"+mapKey);  
//          } catch (Exception e) {  
//        	  logger.info("remove" +" "+ key+":"+mapKey +"failed as "+ e.getMessage()); 
//          } finally {  
//              returnResource(jedis);  
//          }  
//          return result;  
//      }  
        
      /** 
       * 判断Map缓存中的Key是否存在 
       * @param key 键 
       * @param value 值 
       * @return 
       */  
      public static boolean mapExists(String key, String mapKey) {  
          boolean result = false;  
          Jedis jedis = null;  
          try {  
              jedis = getJedis();  
              result = jedis.hexists(key, mapKey);  
              logger.info("get:"+key+":"+ mapKey);  
          } catch (Exception e) {  
        	  logger.info("cehck" +" "+ key+":"+mapKey +"failed as "+ e.getMessage());   
          } finally {  
              returnResource(jedis);  
          }  
          return result;  
      }  
        
//      /** 
//       * 判断Map缓存中的Key是否存在 
//       * @param key 键 
//       * @param value 值 
//       * @return 
//       */  
//      public static boolean mapObjectExists(String key, String mapKey) {  
//          boolean result = false;  
//          Jedis jedis = null;  
//          try {  
//              jedis = getJedis();  
//              result = jedis.hexists(getBytesKey(key), getBytesKey(mapKey));  
//              logger.info("exsit : "+key+":"+mapKey);  
//          } catch (Exception e) {  
//        	  logger.info("check" +" "+ key+":"+mapKey +"failed as "+ e.getMessage()); 
//          } finally {  
//              returnResource(jedis);  
//          }  
//          return result;  
//      }  
//        
      /** 
       * 删除缓存 
       * @param key 键 
       * @return 
       */  
      public static long del(String key) {  
          long result = 0;  
          Jedis jedis = null;  
          try {  
              jedis = getJedis();  
              if (jedis.exists(key)){  
                  result = jedis.del(key);  
                  logger.info("del" +" "+ key);   
              }else{  
            	  logger.info("not exsit" +" "+ key);   
              }  
          } catch (Exception e) {  
        	  logger.info("delete" +" "+ key+" failed as "+ e.getMessage());  
          } finally {  
              returnResource(jedis);  
          }  
          return result;  
      }  
    
      /** 
       * 删除缓存 
       * @param key 键 
       * @return 
       */  
//      public static long delObject(String key) {  
//          long result = 0;  
//          Jedis jedis = null;  
//          try {  
//              jedis = getJedis();  
//              if (jedis.exists(getBytesKey(key))){  
//                  result = jedis.del(getBytesKey(key));  
//                  logger.debug("delObject {}", key);  
//              }else{  
//                  logger.debug("delObject {} not exists", key);  
//              }  
//          } catch (Exception e) {  
//        	  logger.info("delete" +" "+ key+" failed as "+ e.getMessage()); 
//          } finally {  
//              returnResource(jedis);  
//          }  
//          return result;  
//      }  
//        
//      /** 
//       * 缓存是否存在 
//       * @param key 键 
//       * @return 
//       */  
//      public static boolean exists(String key) {  
//          boolean result = false;  
//          Jedis jedis = null;  
//          try {  
//              jedis = getJedis();  
//              result = jedis.exists(key);  
//              logger.debug("exists {}", key);  
//          } catch (Exception e) {  
//        	  logger.info("check" +" "+ key+" failed as "+ e.getMessage()); 
//          } finally {  
//              returnResource(jedis);  
//          }  
//          return result;  
//      }  
//        
//      /** 
//       * 缓存是否存在 
//       * @param key 键 
//       * @return 
//       */  
//      public static boolean existsObject(String key) {  
//          boolean result = false;  
//          Jedis jedis = null;  
//          try {  
//              jedis = getJedis();  
//              result = jedis.exists(getBytesKey(key));  
//              logger.debug("existsObject {}", key);  
//          } catch (Exception e) {  
//        	  logger.info("check" +" "+ key+" failed as "+ e.getMessage());  
//          } finally {  
//              returnResource(jedis);  
//          }  
//          return result;  
//      }  
      
//      /** 
//       * 获取byte[]类型Key 
//       * @param key 
//       * @return 
//       */  
//      public static byte[] getBytesKey(Object object){  
//          if(object instanceof String){  
//              return StringUtils.getBytes((String)object);  
//          }else{  
//              return ObjectUtils.   .identityToString(obj)serialize(object);  
//          }  
//      }  
//        
//      /** 
//       * Object转换byte[]类型 
//       * @param key 
//       * @return 
//       */  
//      public static byte[] toBytes(Object object){  
//          return ObjectUtils.serialize(object);  
//      }  
//    
//      /** 
//       * byte[]型转换Object 
//       * @param key 
//       * @return 
//       */  
//      public static Object toObject(byte[] bytes){  
//          return ObjectUtils.unserialize(bytes);  
//      }  
}  
