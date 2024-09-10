package com.jpatut.jpatutorial.Repositories;

import com.jpatut.jpatutorial.Entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<ProductEntity,Long> {

    ProductEntity findByProductName(String name);

    List<ProductEntity> findByProductNameStartingWith(String prefix);

    ProductEntity findFirstByProductNameStartingWith(String prefix);

    ProductEntity findDistinctByProductNameAndSku(String pepsi, String pepsiCo);

    List<ProductEntity> findByCreatedAtAfter(LocalDateTime after);

    List<ProductEntity> findByProductQuantityLessThanOrProductPriceGreaterThan(int i, BigDecimal bigDecimal);

    List<ProductEntity> findByProductNameLike(String s);

    List<ProductEntity> findByProductNameContaining(String pepsi);

    List<ProductEntity> findByProductNameContainingIgnoreCase(String pepsi);

    Optional<ProductEntity> findByProductNameAndProductPrice(String pepsiCoke, BigDecimal bigDecimal);

    //@Query("select e from ProductEntity e where e.productName=?1 and e.productQuantity=?2")  also fine
    @Query("select e from ProductEntity e where e.productName=:name and e.productQuantity=:quantity")
    Optional<ProductEntity> findByProductNameAndProductQuantity(String name, Integer quantity);
}
