package org.example.data.seed;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductSeed {
    private String name;
    private String slug;
    private long categoryId;
    private String description;
    private double price;
}
