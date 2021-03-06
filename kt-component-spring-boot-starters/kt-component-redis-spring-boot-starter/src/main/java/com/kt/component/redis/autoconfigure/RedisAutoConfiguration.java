package com.kt.component.redis.autoconfigure;

import com.alibaba.fastjson.support.spring.FastJsonRedisSerializer;
import com.kt.component.redis.RedisService;
import com.kt.component.redis.RedisServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @ Description   :
 * @ Author        :  Javis
 * @ CreateDate    :  2020/11/09
 * @ Version       :  1.0
 */
@Slf4j
public class RedisAutoConfiguration extends CachingConfigurerSupport {

    public RedisAutoConfiguration() {
        log.info("启用Redis配置......");
    }

    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
        template.setConnectionFactory(factory);
        FastJsonRedisSerializer<Object> fastJsonRedisSerializer = new FastJsonRedisSerializer<>(Object.class);
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
//        // key采用String的序列化方式
        template.setKeySerializer(stringRedisSerializer);
//        // hash的key也采用String的序列化方式
        template.setHashKeySerializer(stringRedisSerializer);
//        // value序列化方式采用jackson
        template.setValueSerializer(fastJsonRedisSerializer);
//        // hash的value序列化方式采用jackson
        template.setHashValueSerializer(fastJsonRedisSerializer);
        template.afterPropertiesSet();
        return template;
    }

    @Bean("redisService")
    public RedisService redisService(RedisConnectionFactory factory) {
        return new RedisServiceImpl(redisTemplate(factory));
    }
}
