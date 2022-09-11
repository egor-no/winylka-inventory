package com.winylka.jsf;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.winylka.CatalogItem;
import com.winylka.CatalogLocal;

@RequestScoped
@Named
public class CatalogItemFormBean implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Inject
	private CatalogLocal catalogBean; 
	
	@Inject
	private InventoryService inventoryService; 
	
	private CatalogItem item = new CatalogItem();
	
	private List<CatalogItem> items = new ArrayList<>();
	
	private String searchText;
	
	public void searchBySearchPhrase() {
		this.items = this.catalogBean.searchByArtistName(this.searchText);
		List<CatalogItem> moreItems= this.catalogBean.searchByAlbumTitle(this.searchText);

		for(CatalogItem item : moreItems) {
			if (!items.contains(item))
				items.add(item); 
		}
	}
	
	public String addItem() {
		/*CatalogItem newItem = new CatalogItem(); 
		newItem.setAlbumTitle(this.item.getAlbumTitle());
		newItem.setAlbumInfo(this.item.getAlbumInfo());
		newItem.setArtistName(this.item.getArtistName());
		newItem.setAlbumYear(this.item.getAlbumYear());
		newItem.setFormat(this.item.getFormat());
		newItem.setLabel(this.item.getLabel());
		newItem.setNotes(this.item.getNotes());
		newItem.setReleaseDate(this.item.getReleaseDate());*/
		this.catalogBean.addItem(this.item); 
		
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
	
	public String getSearchText() {
		return searchText; 
	}
	
	public void setSearchText(String searchText) {
		this.searchText = searchText; 
	}
	
	
}
