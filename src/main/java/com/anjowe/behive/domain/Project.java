package com.anjowe.behive.domain;

import java.util.ArrayList;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Project {

	private String name;
	private String owner;
	private String status;
	private String description;
	private boolean isPublic;
	private ArrayList<String> team;
	private Map<String, Integer> availableSpots;
	private ArrayList<Position> positions;

}
