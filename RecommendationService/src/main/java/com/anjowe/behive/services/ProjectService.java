package com.anjowe.behive.services;

import java.util.List;

import com.anjowe.behive.domain.Candidate;
import com.anjowe.behive.domain.Project;
import com.anjowe.behive.domain.User;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProjectService {
	public Flux<User> getAllUsers();

	public Mono<List<Candidate>> recommendUsers(Project project);
}
