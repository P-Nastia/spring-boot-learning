package org.example.data;

import com.github.javafaker.Faker;
import com.github.slugify.Slugify;
import lombok.RequiredArgsConstructor;
import org.example.data.constants.RolesConstants;
import org.example.data.seed.CategorySeed;
import org.example.entities.CategoryEntity;
import org.example.entities.RoleEntity;
import org.example.mappers.CategoryMapper;
import org.example.repositories.ICategoryRepository;
import org.example.repositories.IRoleRepository;
import org.example.services.FileService;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import java.util.List;
import java.util.Locale;

@Component
@RequiredArgsConstructor
public class AppDbSeeder {

    private final IRoleRepository roleRepository;
    private final ICategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;
    private final Faker faker = new Faker(new Locale("uk"));
    private final Slugify slugify = Slugify.builder().build();
    private final FileService fileService;

    @PostConstruct
    public void seedData() {
        seedRoles();
        seedCategories();
    }
    private void seedRoles() {
        List<String> roles = RolesConstants.Roles;

        for (String roleName : roles) {
            boolean exists = roleRepository.findByName(roleName).isPresent();
            if (!exists) {
                RoleEntity role = new RoleEntity();
                role.setName(roleName);
                roleRepository.save(role);
                System.out.println("Додано роль: " + roleName);
            } else {
                System.out.println("Роль уже існує: " + roleName);
            }
        }
    }

    private void seedCategories(){
        if(categoryRepository.count() == 0){
            System.out.println("----------------Start category seeder ---------------");
            for(int i=0;i<5;i++){
                CategorySeed seed = new CategorySeed();
                seed.setName(faker.commerce().department());
                seed.setSlug(slugify.slugify(seed.getName()));
                seed.setImageUrl(null);

                CategoryEntity category = categoryMapper.toEntity(seed);
                categoryRepository.save(category);
            }
            System.out.println("--------- Finish category seeder -----------");
        }else
            System.out.println("------------ Categories already exist ------------");
    }
}
