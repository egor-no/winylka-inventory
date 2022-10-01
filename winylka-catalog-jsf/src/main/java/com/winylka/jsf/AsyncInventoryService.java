package com.winylka.jsf;

import java.util.concurrent.Future;

public interface AsyncInventoryService extends InventoryService {
	
	public Future<InventoryItem> asyncGetInventoryItem(Long catalogItemId);
	
}
