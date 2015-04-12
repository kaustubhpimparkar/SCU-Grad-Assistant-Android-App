package com.weather.project;

public class WeatherClass {
	
	private String currentTemperatureCelsius;
	private String currentTemperatureFahrenheit;
	private String weatherIconUrl;
	private String weatherDesc;
	private String weatherHumidity;
	private String weatherTemperatureMax;
	private String weatherTemperatureMin;
	private String weatherWindSpeedMiles;
	private String weatherLocation;
	private String weatherDate;
	
	
	public WeatherClass(){
		this.currentTemperatureCelsius = "";
		this.currentTemperatureCelsius= "";
		this.currentTemperatureFahrenheit= "";
		this.weatherIconUrl= "";
		this.weatherDesc= "";
		this.weatherHumidity= "";
		this.weatherTemperatureMax= "";
		this.weatherTemperatureMin= "";
		this.weatherWindSpeedMiles= "";
		this.weatherLocation = ""; 
		this.weatherDate = "";
	}
	
	public String getWeatherLocation() {
		return weatherLocation;
	}

	public void setWeatherLocation(String weatherLocation) {
		this.weatherLocation = weatherLocation;
	}

	public String getWeatherDate() {
		return weatherDate;
	}

	public void setWeatherDate(String weatherDate) {
		this.weatherDate = weatherDate;
	}
	public String getCurrentTemperatureCelsius() {
		return currentTemperatureCelsius;
	}
	public void setCurrentTemperatureCelsius(String currentTemperatureCelsius) {
		this.currentTemperatureCelsius = currentTemperatureCelsius;
	}
	public String getCurrentTemperatureFahrenheit() {
		return currentTemperatureFahrenheit;
	}
	public void setCurrentTemperatureFahrenheit(String currentTemperatureFahrenheit) {
		this.currentTemperatureFahrenheit = currentTemperatureFahrenheit;
	}
	public String getWeatherIconUrl() {
		return weatherIconUrl;
	}
	public void setWeatherIconUrl(String weatherIconUrl) {
		this.weatherIconUrl = weatherIconUrl;
	}
	public String getWeatherDesc() {
		return weatherDesc;
	}
	public void setWeatherDesc(String weatherDesc) {
		this.weatherDesc = weatherDesc;
	}
	public String getWeatherHumidity() {
		return weatherHumidity;
	}
	public void setWeatherHumidity(String weatherHumidity) {
		this.weatherHumidity = weatherHumidity;
	}
	public String getWeatherTemperatureMax() {
		return weatherTemperatureMax;
	}
	public void setWeatherTemperatureMax(String weatherTemperatureMax) {
		this.weatherTemperatureMax = weatherTemperatureMax;
	}
	public String getWeatherTemperatureMin() {
		return weatherTemperatureMin;
	}
	public void setWeatherTemperatureMin(String weatherTemperatureMin) {
		this.weatherTemperatureMin = weatherTemperatureMin;
	}
	public String getWeatherWindSpeedMiles() {
		return weatherWindSpeedMiles;
	}
	public void setWeatherWindSpeedMiles(String weatherWindSpeedMiles) {
		this.weatherWindSpeedMiles = weatherWindSpeedMiles;
	}
	
}
