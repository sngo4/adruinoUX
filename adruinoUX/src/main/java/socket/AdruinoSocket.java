package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

import model.Sensor;

public class AdruinoSocket {
	
	public static Sensor connectToGetAdruinoData(String host, Integer port) {
		Sensor sensor = new Sensor();
		try {
			@SuppressWarnings("resource")
			Socket socket = new Socket(host, port);
			OutputStream output = socket.getOutputStream();
			PrintWriter writer = new PrintWriter(output, true);
			writer.println("\n");
			InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            String line = null;
            int i = 0;
            while(true) {
            	line = reader.readLine();
            	if (i == 0) {
            		Double temperature = Double.parseDouble(line);
            		temperature = (double) (Math.round(temperature*10)/10);
            		sensor.setTemperature(temperature);
            	} else if(i == 1) {
            		Double humidity = Double.parseDouble(line);
            		sensor.setHumidity(humidity);
            	}
            	++i;
            	if (line == null){
            		return sensor;
            	}
            }
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sensor;
	}
	
}
