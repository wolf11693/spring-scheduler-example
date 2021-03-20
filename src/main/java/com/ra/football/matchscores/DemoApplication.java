package com.ra.football.matchscores;

import java.time.Duration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

import com.ra.football.matchscores.task.WSRequest;

@SpringBootApplication
@EnableScheduling
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public RestTemplate getRestTemplate(RestTemplateBuilder builder) {

		return builder.setConnectTimeout(Duration.ofMillis(15000)).setReadTimeout(Duration.ofMillis(15000)).build();
	}

	@Bean
	public WSRequest getWSRequest() {
		return new WSRequest();
	}
}
