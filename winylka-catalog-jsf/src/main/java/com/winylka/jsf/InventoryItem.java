package com.winylka.jsf;

public class InventoryItem {
	
	private Long inventoryItemId;
	private Long catalogItemId; 
	private String name; 
	private Long quantity; 
	
	public InventoryItem() {
		
	}
	
	public InventoryItem(Long inventoryItemId, Long catalogItemId, String name, Long quantity) {
		super();
		this.inventoryItemId = inventoryItemId;
		this.catalogItemId = catalogItemId;
		this.name = name;
		this.quantity = quantity;
	}

	public Long getInventoryItemId() {
		return inventoryItemId;
	}

	public void setInventoryItemId(Long inventoryItemId) {
		this.inventoryItemId = inventoryItemId;
	}

	public Long getCatalogItemId() {
		return catalogItemId;
	}

	public void setCatalogItemId(Long catalogItemId) {
		this.catalogItemId = catalogItemId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	} 
	
	
	

}
