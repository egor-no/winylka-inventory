package com.winylka.jsf;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative; 

@ApplicationScoped
@Alternative
public class LocalInventoryService implements InventoryService {
	
	private Map<Long, InventoryItem> items = new HashMap<>();

	@Override
	@Logging
	public void createItem(Long catalogItemId, String name) {
		long inventoryItemId = items.size() + 1;
		this.items.put(inventoryItemId, new InventoryItem(inventoryItemId, catalogItemId, name, 0L)); 
		this.printInventory();
	}

	private void printInventory() {
		System.out.println("Local inventory contains: "); 
		
		for(Entry<Long, InventoryItem> entry : this.items.entrySet() ) {
			System.out.println(entry.getValue().getName());
		}
		
	}

	@Override
	public Long getQuantity(Long catalogItemId) {
		return 0L;
	}

}
