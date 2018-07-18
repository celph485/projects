package external;

import external.model.ExternalRequest;
import external.model.GpsEvent;
import external.utils.Utilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
class GpsEventProcessor {

    private static final Logger LOGGER = LoggerFactory.getLogger(GpsEventProcessor.class);

    @Autowired
    private ExternalRequestProcessor requestProcessor;

    @Value("${external.allowed.imei-numbers}")
    private String[] allowedImeiNumbers;

    private GpsEventValidator gpsEventValidator = GpsEventValidator.getInstance();

    Boolean processMessage(final GpsEvent gpsEvent){
        LOGGER.debug("Processing GpsEvent: {}", gpsEvent);

        if(!gpsEventValidator.validate(gpsEvent)){
            LOGGER.warn("Invalid Gps Event received from queue: {}", gpsEvent);
            return Boolean.FALSE;
        }

        if(!Utilities.shouldSendToExternal(gpsEvent.getImeiNo(), allowedImeiNumbers)){
            LOGGER.info("IMEI is not whitelisted | IMEI: {}",gpsEvent.getImeiNo());
            return Boolean.FALSE;
        }

        ExternalRequest request = ExternalRequestFactory.getInstance().createExternalRequest(gpsEvent);

        return requestProcessor.processMessage(request);
    }
}
