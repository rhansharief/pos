package com.pos.rest;

import com.pos.exception.NotFoundException;
import com.pos.model.Supplier;
import com.pos.service.SupplierService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/suppliers")
public class SupplierRestController {

    @Autowired
    SupplierService SupplierService;

    @GetMapping
    public List<Supplier> list() {
        return SupplierService.list();
    }

    @GetMapping("/{id}")
    public Supplier getById(@PathVariable("id") final long id) {
        Optional<Supplier> Supplier = SupplierService.get(id);

        if (Supplier.isPresent()) {
            return SupplierService.get(id).get();
        } else {
            throw new NotFoundException("Supplier with id " + id + " not found");
        }
    }

    @PostMapping
    public Supplier create(@RequestBody final Supplier Supplier) {
        return SupplierService.create(Supplier);
    }

    @PutMapping
    public Supplier update(@RequestBody final Supplier Supplier) {
        return SupplierService.update(Supplier);
    }
}
