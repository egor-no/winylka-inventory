package com.winylka.jsf;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.concurrent.Future;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Default;
import javax.inject.Named;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;


@ApplicationScoped
@RemoteService
@Default
public class RemoteInventoryService implements AsyncInventoryService  {

	private String apiURL = "http://localhost:8080/winylka-catalog-jax/winylka/api/";

	@Override
	public void createItem(Long catalogItemId, String name) {
		
		int randomQuantity =  new Random().nextInt(10); 
		
		Client client = ClientBuilder.newClient();
		Response response = client.target(apiURL)
			.path("inventoryitems")
			.request()
			.post(Entity.json(new InventoryItem(null, catalogItemId, name, (long) randomQuantity)));
			
		System.out.println(response.getStatus());
		System.out.println(response.getLocation().getPath());
	}
	
	@Override
	public void deleteItem(Long catalogItemId) {

		Client client = ClientBuilder.newClient();
		
		InventoryItem inventoryItem = client.target(apiURL).path("inventoryitems").path("catalog")
				.path("{catalogItemId}") 
				.resolveTemplate("catalogItemId", catalogItemId.toString())
				.request().get(InventoryItem.class); 
		
		String inventoryItemPath = "inventoryitems/" + inventoryItem.getInventoryItemId(); 

		Response response = client.target(apiURL)
			.path(inventoryItemPath)
			.request()
			.delete(); 
		
		System.out.println(response.getStatus());
	}

	@Override
	public Long getQuantity(Long catalogItemId) {
		Client client = ClientBuilder.newClient();
		InventoryItem inventoryItem = client.target(apiURL).path("inventoryitems").path("catalog")
			.path("{catalogItemId}") 
			.resolveTemplate("catalogItemId", catalogItemId.toString())
			.request().get(InventoryItem.class); 
		return inventoryItem.getQuantity();
	}
	
	@Override
	public Future<InventoryItem> asyncGetInventoryItem(Long catalogItemId) {
		Client client = ClientBuilder.newClient();
		return client.target(apiURL).path("inventoryitems").path("catalog")
			.path("{catalogItemId}") 
			.resolveTemplate("catalogItemId", catalogItemId.toString())
			.request().async().get(InventoryItem.class); 
	}
}
