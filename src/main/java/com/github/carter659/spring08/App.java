package com.github.carter659.spring08;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * 博客出处：http://www.cnblogs.com/GoodHelper/
 * 
 * @author 刘冬
 *
 */
@SpringBootApplication
@EnableCaching
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@Bean
	StringRedisTemplate template(RedisConnectionFactory connectionFactory) {
		return new StringRedisTemplate(connectionFactory);
	}
}
