package com.pos.service;

import com.pos.model.Supplier;
import com.pos.repository.SupplierRepository;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SupplierService {

    @Autowired
    SupplierRepository repository;

    public Supplier create(final Supplier Supplier) {
        return repository.save(Supplier);
    }

    public Supplier update(final Supplier Supplier) {
        return  repository.save(Supplier);
    }

    public List<Supplier> list() {
        return repository.findAll();
    }

    public Optional<Supplier> get(final long id) {
        return repository.findById(id);
    }
}
