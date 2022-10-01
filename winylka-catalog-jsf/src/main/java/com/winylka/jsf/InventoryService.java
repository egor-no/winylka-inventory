package com.winylka.jsf;

import java.io.Serializable;

public interface InventoryService extends Serializable {
	
	public void createItem(Long catalogItemId, String name); 
	
	public void deleteItem(Long catalogItemId); 
	
	public Long getQuantity(Long catalogItemId); 

}
