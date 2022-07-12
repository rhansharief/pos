package com.pos.service;

import com.pos.model.Category;
import com.pos.repository.CategoryRepository;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CategoryService {

    @Autowired
    CategoryRepository repository;

    public Category create(final Category category) {
        return repository.save(category);
    }

    public Category update(final Category category) {
        return  repository.save(category);
    }

    public List<Category> list() {
        return repository.findAll();
    }

    public Optional<Category> get(final long id) {
        return repository.findById(id);
    }
}
