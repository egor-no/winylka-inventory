package com.winylka.jsf;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.winylka.CatalogItem;
import com.winylka.CatalogLocal;

@SessionScoped
@Named
public class CatalogItemFormBean implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Inject
	private CatalogLocal catalogBean; 
	
	@Inject
	private InventoryService inventoryService; 
	
	private CatalogItem item = new CatalogItem();
	
	private List<CatalogItem> items = new ArrayList<>();
	
	public String addItem() {
		Long itemId = this.catalogBean.getItems().size() + 1L;
		
		CatalogItem newItem = new CatalogItem(); 
		newItem.setItemId(itemId);
		newItem.setAlbumTitle(this.item.getAlbumTitle());
		newItem.setAlbumInfo(this.item.getAlbumInfo());
		newItem.setArtistName(this.item.getArtistName());
		newItem.setAlbumYear(this.item.getAlbumYear());
		newItem.setFormat(this.item.getFormat());
		newItem.setLabel(this.item.getLabel());
		newItem.setNotes(this.item.getNotes());
		newItem.setReleaseDate(this.item.getReleaseDate());
		this.catalogBean.addItem(newItem); 
		
		String name = this.item.getArtistName() + " - " + this.item.getAlbumTitle();
		this.inventoryService.createItem(this.item.getItemId(), name);
		
		return "list?faces-redirect=true"; 
	}
	
	public void init() {
		this.items = this.catalogBean.getItems();
	}

	public CatalogItem getItem() {
		return item;
	}

	public void setItem(CatalogItem item) {
		this.item = item;
	}

	public List<CatalogItem> getItems() {
		return items;
	}

	public void setItems(List<CatalogItem> items) {
		this.items = items;
	} 
	
}
