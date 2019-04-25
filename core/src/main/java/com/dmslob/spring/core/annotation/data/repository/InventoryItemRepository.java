package com.dmslob.spring.core.annotation.data.repository;

import org.springframework.stereotype.Repository;

@Repository
public class InventoryItemRepository {
    public void find(long id) {
        System.out.println(id);
    }
}
