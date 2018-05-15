package controller;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import model.HomeResponse;
import model.Sensor;
import socket.AdruinoSocket;

@Controller
public class HomeController {

	@RequestMapping(value = "/" , method = RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("home");
		return modelAndView;
	}
	
	@RequestMapping(value = "/getAllSensorsInfo", method = RequestMethod.GET)
	@ResponseBody
	public HomeResponse getAllSensor(){
		HomeResponse homeResponse = new HomeResponse();
		List<Sensor> sensorList = new ArrayList<Sensor>();
		String host = "192.168.1.177";
		Integer port = 80;
//		Sensor sensor = AdruinoSocket.connectToGetAdruinoData(host, port);
		Sensor sensor = new Sensor();
		sensor.setTemperature(10.0);
		sensor.setHumidity(10.01);
		sensor.setLocation("BH");
		sensor.setSound(0);
		sensor.setDateTime(new DateTime());
		sensorList.add(sensor);
		homeResponse.setSensorsList(sensorList);
		return homeResponse;		
	}
}
