package com.ra.football.matchscores.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Stats {
	
	@JsonProperty(value = "home_score")
	private String homeTeamScore;
	
	@JsonProperty(value = "away_score")
	private String awayTeamScore;
	
	@JsonProperty(value = "ht_score")
	private String halfTimeScore;

	@JsonProperty(value = "ft_score")
	private String fullTimeScore;
	
	public Stats() {
		super();
	}

	public String getHomeTeamScore() {
		return homeTeamScore;
	}

	public void setHomeTeamScore(String homeTeamScore) {
		this.homeTeamScore = homeTeamScore;
	}

	public String getAwayTeamScore() {
		return awayTeamScore;
	}

	public void setAwayTeamScore(String awayTeamScore) {
		this.awayTeamScore = awayTeamScore;
	}

	public String getHalfTimeScore() {
		return halfTimeScore;
	}

	public void setHalfTimeScore(String halfTimeScore) {
		this.halfTimeScore = halfTimeScore;
	}


	public String getFullTimeScore() {
		return fullTimeScore;
	}

	public void setFullTimeScore(String fullTimeScore) {
		this.fullTimeScore = fullTimeScore;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Stats [homeTeamScore=");
		builder.append(homeTeamScore);
		builder.append(", awayTeamScore=");
		builder.append(awayTeamScore);
		builder.append(", halfTimeScore=");
		builder.append(halfTimeScore);
		builder.append(", fullTimeScore=");
		builder.append(fullTimeScore);
		builder.append("]");
		return builder.toString();
	}
}