package com.ra.football.matchscores.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Team {

	@JsonProperty(value = "name")
	private String name;

	@JsonProperty(value = "short_code")
	private String shortName;

	@JsonProperty(value = "logo")
	private String urlLogo;
	
	public Team() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getUrlLogo() {
		return urlLogo;
	}

	public void setUrlLogo(String urlLogo) {
		this.urlLogo = urlLogo;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Team [name=");
		builder.append(name);
		builder.append(", shortName=");
		builder.append(shortName);
		builder.append(", urlLogo=");
		builder.append(urlLogo);
		builder.append("]");
		return builder.toString();
	}	
}