package com.info.model;

import javax.json.bind.annotation.JsonbProperty;

public class StateCityInfo {

	
	public StateCityInfo() {
		super();
	}
	private String state;
	private String city;
	private String capital;
	private int population;
	private int temp;
	
	
	public StateCityInfo(String state, String city, String capital, int population, int temp) {
		super();
		this.state = state;
		this.city = city;
		this.capital = capital;
		this.population = population;
		this.temp = temp;
	}

	
	@JsonbProperty("state")
	public void setState(String state) {
		this.state = state;
	}
	public String getState() {
		return state;
	}
	
	
	@JsonbProperty("city")
	public void setCity(String city) {
		this.city = city;
	}
	public String getCity() {
		return city;
	}
	
	
	@JsonbProperty("capital")
	public void setCapital(String capital) {
		this.capital = capital;
	}
	public String getCapital() {
		return capital;
	}
	
	
	@JsonbProperty("population")
	public void setPopulation(int population) {
		this.population = population;
	}
	public int getPopulation() {
		return population;
	}
	
	
	@JsonbProperty("temp")
	public int getTemp() {
		return temp;
	}
	public void setTemp(int temp) {
		this.temp = temp;
	}
	
	
	
	
}
