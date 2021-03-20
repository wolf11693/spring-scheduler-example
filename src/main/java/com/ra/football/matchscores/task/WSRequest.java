package com.ra.football.matchscores.task;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpMethod;

public class WSRequest {

	private String apikey = "a8a01080-84a4-11eb-9fc1-ab38e3cf4f66";
	
	private String schema = "https";
	private String host = "app.sportdataapi.com";
	private String path;
	private Map<String, String> queryParams;
	private HttpMethod method = HttpMethod.GET;
	
	public WSRequest() {
		super();
		this.queryParams = new HashMap<>();
		this.queryParams.put("apikey", apikey);
	}

	public String getSchema() {
		return schema;
	}

	public WSRequest setSchema(String schema) {
		this.schema = schema;
		return this;
	}

	public String getHost() {
		return host;
	}

	public WSRequest setHost(String host) {
		this.host = host;
		return this;
	}

	public String getPath() {
		return path;
	}

	public WSRequest setPath(String path) {
		this.path = path;
		return this;
	}

	public Map<String, String> getQueryParams() {
		return queryParams;
	}

	public WSRequest setQueryParams(Map<String, String> queryParams) {
		this.queryParams = queryParams;
		return this;
	}
	
	public HttpMethod getMethod() {
		return method;
	}

	public void setMethod(HttpMethod method) {
		this.method = method;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("WSRequest [schema=");
		builder.append(schema);
		builder.append(", host=");
		builder.append(host);
		builder.append(", path=");
		builder.append(path);
		builder.append(", queryParams=");
		builder.append(queryParams);
		builder.append(", method=");
		builder.append(method);
		builder.append("]");
		return builder.toString();
	}

	public String build() {
		StringBuilder sb = new StringBuilder(this.schema)
												.append("://")
												.append(this.host)
												.append(this.path)
												.append("?");

		this.queryParams.entrySet()
						.stream()
						.forEach( entry -> sb.append(entry.getKey() + "=" + entry.getValue() + "&"));
	
		String requestUrl = sb.toString().substring(0, sb.toString().length()-1);
		return requestUrl;

	}	
}