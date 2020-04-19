package com.unacademy.redis.jedis.dao;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Repository;

import com.unacademy.redis.jedis.model.Programmer;

@Repository
@Qualifier("programmerRepository")
public class ProgrammerRepositoryImpl implements ProgrammerRepository {

	public static final String REDIS_LIST_KEY = "ProgammerList";
	public static final String REDIS_SET_KEY = "ProgammerSet";

	@Autowired
	private RedisTemplate<String, Programmer> redisTemplate;

	@Autowired
	private ListOperations<String, Programmer> listOperations;
	
	@Autowired
	private  ZSetOperations<String, Programmer>  zSetOperations;

	/************** SET/EXPIRE ****************/
	@Override
	public void setProgrammer(String idKey, Programmer programmer) {
		redisTemplate.opsForValue().set(idKey, programmer);

		redisTemplate.expire(idKey, 10, TimeUnit.MINUTES);

	}

	/************** GET ****************/
	@Override
	public Programmer getProgrammer(String idKey) {
		return redisTemplate.opsForValue().get(idKey);
	}

	/************** LPUSH ****************/
	@Override
	public void addToProgrammersList(Programmer programmer) {
		redisTemplate.opsForList().leftPush(REDIS_LIST_KEY, programmer);
	}

	/************** RANGE ****************/
	@Override
	public List<Programmer> getProgrammerListMembers() {
		return listOperations.range(REDIS_LIST_KEY, 0, -1);
	}

	/************** SIZE ****************/
	@Override
	public long getProgrammerListCount() {
		return listOperations.size(REDIS_LIST_KEY);
	}

	/************** ZADD ****************/
	@Override
	public void addToProgrammersSet(Programmer programmer) {
		zSetOperations.add(REDIS_SET_KEY, programmer, programmer.hashCode());

	}

	/************** ZRANGE ****************/
	@Override
	public Set<Programmer> getProgrammerSetMembers() {
		return zSetOperations.range(REDIS_SET_KEY, Long.MIN_VALUE, Long.MAX_VALUE);
	}

	/************** ZRANK ****************/
	@Override
	public long isProgrammer(Programmer programmer) {
		return zSetOperations.rank(REDIS_SET_KEY, programmer);
	}

}
