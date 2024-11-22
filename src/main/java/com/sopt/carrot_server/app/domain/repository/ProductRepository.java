package com.sopt.carrot_server.app.domain.repository;

import com.sopt.carrot_server.app.domain.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ProductRepository extends Repository<Product, Long> {

    @Query("SELECT p FROM Product p WHERE p.id = :productId")
    Optional <Product> findDetailInfoByProductId(@Param("productId") Long productId);

}