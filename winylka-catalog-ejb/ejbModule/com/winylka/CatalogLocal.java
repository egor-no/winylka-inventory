package com.winylka;

import java.util.List;

import javax.ejb.Local;

@Local
public interface CatalogLocal {
	
	public List<CatalogItem> getItems(); 
	
	public void addItem(CatalogItem item);
	
	public CatalogItem findItem(Long itemId);
	
	public void deleteItem(CatalogItem item); 
	
	public List<CatalogItem> searchByArtistName(String name); 
	
	public List<CatalogItem> searchByAlbumTitle(String title);
	
	

}
