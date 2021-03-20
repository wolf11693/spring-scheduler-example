package com.ra.football.matchscores.task;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.ra.football.matchscores.model.Match;
import com.ra.football.matchscores.model.Matches;

@Component
public class ScheduledTasks {

	private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private WSRequest wsRequest;
	
	/*
	 *  fixedRate specifica l'intervallo tra le chiamate dei metodi, 
	 *  misurato dall'ora di inizio di ciascuna chiamata. 
	 *  
	 *  Sono disponibili altre opzioni , ad esempio fixedDelay, 
	 *  che specifica l'intervallo tra le chiamate misurato dal completamento dell'attività. 
	 *  
	 *  È inoltre possibile utilizzare @Scheduled(cron=". . .") espressioni 
	 *  per una pianificazione delle attività più sofisticata.
	 * */
	@Scheduled(fixedRate = 60*1000)
	public void callWs() {
		log.info("callWs - START - {}", dateFormat.format(new Date()));
		
		this.wsRequest.setPath("/api/v1/soccer/matches");
		this.wsRequest.getQueryParams().put("season_id", "352");
		this.wsRequest.getQueryParams().put("date_from", "2021-03-13");
		this.wsRequest.getQueryParams().put("date_to", "2021-03-15");
		
		ResponseEntity<Matches> response = null;
		if(wsRequest.getMethod().equals(HttpMethod.GET)) {
			response  = restTemplate.getForEntity(wsRequest.build(), Matches.class);
		}

		List<Match> premierLeagueMatch = response.getBody()
												 .getListMatchs()
												 .stream()
												 .filter( match -> match.getTournament() == null || match.getTournament().getName().equals("Premier League")).collect(Collectors.toList()); 
		
		List<Match> todayMatch = premierLeagueMatch.stream()
												   .filter(match -> match.getMatchSatrt().contains("2021-03-14"))
												   .collect(Collectors.toList());
		log.info("{}", todayMatch);
		log.info("callWs - END");
	}
}
