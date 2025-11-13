package org.example.data.dtos.product;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryCreateDTO {
    @NotBlank(message = "Ім'я обов'язкове")
    private String name;

    @NotBlank(message = "Слаг обов'язковий")
    private String slug;
}
