package com.anjowe.behive.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.reactive.function.client.WebClient;

import com.anjowe.behive.domain.Candidate;
import com.anjowe.behive.domain.Project;
import com.anjowe.behive.domain.User;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private WebClient.Builder webClientBuilder;

	@Override
	public Flux<User> getAllUsers() {
		return webClientBuilder.build().get().uri("http://UserService/users/available").retrieve()
				.bodyToFlux(User.class);
	}

	@Override
	public Mono<List<Candidate>> recommendUsers(Project project) {

		return getAllUsers().collectList().map(users -> {
			List<Candidate> recomendedUsers = new ArrayList<Candidate>();
			for (int pId = 0; pId < project.getPositions().size(); pId++) {
				for (int i = 0; i < users.size(); i++) {
					Candidate c = new Candidate();
					c.setName(users.get(i).getFirstName() + " " + users.get(i).getLastName());
					c.setPosition(project.getPositions().get(pId).getName());
					c.setUsername(users.get(i).getUsername());
					c.setCompatibility(jaccardSimilarity(project.getPositions().get(pId).getSkills(),
							users.get(i).getSkillStats().keySet()));
					recomendedUsers.add(c);
				}
			}
			return recomendedUsers;
		});
	}

	public static double jaccardSimilarity(Set<String> a, Set<String> b) {
		a.retainAll(b);
		return (a.size() * 1d) / a.size();
	}

}
