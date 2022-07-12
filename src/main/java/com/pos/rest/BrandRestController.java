package com.pos.rest;

import com.pos.exception.NotFoundException;
import com.pos.model.Brand;
import com.pos.service.BrandService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/brands")
public class BrandRestController {

    @Autowired
    BrandService BrandService;

    @GetMapping
    public List<Brand> list() {
        return BrandService.list();
    }

    @GetMapping("/{id}")
    public Brand getById(@PathVariable("id") final long id) {
        Optional<Brand> Brand = BrandService.get(id);

        if (Brand.isPresent()) {
            return BrandService.get(id).get();
        } else {
            throw new NotFoundException("Brand with id " + id + " not found");
        }
    }

    @PostMapping
    public Brand create(@RequestBody final Brand Brand) {
        return BrandService.create(Brand);
    }

    @PutMapping
    public Brand update(@RequestBody final Brand Brand) {
        return BrandService.update(Brand);
    }
}
