package com.unacademy.redis.jedis.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.unacademy.redis.jedis.model.Programmer;
import com.unacademy.redis.jedis.service.ProgrammerService;

@RestController
public class ProgrammerController {
	@Autowired
	ProgrammerService programmerService;

	@PostMapping("/programmer-string")
	public void addProgrammer(@RequestBody Programmer programmer) throws JsonProcessingException {
		programmerService.setProgrammerAsString(String.valueOf(programmer.getId()),
				programmer);
	}

	@GetMapping("/programmer-string/{id}")
	public Programmer readString(@PathVariable String id) {
		return programmerService.getProgrammerAsString(id);
	}

	@PostMapping("/programmer-list")
	public void addToProgrammerList(@RequestBody List<Programmer> programmers) {
		programmers.forEach((programmer)->programmerService.addToProgrammersList(programmer));
	}

	@GetMapping("/programmer-list")
	public List<Programmer> getProgrammerListMembers() {
		return programmerService.getProgrammerListMembers();
	}

	@GetMapping("/programmer-list/count")
	public long getProgrammerListCount() {
		return programmerService.getProgrammerListCount();
	}
	
	@PostMapping("/programmer-set")
	public void addProgrammerSet(@RequestBody Set<Programmer> programmers)  throws JsonProcessingException {
		programmers.forEach((programmer)->programmerService.addToProgrammersSet(programmer));
	}
	
	@GetMapping("/programmer-set")
	public Set<Programmer> getProgrammerSet(){
		return programmerService.getProgrammerSetMembers();
	}
	@PostMapping("/isProgrammer")
	public boolean isProgrammerSet(@RequestBody Programmer programmer) throws JsonProcessingException {
		return programmerService.isProgrammer(programmer);
	}
}
