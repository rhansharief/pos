package com.pos.rest;

import com.pos.exception.NotFoundException;
import com.pos.model.Category;
import com.pos.service.CategoryService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categories")
public class CategoryRestController {

    @Autowired
    CategoryService categoryService;

    @GetMapping
    public List<Category> list() {
        return categoryService.list();
    }

    @GetMapping("/{id}")
    public Category getById(@PathVariable("id") final long id) {
        Optional<Category> category = categoryService.get(id);

        if (category.isPresent()) {
            return categoryService.get(id).get();
        } else {
            throw new NotFoundException("Category with id " + id + " not found");
        }
    }

    @PostMapping
    public Category create(@RequestBody final Category category) {
        return categoryService.create(category);
    }

    @PutMapping
    public Category update(@RequestBody final Category category) {
        return categoryService.update(category);
    }
}
