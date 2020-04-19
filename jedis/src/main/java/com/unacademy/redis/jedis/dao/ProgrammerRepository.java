package com.unacademy.redis.jedis.dao;

import java.util.List;
import java.util.Set;

import com.unacademy.redis.jedis.model.Programmer;

public interface ProgrammerRepository {
	/************** STRING ****************/
	// set to redis
	void setProgrammer(String idKey, Programmer programmer);

	// get from redis
	Programmer getProgrammer(String idKey);

	/************** LIST ****************/
	// append to List
	void addToProgrammersList(Programmer programmer);

	// get from LIST
	List<Programmer> getProgrammerListMembers();

	// List Count
	long getProgrammerListCount();

	/************** SET ****************/
	// append to List
	void addToProgrammersSet(Programmer programmer);

	// get from LIST
	Set<Programmer> getProgrammerSetMembers();

	// List Count
	long isProgrammer(Programmer programmer);

}
