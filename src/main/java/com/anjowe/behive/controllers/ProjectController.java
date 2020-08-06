package com.anjowe.behive.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.anjowe.behive.domain.Candidate;
import com.anjowe.behive.domain.Project;
import com.anjowe.behive.services.ProjectService;

import reactor.core.publisher.Mono;

@RestController
public class ProjectController {

	private ProjectService projectService;

	@Autowired
	public void setProjectService(ProjectService projectService) {
		this.projectService = projectService;
	}

	@PostMapping("/project/recommendations")
	public Mono<List<Candidate>> getCandidates(@RequestBody Project project) {
		return projectService.recommendUsers(project);
	}
}
