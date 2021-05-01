package com.wolox.useralbum.integration.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Paola Pino
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Geo {

	private String lat;
	private String lng;

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}

}
