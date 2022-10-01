package com.winylka.jsf;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.winylka.CatalogItem;
import com.winylka.CatalogLocal;

@Named
@ConversationScoped
public class CatalogItemDeleteBean implements Serializable {
	
	private long itemId;

	private CatalogItem item;

	@Inject
	private CatalogItemFormBean catalogItemFormBean; 
	
	@Inject
	private InventoryService inventoryService; 
	
	@Inject
	private CatalogLocal catalogBean; 
	
	@Inject
	private Conversation conversation; 

	public void fetchItem() {
		conversation.begin();
		this.item = catalogBean.findItem(this.itemId);  
	}
	
	public String removeItem() {
		this.catalogBean.deleteItem(this.item);
		this.inventoryService.deleteItem(this.itemId);
		conversation.end(); 
		return "list?faces-redirect=true";
	}

	public long getItemId() {
		return itemId;
	}

	public void setItemId(long itemId) {
		this.itemId = itemId;
	}

	public CatalogItem getItem() {
		return item;
	}

	public void setItem(CatalogItem item) {
		this.item = item;
	}

	public CatalogItemFormBean getCatalogItemFormBean() {
		return catalogItemFormBean;
	}

	public void setCatalogItemFormBean(CatalogItemFormBean catalogItemFormBean) {
		this.catalogItemFormBean = catalogItemFormBean;
	}


}
