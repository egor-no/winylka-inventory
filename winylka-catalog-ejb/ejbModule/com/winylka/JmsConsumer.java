package com.winylka;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

@MessageDriven(
		activationConfig = { @ActivationConfigProperty(
				propertyName = "destination", propertyValue = "/jms/queue/winylkaQ"), @ActivationConfigProperty(
				propertyName = "destinationType", propertyValue = "javax.jms.Queue")
		}, 
		mappedName = "/jms/queue/winylkaQ")
public class JmsConsumer implements MessageListener {

    public JmsConsumer() {
       
    }
	
    public void onMessage(Message message) {
    	try {
	        System.out.println("A new message: ");
	        System.out.println(message.getBody(String.class));
    	} catch (JMSException ex) {
    		ex.printStackTrace();
    	}
    }

}
