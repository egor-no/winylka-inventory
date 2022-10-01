package com.winylka.jsf;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.websocket.*;
import javax.websocket.server.*;

@ServerEndpoint("/socket/help")
public class HelpServerSocketEndpoint {
	
	private static List<Session> sessions = new ArrayList<>(); 

	@OnOpen
	public void onOpen(Session session) {
		System.out.println("New connection opened"); 
		sessions.add(session); 
	}
	
	@OnMessage
	public void onMessage(String message, Session session) {
		sessions.stream().forEach(s -> {
			try {
				s.getBasicRemote().sendText(message);
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
	}
	
	@OnClose
	public void onClose() {
		System.out.println("Connection is closed"); 
	}
}
