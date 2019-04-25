package com.dmslob.spring.core.annotation.service.impl;

import com.dmslob.spring.core.annotation.data.repository.InventoryItemRepository;
import com.dmslob.spring.core.annotation.domain.Product;
import com.dmslob.spring.core.annotation.service.InventoryService;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

import java.util.Map;

@Service
public class InventoryServiceImpl implements InventoryService, BeanNameAware {

    private InventoryItemRepository inventoryItemRepository;
    private String beanName;

    //@Autowired
    @Inject
    public InventoryServiceImpl(InventoryItemRepository inventoryItemRepository) {
        this.inventoryItemRepository = inventoryItemRepository;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    public void find(long id) {
        System.out.println(beanName);
        this.inventoryItemRepository.find(id);
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
