package com.winylka;

import java.util.List;

import javax.ejb.Local;

@Local
public interface CatalogLocal {
	
	public List<CatalogItem> getItems(); 
	
	public void addItem(CatalogItem item);
	

}
