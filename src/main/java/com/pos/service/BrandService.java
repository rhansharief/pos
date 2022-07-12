package com.pos.service;

import com.pos.model.Brand;
import com.pos.repository.BrandRepository;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BrandService {

    @Autowired
    BrandRepository repository;

    public Brand create(final Brand Brand) {
        return repository.save(Brand);
    }

    public Brand update(final Brand Brand) {
        return  repository.save(Brand);
    }

    public List<Brand> list() {
        return repository.findAll();
    }

    public Optional<Brand> get(final long id) {
        return repository.findById(id);
    }
}
