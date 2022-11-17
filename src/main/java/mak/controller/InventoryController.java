package mak.controller;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import mak.pojo.Order;
import mak.pojo.Product;
import mak.service.nonreactive.InventoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("inventory")
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class InventoryController {

    InventoryService inventoryService;

    @GetMapping
    public List<Product> getAllProducts() {
        return inventoryService.getProducts();
    }

    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        return inventoryService.createOrder(order);
    }

    @DeleteMapping
    public Order revertOrder(@RequestBody Order order) {
        return inventoryService.revertOrder(order);
    }
}
