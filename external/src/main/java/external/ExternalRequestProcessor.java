package external;

import external.model.ExternalRequest;
import external.model.ExternalResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class ExternalRequestProcessor {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExternalRequestProcessor.class);

    @Autowired
    private MessageSender messageSender;

    @Autowired
    private ExternalResponseHandler responseHandler;

    Boolean processMessage(ExternalRequest request){
        LOGGER.debug("External Request: {}", request);
        ExternalResponse response = messageSender.sendRequest(request);
        LOGGER.debug("External response: {}", response);
        return responseHandler.handle(request, response);
    }
}