package com.pos.model;

import java.util.Collection;
import javax.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode
public class Supplier {
    @Id
    @GeneratedValue
    private Long id;

    @Column //TODO: Index?
    private String name;

    @OneToMany(mappedBy="supplier", fetch = FetchType.LAZY)
    Collection<Product> products;
}
