package external;

import external.model.GpsEvent;

public class App {

    public static void main(String[] args) throws Exception {
	System.out.println("Hello World!!!");
	
	for(GpsEvent event : Feed.getGpsEvent()){
	    EventDispatcher.sendDataOut(
		    event.getImeiNo(), 
		    event.getLattitude(), 
		    event.getLongitude(), 
		    event.getSpeed(), 
		    event.getTime(), 
		    event.getBatteryVoltage());
	}

    }

}