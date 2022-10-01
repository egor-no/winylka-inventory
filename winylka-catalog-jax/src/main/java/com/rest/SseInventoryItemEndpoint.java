package com.rest;

import java.util.Random;

import javax.enterprise.context.RequestScoped;
import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.sse.OutboundSseEvent;
import javax.ws.rs.sse.Sse;
import javax.ws.rs.sse.SseEventSink;

/* 
 * 
 * This class isn't important for the project,
 * I was just playing with SSE - 
 *  - learning what it's doing and how it's done
 */


@Singleton
@Path("/sse/inventoryitems")
@Produces("application/json")
@Consumes("application/json")
public class SseInventoryItemEndpoint {
	
	@GET
	@Path("/{inventoryItemId}")
	@Produces(MediaType.SERVER_SENT_EVENTS)
	public void sseItemQuantity(@PathParam("inventoryItemId") Long inventoryItemId, 
			@Context SseEventSink sseEventSink, @Context Sse sse) {
		try(SseEventSink sink = sseEventSink) {
			for (int i = 0; i<30; i++) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				OutboundSseEvent event = sse.newEvent(Integer.toString(new Random().nextInt(50)));
				sseEventSink.send(event);
			}
		}
	}

}
