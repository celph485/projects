package external;

import external.model.ExternalRequest;
import external.model.ExternalResponse;
import external.utils.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@Component
class ExternalResponseHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExternalResponseHandler.class);


    @Autowired
    private ExternalResponseFailureHandler failureHandler;

    Boolean handle(final ExternalRequest request, final ExternalResponse response){
        LOGGER.info("External Response: {}", response);

        if(!isPositiveRepose(response)){
            LOGGER.info("Negative response, sending request and response to ExternalResponseFailureHandler");
            return failureHandler.handle(request, response);
        }

        LOGGER.info("Positive response, ending flow");
        return Boolean.TRUE;
    }


    private Boolean isPositiveRepose(final ExternalResponse response){
    	return 
    			Constants.TRUE.equalsIgnoreCase(response.getStatus()) ||
    			Constants.TRUE.equalsIgnoreCase(response.getResult());
    }


}
