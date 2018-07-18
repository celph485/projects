package external;

import external.model.GpsEvent;
import external.utils.Utilities;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static external.utils.Constants.*;

final class GpsEventValidator {

    private static final Logger LOGGER = LoggerFactory.getLogger(GpsEventValidator.class);

    Boolean validate(final GpsEvent gpsEvent){
        if(gpsEvent == null){
            LOGGER.debug("Invalid gpsEvent | null");
            return Boolean.FALSE;
        }

        if(!isValidImeiNumber(gpsEvent.getImeiNo())){
            LOGGER.debug("Invalid imei | {}",gpsEvent.getImeiNo());
            return Boolean.FALSE;
        }

        if(!isValidLatitude(gpsEvent.getLattitude())){
            LOGGER.debug("Invalid latitude | {}",gpsEvent.getLattitude());
            return Boolean.FALSE;
        }

        if(!isValidLongitude(gpsEvent.getLongitude())){
            LOGGER.debug("Invalid longitude | {}",gpsEvent.getLongitude());
            return Boolean.FALSE;
        }

        if(!isValidSpeed(gpsEvent.getSpeed())){
            LOGGER.debug("Invalid speed | {}",gpsEvent.getSpeed());
            return Boolean.FALSE;
        }

        if(!isValidTimeInMills(gpsEvent.getTime())){
            LOGGER.debug("Invalid Time | {}",gpsEvent.getTime());
            return Boolean.FALSE;
        }

        if(!isValidBattaryVoltage(gpsEvent.getBatteryVoltage())){
            LOGGER.debug("Invalid Battary Voltage | {}",gpsEvent.getBatteryVoltage());
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    private Boolean isValidImeiNumber(final String imeiNumber){
        if(StringUtils.isBlank(imeiNumber)){
            return Boolean.FALSE;
        }

        if(IMEI_STRING_LENGTH != imeiNumber.length()){
            return Boolean.FALSE;
        }

        return Utilities.isValidLong(imeiNumber);
    }

    private Boolean isValidLatitude(final String latitude){
        return Boolean.TRUE;
    }

    private Boolean isValidLongitude(final String latitude){
        return Boolean.TRUE;
    }

    private Boolean isValidSpeed(final String latitude){
        return Boolean.TRUE;
    }

    private Boolean isValidTimeInMills(final String latitude){
        return Boolean.TRUE;
    }

    private Boolean isValidBattaryVoltage(final String latitude){
        return Boolean.TRUE;
    }

    private GpsEventValidator(){}

    static GpsEventValidator getInstance(){
        return GpsEventValidator.Holder.INSTANCE;
    }

    private  static class Holder{
        public static GpsEventValidator INSTANCE = new GpsEventValidator();
    }
}
