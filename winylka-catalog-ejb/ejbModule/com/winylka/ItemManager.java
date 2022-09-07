package com.winylka;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ITEM_MANAGER")
public class ItemManager {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ITEM_MANAGER_ID")
	private Long itemManagerId;

	@ManyToMany(mappedBy = "itemManagers")
	private List<CatalogItem> catalogItems = new ArrayList<>();

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "LAST_NAME")
	private String lastName;

	public Long getItemManagerId() {
		return itemManagerId;
	}

	public void setItemManagerId(Long itemManagerId) {
		this.itemManagerId = itemManagerId;
	}

	public List<CatalogItem> getCatalogItems() {
		return catalogItems;
	}

	public void setCatalogItems(List<CatalogItem> catalogItems) {
		this.catalogItems = catalogItems;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}

