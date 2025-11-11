package org.example.data.dtos;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class CategoryCreateDTO {
    public String name;
    public String slug;
    public MultipartFile image;
}
