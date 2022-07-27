package com.winylka.jsf;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@SessionScoped
@Named
public class CatalogItemFormBean implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private CatalogItem item = new CatalogItem();
	
	private List<CatalogItem> items = new ArrayList<>();
	
	public String addItem() {
		Long itemId = this.items.size() + 1L;
		
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
		
		items.add(newItem); 
		
		this.items.stream().forEach(item -> {
			System.out.println(item.toString()); 
		});
		
		return "list?faces-redirect=true"; 
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
