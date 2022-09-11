package com.winylka;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "INVENTORY_ITEM")
public class InventoryItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "INVENTORY_ITEM_ID")
	private Long inventoryItemId;

	@Column(name = "CATALOG_ITEM_ID")
	private Long catalogItemId;

	@Column(name = "NAME")
	private String name;

	@Column(name = "QUANTITY")
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
