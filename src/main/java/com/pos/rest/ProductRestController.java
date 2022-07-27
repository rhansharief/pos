package com.pos.rest;

import com.pos.exception.NotFoundException;
import com.pos.model.Product;
import com.pos.service.ProductService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductRestController {

    @Autowired
    ProductService ProductService;

    @GetMapping
    public List<Product> list() {
        return ProductService.list();
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable("id") final long id) {
        Optional<Product> Product = ProductService.get(id);

        if (Product.isPresent()) {
            return ProductService.get(id).get();
        } else {
            throw new NotFoundException("Product with id " + id + " not found");
        }
    }

    @PostMapping
    public Product create(@RequestBody final Product Product) {
        return ProductService.create(Product);
    }

    @PutMapping
    public Product update(@RequestBody final Product Product) {
        return ProductService.update(Product);
    }
}
