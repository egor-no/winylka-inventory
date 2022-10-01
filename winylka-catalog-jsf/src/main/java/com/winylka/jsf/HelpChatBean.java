package com.winylka.jsf;

import java.io.Serializable;

import javax.faces.push.Push;
import javax.faces.push.PushContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@ViewScoped
@Named
public class HelpChatBean implements Serializable {
	
	@Inject
	@Push(channel="help")
	private PushContext helpChannel; 

	private String messageText;
	
	private String name;
	
	public void sendMessage() {
		this.helpChannel.send(String.format("%s: %s", name, messageText));
	}

	public String getMessageText() {
		return messageText;
	}

	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
