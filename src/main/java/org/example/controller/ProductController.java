package org.example.controller;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.pojo.Order;
import org.example.pojo.Product;
import org.example.service.nonreactive.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductController {

    ProductService productService;

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getProducts();
    }

    @PostMapping
    public Order processOrder(@RequestBody Order order) {
        return productService.handleOrder(order);
    }

    @DeleteMapping
    public Order revertOrder(@RequestBody Order order) {
        return productService.revertOrder(order);
    }
}
