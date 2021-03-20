package com.ra.football.matchscores.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Match {

	@JsonProperty(value = "match_start")
	private String matchStart;
	
	@JsonProperty(value = "home_team" )
	private Team homeTeam;
	
	@JsonProperty(value = "away_team" )
	private Team awayTeam;
	
	@JsonProperty(value = "group")
	private Tournament tournament;
	
	@JsonProperty(value = "stats" )
	private Stats stats;
	
	public Match() {
		super();
	}

	public String getMatchSatrt() {
		return matchStart;
	}

	public void setMatchSatrt(String matchSatrt) {
		this.matchStart = matchSatrt;
	}

	public Team getHomeTeam() {
		return homeTeam;
	}

	public void setHomeTeam(Team homeTeam) {
		this.homeTeam = homeTeam;
	}

	public Team getAwayTeam() {
		return awayTeam;
	}

	public void setAwayTeam(Team awayTeam) {
		this.awayTeam = awayTeam;
	}

	public Tournament getTournament() {
		return tournament;
	}

	public void setTournament(Tournament tournament) {
		this.tournament = tournament;
	}

	public Stats getStats() {
		return stats;
	}

	public void setStats(Stats stats) {
		this.stats = stats;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Match [matchSatrt=");
		builder.append(matchStart);
		builder.append(", homeTeam=");
		builder.append(homeTeam);
		builder.append(", awayTeam=");
		builder.append(awayTeam);
		builder.append(", tournament=");
		builder.append(tournament);
		builder.append(", stats=");
		builder.append(stats);
		builder.append("]");
		return builder.toString();
	}
}