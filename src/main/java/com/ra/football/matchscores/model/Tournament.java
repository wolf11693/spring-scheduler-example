package com.ra.football.matchscores.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Tournament {

	@JsonProperty(value = "group_name")
	private String name;

	public Tournament() {
		super();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Tournament [name=");
		builder.append(name);
		builder.append("]");
		return builder.toString();
	}
}