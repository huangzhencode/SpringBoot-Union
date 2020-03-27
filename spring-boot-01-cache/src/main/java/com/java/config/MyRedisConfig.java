//package com.java.config;
//
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.cache.RedisCacheConfiguration;
//import org.springframework.data.redis.cache.RedisCacheManager;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
//import org.springframework.data.redis.serializer.RedisSerializationContext;
//import org.springframework.data.redis.serializer.StringRedisSerializer;
//
//import java.io.Serializable;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import static io.netty.util.CharsetUtil.UTF_8;
//
//
///**
// * @author huangzhen
// * @create 2020-03-20 20:10
// */
//@Configuration
//public class MyRedisConfig {
//
//    @Bean
//    public RedisTemplate<String, Serializable> redisTemplate(LettuceConnectionFactory connectionFactory) {
//        RedisTemplate<String, Serializable> template = new RedisTemplate<>();
//        template.setConnectionFactory(connectionFactory);
//        //添加---一个转换为json格式的序列化器
//        template.setKeySerializer(new StringRedisSerializer(UTF_8));
//        template.setDefaultSerializer(new Jackson2JsonRedisSerializer<>(Serializable.class));
//        return template;
//    }
//
//
//
//}
