package com.sopt.carrot_server.app.domain;

import com.sopt.carrot_server.app.domain.common.BaseTimeEntity;

import com.sopt.carrot_server.app.domain.enums.ProductSatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;

import static jakarta.persistence.FetchType.LAZY;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
@Table(
        name = "product", indexes = {
        @Index(name = "idx_product_title", columnList = "title")
})
public class Product extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(columnDefinition = "TEXT")
    private String productImage;

    @NotNull
    private String title;

    private String category;

    private String price;

    private String content;

    private int view;

    @NotNull
    @Enumerated(EnumType.STRING)
    private ProductSatus status;

}