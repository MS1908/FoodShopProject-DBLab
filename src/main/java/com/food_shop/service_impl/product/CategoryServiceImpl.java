package com.food_shop.service_impl.product;

import com.food_shop.entities.product.Category;
import com.food_shop.repo.product.CategoryRepo;
import com.food_shop.service.product.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CategoryServiceImpl.class);

    @Autowired
    private CategoryRepo categoryRepo;

    @Override
    public Optional<Category> findById(Integer idCat) {
        try {
            return categoryRepo.findById(idCat);
        } catch (Exception ex) {
            LOGGER.error("findById error", ex);
            ex.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public List<Category> findAll() {
        try {
            return categoryRepo.findAll();
        } catch (Exception ex) {
            LOGGER.error("findAll error", ex);
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Integer> findAllPriorities() {
        try {
            return categoryRepo.findAllPriorities();
        } catch (Exception ex) {
            LOGGER.error("findAllPriorities error", ex);
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public Optional<Category> upload(Category category) {
        try {
            return Optional.ofNullable(categoryRepo.save(category));
        } catch (Exception ex) {
            LOGGER.error("upload error", ex);
            ex.printStackTrace();
            return Optional.empty();
        }
    }
}
