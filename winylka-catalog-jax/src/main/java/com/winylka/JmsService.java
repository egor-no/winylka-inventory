package com.winylka;

import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Queue;
import javax.jms.TextMessage;

@ApplicationScoped
public class JmsService {
	
	@Resource(mappedName="java:/jms/queue/winylkaQ")
	private Queue winylkaQ; 
	
	@Inject
	@JMSConnectionFactory("java:/ConnectionFactory")
	private JMSContext context;
	
	public void send(String message) {
		try {
			TextMessage msg = context.createTextMessage(message); 
			context.createProducer().send(winylkaQ, msg);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
