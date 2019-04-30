package com.dmslob.spring.core.annotation.service;

import com.dmslob.spring.core.annotation.domain.Product;

import java.util.Map;

public interface InventoryService {

    Map<Product, Long> getTotalInventoryOnHand();

    long getQuantityOnHand(String itemId);

    void adjustInventory(String itemId, long quantity);
}