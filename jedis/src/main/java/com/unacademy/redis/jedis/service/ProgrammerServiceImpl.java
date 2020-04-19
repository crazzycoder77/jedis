package com.unacademy.redis.jedis.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unacademy.redis.jedis.dao.ProgrammerRepository;
import com.unacademy.redis.jedis.model.Programmer;

@Service
@Qualifier("programmerService")
public class ProgrammerServiceImpl implements ProgrammerService {

	@Autowired
	private ProgrammerRepository programmerRepository;

	@Override
	public void setProgrammerAsString(String idKey, Programmer programmer) {
		programmerRepository.setProgrammer(idKey, programmer);
	}

	@Override
	public Programmer getProgrammerAsString(String idKey) {
		return programmerRepository.getProgrammer(idKey);
	}

	@Override
	public void addToProgrammersList(Programmer programmer) {
		programmerRepository.addToProgrammersList(programmer);
	}

	@Override
	public List<Programmer> getProgrammerListMembers() {
		return programmerRepository.getProgrammerListMembers();
	}

	@Override
	public long getProgrammerListCount() {
		return programmerRepository.getProgrammerListCount();
	}

	@Override
	public void addToProgrammersSet(Programmer programmer) {
		programmerRepository.addToProgrammersSet(programmer);
	}

	@Override
	public Set<Programmer> getProgrammerSetMembers() {
		return programmerRepository.getProgrammerSetMembers();
	}

	@Override
	public boolean isProgrammer(Programmer programmer) {
		try {
			programmerRepository.isProgrammer(programmer);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

}
