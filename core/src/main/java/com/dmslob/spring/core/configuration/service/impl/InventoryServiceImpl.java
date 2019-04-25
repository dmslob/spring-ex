package com.dmslob.spring.core.configuration.service.impl;

import com.dmslob.spring.core.configuration.data.repository.InventoryItemRepository;
import com.dmslob.spring.core.configuration.domain.Product;
import com.dmslob.spring.core.configuration.service.InventoryService;

import java.util.Map;

public class InventoryServiceImpl implements InventoryService {

    private final InventoryItemRepository inventoryItemRepository;

    public InventoryServiceImpl(InventoryItemRepository inventoryItemRepository) {
        this.inventoryItemRepository = inventoryItemRepository;
    }

    public Map<Product, Long> getTotalInventoryOnHand() {
        return null;
    }

    public long getQuantityOnHand(String itemId) {
        return 0;
    }

    public void adjustInventory(String itemId, long quantity) {

    }
}
