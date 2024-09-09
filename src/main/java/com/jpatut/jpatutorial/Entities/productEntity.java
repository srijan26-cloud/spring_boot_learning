package com.jpatut.jpatutorial.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(
        name = "product_table",
        uniqueConstraints = {
                @UniqueConstraint(name = "name_price_unique",
                        columnNames = {"productName", "productPrice"})
        },
        indexes = {
                @Index(name = "idx_sku", columnList = "sku" , unique = true)
        }
)
public class productEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @Column(nullable = false, length = 20)
    private String sku;

    private String productName;

    private BigDecimal productPrice;

    private Integer productQuantity;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
