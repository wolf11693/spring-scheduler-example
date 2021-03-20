package com.ra.football.matchscores.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Matches {

	@JsonProperty(value = "data" )
	private List<Match> listMatchs;

	public Matches() {
		super();
	}

	public List<Match> getListMatchs() {
		return listMatchs;
	}

	public void setListMatchs(List<Match> listMatchs) {
		this.listMatchs = listMatchs;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Matches [listMatchs=");
		builder.append(listMatchs);
		builder.append("]");
		return builder.toString();
	}
}