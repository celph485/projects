package external;

import com.fasterxml.jackson.databind.ObjectMapper;

import external.model.GpsEvent;

public class EventDispatcher {
    static void sendDataOut(
	    String imeiNo,
	    String lattitude,
	    String longitude,
	    String speed,
	    String time,
	    String batteryVoltage){
	
	GpsEvent event = new GpsEvent();

	event.setImeiNo(imeiNo);
	event.setLattitude(lattitude);
	event.setLongitude(longitude);
	event.setSpeed(speed);
	event.setTime(time);
	event.setBatteryVoltage(batteryVoltage);
	
	//Print.logInfo("sending to mq | "+event.toString());
	try{
	    ObjectMapper mapper = new ObjectMapper();
	    final String data = mapper.writeValueAsString(event);
	    MqSender.getInstance().send(data);
	}catch(Exception e){
	    //Print.logInfo("Error while sending event to mq | "+e.getMessage());
	    e.printStackTrace();
	}
    }
}
