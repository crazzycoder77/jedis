package com.unacademy.redis.jedis.service;

import java.util.List;
import java.util.Set;

import com.unacademy.redis.jedis.model.Programmer;

public interface ProgrammerService {

	void setProgrammerAsString(String idKey, Programmer pogrammer);

	Programmer getProgrammerAsString(String idKey);

	void addToProgrammersList(Programmer programmer);

	List<Programmer> getProgrammerListMembers();

	long getProgrammerListCount();

	void addToProgrammersSet(Programmer programmer);

	Set<Programmer> getProgrammerSetMembers();

	boolean isProgrammer(Programmer programmer);
}
