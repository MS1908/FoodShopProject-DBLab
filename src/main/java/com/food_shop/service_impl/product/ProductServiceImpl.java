package com.food_shop.service_impl.product;

import com.food_shop.entities.product.Category;
import com.food_shop.entities.product.Product;
import com.food_shop.entities.result_mappings.dto.ProductAccount;
import com.food_shop.entities.result_mappings.dto.ProductCategoryAccount;
import com.food_shop.payload.product.ProductForm;
import com.food_shop.repo.product.CategoryRepo;
import com.food_shop.repo.product.ProductRepo;
import com.food_shop.service.product.CategoryService;
import com.food_shop.service.product.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Tuple;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private CategoryRepo categoryRepo;

    @Override
    public Optional<Product> findById(Integer idProd) {
        try {
            return productRepo.findById(idProd);
        } catch (Exception ex) {
            LOGGER.error("findById error", ex);
            ex.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public List<Product> findAll() {
        try {
            return productRepo.findAll();
        } catch (Exception ex) {
            LOGGER.error("findAll error", ex);
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Product> findByCategory(Integer idCat) {
        try {
            return productRepo.findByCategory(idCat);
        } catch (Exception ex) {
            LOGGER.error("findByCategory error", ex);
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Product> findBestSellers() {
        try {
            return productRepo.findBestSellers();
        } catch (Exception ex) {
            LOGGER.error("findBestSellers error", ex);
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Product> findRelated(Integer idProd) {
        try {
            return productRepo.findRelated(idProd);
        } catch (Exception ex) {
            LOGGER.error("findRelated error", ex);
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public Map<String, List<ProductCategoryAccount>> findBestSellersByCategory() {
        try {
            return productRepo.findBestSellersByCategory().stream().collect(Collectors.groupingBy(pca -> pca.getIdCat()+"-"+pca.getCatName()));
        } catch (Exception ex) {
            LOGGER.error("findBestSellersByCategory error", ex);
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public Map<String, List<ProductCategoryAccount>> findBestSellersByCategoryByMonth(int month) {
        try {
            return productRepo.findBestSellersByCategoryByMonth(month).stream().collect(Collectors.groupingBy(pca -> pca.getIdCat()+"-"+pca.getCatName()));
        } catch (Exception ex) {
            LOGGER.error("findBestSellersByCategoryByMonth error", ex);
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public List<ProductCategoryAccount> findSaleStatisticByDate(String beginDate, String endDate) {
        try {
            return productRepo.findSaleStatisticByDate(beginDate, endDate);
        } catch (Exception ex) {
            LOGGER.error("findSaleStatisticByDate error", ex);
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public List<ProductAccount> findProductInfoByUser(String username) {
        try {
            return productRepo.findProductInfoByUser(username);
        } catch (Exception ex) {
            LOGGER.error("findProductInfoByUser error", ex);
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public Optional<Product> update(ProductForm pf) {
        try {
            return categoryRepo.findById(pf.getIdCat())
                    .map(cat -> {
                        return productRepo.findById(pf.getIdProd())
                                .map(product -> {
                                    product.setProdName(pf.getProdName());
                                    product.setPrice(pf.getPrice());
                                    product.setImage(pf.getImage());
                                    product.setDeleted(pf.getDeleted());
                                    product.setCategory(cat);
                                    return Optional.ofNullable(productRepo.save(product));
                                })
                                .orElse(Optional.empty());
                    })
                    .orElse(Optional.empty());
        } catch (Exception ex) {
            LOGGER.error("update error", ex);
            ex.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public Optional<Product> upload(ProductForm pf) {
        try {
            Category cat = categoryRepo.findById(pf.getIdCat()).orElse(null);
            Product product = Product.builder()
                    .prodName(pf.getProdName())
                    .price(pf.getPrice())
                    .image(pf.getImage())
                    .deleted(pf.getDeleted())
                    .category(cat)
                    .build();
            return Optional.ofNullable(productRepo.save(product));
        } catch (Exception ex) {
            LOGGER.error("upload error", ex);
            ex.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public boolean deleteById(Integer idProd) {
        try {
            return productRepo.deleteByIdProd(idProd) > 0;
        } catch (Exception ex) {
            LOGGER.error("deleteById error", ex);
            ex.printStackTrace();
            return false;
        }
    }


}
