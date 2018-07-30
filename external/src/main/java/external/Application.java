package external;

import javax.jms.ConnectionFactory;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;
import com.fasterxml.jackson.databind.ObjectMapper;

import external.model.ExternalRequest;
import external.model.ExternalResponse;
import external.model.GpsEvent;


@SpringBootApplication
@EnableJms
public class Application {

    @Bean
    public JmsListenerContainerFactory<?> getJmsListenerContainerFactory(ConnectionFactory connectionFactory,
                                                    DefaultJmsListenerContainerFactoryConfigurer configurer) {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        // This provides all boot's default to this factory, including the message converter
        configurer.configure(factory, connectionFactory);
        // You could still override some of Boot's default if necessary.
        return factory;
    }

    @Bean // Serialize message content to json using TextMessage
    public MessageConverter jacksonJmsMessageConverter() {
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setTargetType(MessageType.TEXT);
        converter.setTypeIdPropertyName("_type");
        return converter;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
    public static void main1(String arg[]) throws Exception {
    	System.out.println("Hell oWorld!!");
    	GpsEvent gpsEvent = new GpsEvent();
    	gpsEvent.setImeiNo("387785175687813");
    	gpsEvent.setBatteryVoltage("5.5");
    	gpsEvent.setLattitude("76.34343");
    	gpsEvent.setLongitude("34.5555");
    	gpsEvent.setTime("1532877542");
    	gpsEvent.setSpeed("60");
    	System.out.println("gpsEvent: "+gpsEvent);
    	ExternalRequest request = ExternalRequestFactory.getInstance().createExternalRequest(gpsEvent);
    	System.out.println("request: "+request);
    	ObjectMapper mapper = new ObjectMapper();
        mapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
    	String data = mapper.writeValueAsString(request);
    	System.out.println("data: "+data);
    	
    	String resData = "{\"status\":\"true\"}";
    	ExternalResponse response = mapper.readValue(resData, ExternalResponse.class);
    	System.out.println("response: "+response);
    } 
}
