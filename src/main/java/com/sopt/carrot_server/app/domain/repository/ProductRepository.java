package com.sopt.carrot_server.app.domain.repository;

import com.sopt.carrot_server.app.domain.Product;
import com.sopt.carrot_server.app.domain.User;
import com.sopt.carrot_server.app.domain.enums.ProductSatus;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends Repository<Product, Long> {

    @Query("SELECT p " +
            "FROM Product p " +
            "JOIN FETCH p.user u " +
            "JOIN FETCH u.address a " +
            "WHERE p.title not LIKE %:keyword%")
    List<Product> findSimilarProducts(@Param("keyword") String keyword);

    @Query("SELECT p " +
            "FROM Product p " +
            "JOIN FETCH p.user u " +
            "JOIN FETCH u.address a " +
            "WHERE p.title LIKE %:keyword%")
    List<Product> findProductsByKeyword(@Param("keyword") String keyword);

    @Query("SELECT p " +
            "FROM Product p " +
            "JOIN FETCH p.user u " +
            "WHERE u = :user AND p.status = :status")
    List<Product> findProductsByUser(@Param("user") User user, @Param("status") ProductSatus status);

}
