package com.backend.inventory_service.services;

import com.backend.inventory_service.model.dto.BaseResponse;
import com.backend.inventory_service.model.dto.InventoryResponse;
import com.backend.inventory_service.model.dto.OrderItemRequest;
import com.backend.inventory_service.model.entities.Inventory;
import com.backend.inventory_service.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    public boolean isInStock(String skuCode) {
        var inventory = inventoryRepository.findBySku(skuCode);
        return inventory.filter(value -> value.getQuantity() > 0).isPresent();
    }

    public BaseResponse areInStock(List<OrderItemRequest> orderItems) {

        var errorList = new ArrayList<String>();

        List<String> skus = orderItems.stream().map(OrderItemRequest::getSku).toList();

        List<Inventory> inventories = inventoryRepository.findBySkuIn(skus);

        orderItems.forEach(orderItem -> {
            var foundInInventory = inventories.stream().filter(value -> value.getSku().equals(orderItem.getSku())).findFirst();
            if (foundInInventory.isEmpty()) {
                errorList.add("Product with sku " + orderItem.getSku() + " not found");
            } else if (foundInInventory.get().getQuantity() < orderItem.getQuantity()) {
                errorList.add("Product with sku " + orderItem.getSku() + " has insufficient quantity");
            }
        });
        return errorList.isEmpty() ? new BaseResponse(errorList.toArray(new String[0])) : new BaseResponse(null);
    }

    public List<InventoryResponse> getInventories() {
        List<Inventory> inventories = this.inventoryRepository.findAll();
        return inventories.stream().map(this::mapInventoryToInventoryResponse).toList();
    }

    private InventoryResponse mapInventoryToInventoryResponse(Inventory inventory) {
        return new InventoryResponse(inventory.getId(), inventory.getSku(), inventory.getQuantity());
    }
}
