package com.food_shop.repo_impl;

import com.food_shop.entities.product.Product;
import com.food_shop.entities.result_mappings.dto.ProductCategoryAccount;
import com.food_shop.entities.result_mappings.dto.ProductAccount;
import com.food_shop.repo.product.ProductRepoCustom;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.time.LocalDate;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class ProductRepoImpl implements ProductRepoCustom {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Product> findBestSellers() {
        String query =
                "SELECT * FROM Product  " +
                "WHERE id_prod IN ( " +
                        "SELECT TOP 8 p.id_prod  " +
                        "FROM Product p INNER JOIN Sales s ON p.id_prod = s.prod_id  " +
                        "WHERE p.deleted = 0 GROUP BY p.id_prod  " +
                        "ORDER BY sum(s.qty) DESC " +
                        ")";
        Query q = em.createNativeQuery(query, Product.class);
        return q.getResultList();
    }

    @Override
    public List<ProductCategoryAccount> findBestSellersByCategory() {
        String query =
                "WITH SPL AS ( " +
                "    SELECT  p.id_prod, p.category, p.prod_name, p.prod_image, c.cat_name, SUM(s.qty) as prod_qty " +
                "    FROM    Product as p " +
                "            INNER JOIN Category as c ON p.category = c.id_cat " +
                "            INNER JOIN Sales s on p.id_prod = s.prod_id " +
                "    GROUP BY p.id_prod, p.category, p.prod_name, p.prod_image, c.cat_name " +
                ") " +
                "SELECT  TMP2.id_prod, TMP2.prod_name, TMP2.prod_image, TMP1.*  " +
                "FROM    (SELECT SPL.category, SPL.cat_name, max(prod_qty) as max_prod_qty " +
                "            FROM SPL " +
                "            GROUP BY SPL.category, SPL.cat_name " +
                "        ) AS TMP1 " +
                "        INNER JOIN SPL as TMP2 ON TMP2.category = TMP1.category AND TMP2.prod_qty = TMP1.max_prod_qty;";

        Query q = em.createNativeQuery(query, "ProductCategoryAccountMapping");
        return q.getResultList();
    }

    @Override
    public List<ProductCategoryAccount> findBestSellersByCategoryByMonth(int month) {
        String query =
                "WITH SPL AS ( " +
                "    SELECT  p.id_prod, p.category, p.prod_name, p.prod_image, c.cat_name, SUM(s.qty) as prod_qty " +
                "    FROM    Product as p " +
                "                INNER JOIN Category as c ON p.category = c.id_cat " +
                "                INNER JOIN Sales s on p.id_prod = s.prod_id " +
                "                INNER JOIN Food_Order fo on s.order_id = fo.id_order " +
                "    WHERE MONTH(fo.date) = ?1 AND YEAR(fo.date) = YEAR(GETDATE()) " +
                "    GROUP BY p.id_prod, p.category, p.prod_name, p.prod_image, c.cat_name " +
                ") " +
                "SELECT  SPL2.id_prod, SPL2.prod_name, SPL2.prod_image, SPL1.* " +
                "FROM    (SELECT SPL.category, SPL.cat_name, MAX(prod_qty) as max_prod_qty " +
                "            FROM   SPL " +
                "            GROUP BY SPL.category, SPL.cat_name " +
                "        ) AS SPL1 " +
                "        INNER JOIN SPL AS SPL2 ON SPL1.category = SPL2.category AND SPL2.prod_qty = SPL1.max_prod_qty;";

        Query q = em.createNativeQuery(query, "ProductCategoryAccountMapping");
        q.setParameter(1, month);
        return q.getResultList();
    }

    @Override
    public List<ProductCategoryAccount> findSaleStatisticByDate(String beginDate, String endDate) {
        String query =
                "SELECT  p.id_prod, p.prod_name, p.prod_image, p.category, c.cat_name, SUM(s.qty) as max_prod_qty\n" +
                "FROM    Product as p\n" +
                "            INNER JOIN Category c on p.category = c.id_cat\n" +
                "            INNER JOIN Sales s on p.id_prod = s.prod_id\n" +
                "            INNER JOIN Food_Order fo on s.order_id = fo.id_order\n" +
                "WHERE fo.date BETWEEN ?1 AND ?2\n" +
                "GROUP BY p.id_prod, p.prod_name, p.prod_image, p.category, c.cat_name;";

        Query q = em.createNativeQuery(query, "ProductCategoryAccountMapping");
        q.setParameter(1, beginDate);
        q.setParameter(2, endDate);
        return q.getResultList();
    }

    @Override
    public List<ProductAccount> findProductInfoByUser(String username) {
        String query =
                "SELECT p.id_prod, p.prod_name, p.prod_image, p.price, SUM(s.qty) as consumption  " +
                "FROM  Food_Order as f, App_User as a, Sales as s  " +
                "INNER JOIN Product as p ON s.prod_id = p.id_prod  " +
                "WHERE s.order_id = f.id_order  " +
                "  AND f.user_id = a.id_user  " +
                "  AND a.user_name = ?1  " +
                "GROUP BY p.id_prod, p.prod_name, p.prod_image, price;";

        Query q = em.createNativeQuery(query, "ProductAccountMapping");
        q.setParameter(1, username);
        return q.getResultList();
    }
}
