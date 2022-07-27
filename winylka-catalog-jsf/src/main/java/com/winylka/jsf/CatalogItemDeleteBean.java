package com.winylka.jsf;

import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class CatalogItemDeleteBean {
	
	private long itemId;

	private CatalogItem item;

	@Inject
	private CatalogItemFormBean catalogItemFormBean; 

	public void fetchItem() {
		List<CatalogItem> items = this.catalogItemFormBean.getItems().stream().filter(i -> {
			return i.getItemId() == itemId;
		}).collect(Collectors.toList());

		if (items.isEmpty()) {
			this.item = null;
		} else {
			this.item = items.get(0);
		}

	}
	
	public String removeItem() {
		this.catalogItemFormBean.getItems().removeIf(item ->{
			return item.getItemId().equals(this.itemId);
		});
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
