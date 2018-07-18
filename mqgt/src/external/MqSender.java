package external;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

import com.fasterxml.jackson.core.JsonProcessingException;

final class MqSender {
    
    private MqSender(){}
    
    private static final String URL = "tcp://localhost:61616";
    private static final String QUEUE_NAME = "ext.gps.event";
    
    public void send(final String data) throws JMSException, JsonProcessingException {
	ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(URL);
        Connection connection = connectionFactory.createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Destination destination = session.createQueue(QUEUE_NAME);
        MessageProducer producer = session.createProducer(destination);
        producer.setDeliveryMode(DeliveryMode.PERSISTENT);
        TextMessage message = session.createTextMessage(data);
        message.setStringProperty("_type", "external.model.GpsEvent");
        producer.send(message);
        session.close();
        connection.close();
    }
    
    public static MqSender getInstance(){
	return Holder.INSTANCE;
    }
    
    private static class Holder{
	private static final MqSender INSTANCE = new MqSender();
    }
}
