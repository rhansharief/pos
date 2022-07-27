package com.pos.service;

import com.pos.model.Product;
import com.pos.repository.ProductRepository;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ProductService {

    @Autowired
    ProductRepository repository;

    public Product create(final Product Product) {
        return repository.save(Product);
    }

    public Product update(final Product Product) {
        return  repository.save(Product);
    }

    public List<Product> list() {
        return repository.findAll();
    }

    public Optional<Product> get(final long id) {
        return repository.findById(id);
    }
}
