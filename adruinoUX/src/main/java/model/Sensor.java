package model;

import org.joda.time.DateTime;

public class Sensor {
	private String location;
	private Double temperature;
	private Double humidity;
	private DateTime dateTime;
	private Integer sound;
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Double getTemperature() {
		return temperature;
	}
	public void setTemperature(Double temperature) {
		this.temperature = temperature;
	}
	public Double getHumidity() {
		return humidity;
	}
	public void setHumidity(Double humidity) {
		this.humidity = humidity;
	}
	public DateTime getDateTime() {
		return dateTime;
	}
	public void setDateTime(DateTime dateTime) {
		this.dateTime = dateTime;
	}
	public Integer getSound() {
		return sound;
	}
	public void setSound(Integer sound) {
		this.sound = sound;
	}
}
