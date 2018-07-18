package external;

import external.model.ExternalRequest;
import external.model.ExternalResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import static external.utils.Constants.FAILURE_LOGGER;

/**
 * At the moment only log the request response into separate log file.
 */
@Component
public class ExternalResponseFailureHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(FAILURE_LOGGER);

    Boolean handle(final ExternalRequest request, final ExternalResponse response){

        LOGGER.info("Request {} | Response {}", request, response);
        return Boolean.TRUE;
    }

}
