package external.utils;

import external.model.Direction;
import org.apache.commons.lang3.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;

final public class Utilities {

    private static final Logger LOGGER = LoggerFactory.getLogger(Utilities.class);

    public static Direction getDirectionForLatitudeDegreeDecimal(final String latitude){
        LOGGER.debug("getDirectionForLatitudeDegreeDecimal | latitude: {}",latitude);
        Double lat = Double.valueOf(latitude);
        LOGGER.info("latitude: ",lat);
        /***
         * some sort of calc to determine this,
         * but now we're expecting it to be in India only so N
         */
        return Direction.N;
    }

    public static Direction getDirectionForLongitudeDegreeDecimal(final String longitude){
        LOGGER.debug("getDirectionForLongitudeDegreeDecimal | longitude: {}",longitude);
        Double lon = Double.valueOf(longitude);
        LOGGER.info("longitude: ",lon);
        /***
         * some sort of calc to determine this,
         * but now we're expecting it to be in India only so E
         */
        return Direction.E;
    }

    public static String formatGpsTime(final String timeInMills, final String expectedFormat){
        LOGGER.debug("formatGpsTime | timeInMills: {}, expectedFormat: {}",timeInMills, expectedFormat);
        LocalDateTime localDateTime = convertMillisToCalendar(Long.valueOf(timeInMills));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(expectedFormat, Locale.ENGLISH);
        return formatter.format(localDateTime);
    }

    public static LocalDateTime convertMillisToCalendar(final long timeInMills){
        LOGGER.debug("convertMillisToCalendar | latitude: {}",timeInMills);
        LocalDateTime localDateTime =
                LocalDateTime.ofInstant(Instant.ofEpochMilli(timeInMills),
                        ZoneId.of("UTC+05:30"));
        return localDateTime;
    }

    public  static Boolean shouldSendToExternal(final String imeiNumber, String[] allowedImeiNumbers){
        LOGGER.trace("IMEI: {} | Whitelisted IMEIs {}", imeiNumber, Arrays.toString(allowedImeiNumbers));
        return ArrayUtils.contains(allowedImeiNumbers, imeiNumber);
    }

    public static Boolean isValidLong(final String longString){
        try{
            Long.valueOf(longString);
            return Boolean.TRUE;
        }catch (Exception e){
            return Boolean.FALSE;
        }
    }
}
