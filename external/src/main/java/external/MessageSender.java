package external;

import external.model.ExternalRequest;
import external.model.ExternalResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
class MessageSender {

    private static final Logger LOGGER = LoggerFactory.getLogger(MessageSender.class);

    @Value("${external.target.web-service.url}")
    private String targetWebServiceUrl;

    @Autowired
    private RestTemplate restTemplate;

    ExternalResponse sendRequest(final ExternalRequest request){
        LOGGER.debug("Target Url: {}", targetWebServiceUrl);
        LOGGER.debug("Sending External Request: {}", request);
        HttpEntity<ExternalRequest> requestHttpEntity = new HttpEntity<>(request);
        return restTemplate.postForObject(targetWebServiceUrl, requestHttpEntity, ExternalResponse.class);
    }
}
