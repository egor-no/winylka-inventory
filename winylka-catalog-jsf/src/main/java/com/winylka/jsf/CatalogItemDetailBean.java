package com.winylka.jsf;

import java.io.Serializable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.winylka.CatalogItem;
import com.winylka.CatalogLocal;
import com.winylka.ItemManager;

@Named
@ConversationScoped
public class CatalogItemDetailBean implements Serializable {
	
	private long itemId;

	private CatalogItem item;
	
	private Long quantity;
	
	@Inject
	@RemoteService
	private AsyncInventoryService inventoryService;

	@Inject
	private Conversation conversation;
	
	@Inject
	private CatalogLocal catalogBean;
	
	private ItemManager manager = new ItemManager();

	public void fetchItem() throws InterruptedException, ExecutionException {
		this.item = this.catalogBean.findItem(this.itemId);
		
		Future<InventoryItem> futureItem =  this.inventoryService.asyncGetInventoryItem(this.itemId);
		this.quantity = futureItem.get().getQuantity();
	}
	
	public void addManager() {
		this.manager.getCatalogItems().add(this.item); 
		this.item.getItemManagers().add(this.manager); 
		
		this.catalogBean.saveItem(item); 
		this.item = this.catalogBean.findItem(itemId); 
	}
	
	@PostConstruct
	public void init() {
		this.conversation.begin();
	}
	
	@PreDestroy
	public void destroy() {
		conversation.end();
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

	public ItemManager getManager() {
		return manager;
	}

	public void setManager(ItemManager manager) {
		this.manager = manager;
	}

	public InventoryService getInventoryService() {
		return inventoryService;
	}

	public void setInventoryService(AsyncInventoryService inventoryService) {
		this.inventoryService = inventoryService;
	}

	public Conversation getConversation() {
		return conversation;
	}

	public void setConversation(Conversation conversation) {
		this.conversation = conversation;
	}

	public CatalogLocal getCatalogBean() {
		return catalogBean;
	}

	public void setCatalogBean(CatalogLocal catalogBean) {
		this.catalogBean = catalogBean;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	

}

