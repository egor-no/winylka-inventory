package com.winylka.jsf;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

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
public class RemoteInventoryService implements InventoryService  {

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
	public Long getQuantity(Long catalogItemId) {
		Client client = ClientBuilder.newClient();
		InventoryItem inventoryItem = client.target(apiURL).path("inventoryitems").path("catalog")
			.queryParam("catalogItemId", catalogItemId.toString())
			.request().get(InventoryItem.class); 
		return inventoryItem.getQuantity();
	}
}
