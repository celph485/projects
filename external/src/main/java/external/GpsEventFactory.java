package external;

import external.model.GpsEvent;
import external.utils.Constants;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

/**
 * This class is not being used.
 * It was there if MQ sends String instead of GpsEvent object
 *
 */
final class GpsEventFactory {

    private static final Logger LOGGER = LoggerFactory.getLogger(GpsEventFactory.class);

    Optional<GpsEvent> createGpsEvent(final String data){

        LOGGER.debug("creating gps event object from {}", data);

        if(!isValidDataString(data)){
            return Optional.empty();
        }

        return Optional.of(createGpsEventFromValidDataString(data));
    }

    private GpsEvent createGpsEventFromValidDataString(final String data){
        GpsEvent gpsEvent = new GpsEvent();

        for(String pair : StringUtils.split(data, Constants.PAIR_SEPARATOR)){

            String[] entry = StringUtils.split(pair, Constants.KEY_VALUE_SEPARATOR);

            if(StringUtils.equalsIgnoreCase(Constants.IMEI_NO, entry[0])){
                gpsEvent.setImeiNo(entry[1]);
            }

            if(StringUtils.equalsIgnoreCase(Constants.LATTITUDE, entry[0])){
                gpsEvent.setLattitude(entry[1]);
            }

            if(StringUtils.equalsIgnoreCase(Constants.LONGITUDE, entry[0])){
                gpsEvent.setLongitude(entry[1]);
            }

            if(StringUtils.equalsIgnoreCase(Constants.SPEED, entry[0])){
                gpsEvent.setSpeed(entry[1]);
            }

            if(StringUtils.equalsIgnoreCase(Constants.TIME, entry[0])){
                gpsEvent.setTime(entry[1]);
            }

            if(StringUtils.equalsIgnoreCase(Constants.BATTERY_VOLTAGE, entry[0])){
                gpsEvent.setBatteryVoltage(entry[1]);
            }
        }
        return gpsEvent;
    }

    private Boolean isValidDataString(final String data){
        if(StringUtils.isBlank(data)){
            LOGGER.warn("blank data found");
            return Boolean.FALSE;
        }

        if(Constants.EXPECTED_PAIR_SEPARATOR_COUNT !=
                StringUtils.countMatches(data, Constants.PAIR_SEPARATOR)){
            LOGGER.warn("Expecting pair separator {}, count to be {}, not matched.",
                    Constants.PAIR_SEPARATOR, Constants.EXPECTED_PAIR_SEPARATOR_COUNT);
            return Boolean.FALSE;
        }

        if(Constants.EXPECTED_KEY_VALUE_SEPARATOR_COUNT !=
                StringUtils.countMatches(data, Constants.KEY_VALUE_SEPARATOR)){
            LOGGER.warn("Expecting pair separator {}, count to be {}, not matched.",
                    Constants.KEY_VALUE_SEPARATOR, Constants.EXPECTED_KEY_VALUE_SEPARATOR_COUNT);
            return Boolean.FALSE;
        }

        return Boolean.TRUE;
    }

    private GpsEventFactory(){};

    static GpsEventFactory getInstance(){
        return Holder.INSTANCE;
    }

    private static class Holder{
        private static final GpsEventFactory INSTANCE = new GpsEventFactory();
    }
}
