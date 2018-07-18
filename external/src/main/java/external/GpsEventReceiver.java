package external;

import external.model.GpsEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;


import static external.utils.Constants.EXT_MQ_GPS_EVENT;
import static external.utils.Constants.JMS_FACTORY;

@Component
class GpsEventReceiver {

    private static final Logger LOGGER = LoggerFactory.getLogger(GpsEventReceiver.class);

    @Autowired
    private GpsEventProcessor processor;

    @JmsListener(destination = EXT_MQ_GPS_EVENT, containerFactory = JMS_FACTORY)
    void receive(GpsEvent gpsEvent){
        LOGGER.debug("Gps Event received from queue: {}", gpsEvent);
        processor.processMessage(gpsEvent);
    }
}
