package org.example.data.seed;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Setter
@Getter
public class CategorySeed {
    private String name;
    private String slug;
    private String imageUrl;
}
