package com.winylka.jsf;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import javax.inject.Named;

@ApplicationScoped
@RemoteService
@Alternative
public class RemoteInventoryService implements InventoryService  {

	private Map<Long, InventoryItem> items = new HashMap<Long, InventoryItem>();

	@Override
	public void createItem(Long catalogItemId, String name) {
		long inventoryItemId = items.size() + 1;
		this.items.put(inventoryItemId, new InventoryItem(inventoryItemId, catalogItemId, name, 0L));
		this.printInventory();
	}

	public void printInventory() {
		System.out.println("Remote inventory contains:");
		for (Entry<Long, InventoryItem> entry : this.items.entrySet()) {
			System.out.println(entry.getValue().getName());
		}
	}

	@Override
	public Long getQuantity(Long catalogItemId) {
		// TODO Auto-generated method stub
		return null;
	}
}
