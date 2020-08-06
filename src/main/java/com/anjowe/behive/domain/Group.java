package com.anjowe.behive.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Group {
	/**
	 * The name of user's group
	 */
	private String name;

	public Group() {
		this.name = "";
	}
}
