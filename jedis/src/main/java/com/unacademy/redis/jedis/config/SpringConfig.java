package com.unacademy.redis.jedis.config;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.util.StringUtils;

import com.unacademy.redis.jedis.model.Programmer;

//Jedis Config Bean
@Configuration
public class SpringConfig {
	@Value("${redis.host}")
	private String hostName;
	@Value("${redis.port}")
	private int port;
	@Value("${redis.password}")
	private String password;

	@Value("${redis.jedis.pool.max-total}")
	private int maxTotal;
	@Value("${redis.jedis.pool.max-idle}")
	private int maxIdle;
	@Value("${redis.jedis.pool.min-idle}")
	private int minIdle;

	@Bean
	public JedisClientConfiguration getJedisClientConfiguration() {
		JedisClientConfiguration.JedisPoolingClientConfigurationBuilder jedisPoolingClientConfigurationBuilder = (JedisClientConfiguration.JedisPoolingClientConfigurationBuilder) JedisClientConfiguration
				.builder();
		GenericObjectPoolConfig genericObjectPoolConfig = new GenericObjectPoolConfig();
		genericObjectPoolConfig.setMaxTotal(maxTotal);
		genericObjectPoolConfig.setMaxIdle(maxIdle);
		genericObjectPoolConfig.setMinIdle(minIdle);
		return jedisPoolingClientConfigurationBuilder.poolConfig(genericObjectPoolConfig).build();
	}
	
	@Bean
	public JedisConnectionFactory getJedisConnectionFactory() {
		RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration(hostName, port);
		if(!StringUtils.isEmpty(password)) {
			redisStandaloneConfiguration.setPassword(RedisPassword.of(password));
		}
		return new JedisConnectionFactory(redisStandaloneConfiguration, getJedisClientConfiguration());
	}
	
	@Bean
	@Qualifier("redisTemplate")
	public RedisTemplate<String, Programmer> redisTemplate(){
		RedisTemplate<String, Programmer> redisTemplate= new RedisTemplate<>();
		redisTemplate.setConnectionFactory(getJedisConnectionFactory());
		return redisTemplate;
	}

	@Bean
	@Qualifier("listOperations")
	public ListOperations<String, Programmer> listOperations(@Qualifier("redisTemplate") RedisTemplate<String, Programmer> redisTemplate){
		return redisTemplate.opsForList();
	}
	
	@Bean
	@Qualifier("zSetOperations")
	public ZSetOperations<String, Programmer> setOperations(@Qualifier("redisTemplate") RedisTemplate<String, Programmer> redisTemplate){
		return redisTemplate.opsForZSet();
	}
	
}
