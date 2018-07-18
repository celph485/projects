package external;

import java.util.ArrayList;
import java.util.List;

import external.model.GpsEvent;

public class Feed {
    
    static List<GpsEvent> getGpsEvent(){
	
	List<GpsEvent> data = new ArrayList<>();	
	GpsEvent event = new GpsEvent();

	event.setImeiNo("356938035643809");
	event.setLattitude("38.6457181");
	event.setLongitude("-121.3808155");
	event.setSpeed("22");
	event.setTime("1432764421");
	event.setBatteryVoltage("0");
	data.add(event);
	event = new GpsEvent();

	event.setImeiNo("387785175687815");
	event.setLattitude("38.63842249");
	event.setLongitude("-121.4916015");
	event.setSpeed("104");
	event.setTime("1432764728");
	event.setBatteryVoltage("0");
	data.add(event);
	event = new GpsEvent();

	event.setImeiNo("387785175687816");
	event.setLattitude("38.57549787");
	event.setLongitude("-121.5701795");
	event.setSpeed("102");
	event.setTime("1432765034");
	event.setBatteryVoltage("0");
	data.add(event);
	event = new GpsEvent();

	event.setImeiNo("387785175687813");
	event.setLattitude("38.55678678");
	event.setLongitude("-121.6781116");
	event.setSpeed("104");
	event.setTime("1432765342");
	event.setBatteryVoltage("0");
	data.add(event);
	event = new GpsEvent();

	event.setImeiNo("387785175687814");
	event.setLattitude("38.51521254");
	event.setLongitude("-121.7753363");
	event.setSpeed("105");
	event.setTime("1432765649");
	event.setBatteryVoltage("0");
	data.add(event);
	event = new GpsEvent();

	event.setImeiNo("387785175687814");
	event.setLattitude("38.4465158");
	event.setLongitude("-121.8579912");
	event.setSpeed("106");
	event.setTime("1432765959");
	event.setBatteryVoltage("0");
	data.add(event);
	event = new GpsEvent();

	event.setImeiNo("387785175687814");
	event.setLattitude("38.38201404");
	event.setLongitude("-121.9425344");
	event.setSpeed("103");
	event.setTime("1432766270");
	event.setBatteryVoltage("0");
	data.add(event);
	event = new GpsEvent();

	event.setImeiNo("387785175687814");
	event.setLattitude("38.32252264");
	event.setLongitude("-122.0259404");
	event.setSpeed("105");
	event.setTime("1432766578");
	event.setBatteryVoltage("0");
	data.add(event);
	event = new GpsEvent();

	event.setImeiNo("387785175687814");
	event.setLattitude("38.24456692");
	event.setLongitude("-122.0819664");
	event.setSpeed("106");
	event.setTime("1432766887");
	event.setBatteryVoltage("0");
	data.add(event);	
	
	return data;
	
    }

}
