package com.winylka.jsf;

import java.time.LocalDateTime;

import javax.enterprise.inject.Produces;

public class InventoryServiceFactory {

	//@Produces
	public InventoryService createInstance() {
		
		InventoryService inventoryService = null; 
		
		if (LocalDateTime.now().getHour() > 12) {
			inventoryService = new LocalInventoryService(); 
		} else {
			inventoryService = new RemoteInventoryService(); 
		}
		return inventoryService; 
	}
	
}
