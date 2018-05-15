package model;

import java.util.List;

public class HomeResponse {
	private List<Sensor> sensorsList;

	public List<Sensor> getSensorsList() {
		return sensorsList;
	}

	public void setSensorsList(List<Sensor> sensorsList) {
		this.sensorsList = sensorsList;
	}
	
}
