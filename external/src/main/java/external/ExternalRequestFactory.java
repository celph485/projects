package external;

import external.model.ExternalRequest;
import external.model.GpsEvent;
import external.utils.Constants;
import external.utils.Utilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

final class ExternalRequestFactory {
    private static final Logger LOGGER = LoggerFactory.getLogger(ExternalRequestFactory.class);
    ExternalRequest createExternalRequest(final GpsEvent gpsEvent) {
        LOGGER.debug("Creating ExternalRequest object from gps event | {}", gpsEvent);
        final String imeiNo = gpsEvent.getImeiNo();
        final String lattitude = gpsEvent.getLattitude();
        final String longitude = gpsEvent.getLongitude();
        final String lattitudeDirection = Utilities.getDirectionForLatitudeDegreeDecimal(lattitude).toString();
        final String longitudeDirection = Utilities.getDirectionForLongitudeDegreeDecimal(longitude).toString();
        final String speed = gpsEvent.getSpeed();
        final String digitalPort1 = "0";
        final String digitalPort2 = "0";
        final String digitalPort3 = "0";
        final String digitalPort4 = "0";
        final String analogPort1 = "0";
        final String analogPort2 = "0";
        final String angle = "0";
        final String satellite = "0";
        final String time = gpsEvent.getTime();
        final String timeInMills = Utilities.formatGpsTime(time, Constants.EXPECTED_TIMESTAMP_PATTERN);
        final String batteryVoltage = gpsEvent.getBatteryVoltage();
        final String gpsValidity = "A";
        return new ExternalRequest(
                imeiNo,
                lattitude,
                longitude,
                lattitudeDirection,
                longitudeDirection,
                speed,
                digitalPort1,
                digitalPort2,
                digitalPort3,
                digitalPort4,
                analogPort1,
                analogPort2,
                angle,
                satellite,
                timeInMills,
                batteryVoltage,
                gpsValidity
        );
    }

    static ExternalRequestFactory getInstance() {
        return Holder.INSTANCE;
    }

    private static class Holder{
        private static ExternalRequestFactory INSTANCE = new ExternalRequestFactory();
    }
}