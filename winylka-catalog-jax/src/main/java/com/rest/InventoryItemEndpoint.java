package com.rest;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import javax.enterprise.context.RequestScoped;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.Response.Status;

import com.winylka.InventoryItem;

@RequestScoped
@Path("/inventoryitems")
@Produces("application/json")
@Consumes("application/json")
public class InventoryItemEndpoint {
	
	@PersistenceContext
	private EntityManager entityManager; 

	@POST
	public Response create(final InventoryItem inventoryitem) {
		this.entityManager.persist(inventoryitem);
		return Response.created(UriBuilder.fromResource(InventoryItemEndpoint.class)
				.path(String.valueOf(inventoryitem.getInventoryItemId())).build()).build();
	}

	@GET
	@Path("/{id:[0-9][0-9]*}")
	public Response findById(@PathParam("id") final Long id) {

		InventoryItem inventoryitem = this.entityManager.find(InventoryItem.class, id);

		if (inventoryitem == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		
		inventoryitem.setQuantity(ThreadLocalRandom.current().nextLong(1,100));
		return Response.ok(inventoryitem).build();
	}
	
	@GET
	@Path("/catalog")
	public InventoryItem findByCatalogId(@NotNull @QueryParam("catalogItemId") Long catalogItemId) {
		
		TypedQuery<InventoryItem> query = this.entityManager
				.createQuery("select i from InventoryItem i where i.catalogItemId = :catalogItemId", InventoryItem.class)
				.setParameter("catalogItemId", catalogItemId);
		
		InventoryItem item = query.getSingleResult();
		item.setQuantity(ThreadLocalRandom.current().nextLong(1,100));
	
		return item; 
	}

	@GET
	public List<InventoryItem> listAll(@QueryParam("start") final Integer startPosition,
			@QueryParam("max") final Integer maxResult) {
		TypedQuery<InventoryItem> query = this.entityManager.createQuery("select i from InventoryItem i", InventoryItem.class);
		final List<InventoryItem> inventoryitems = query.getResultList(); 
		return inventoryitems;
	}

	@PUT
	@Path("/{id:[0-9][0-9]*}")
	public Response update(@PathParam("id") Long id, final InventoryItem inventoryitem) {
		this.entityManager.merge(inventoryitem);
		return Response.noContent().build();
	}

	@DELETE
	@Path("/{id:[0-9][0-9]*}")
	public Response deleteById(@PathParam("id") final Long id) {
		this.entityManager.remove(this.entityManager.find(InventoryItem.class,id));
		return Response.noContent().build(); 
	}

}
