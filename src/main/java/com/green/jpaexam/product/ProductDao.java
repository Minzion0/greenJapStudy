package com.green.jpaexam.product;

import com.green.jpaexam.product.model.ProductEntity;
import com.green.jpaexam.product.model.ProductRes;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ProductDao {
    ProductRes saveProduct(ProductEntity p);
    Page<ProductRes> getProductAll(Pageable page);
    Optional<ProductEntity> getProduct(Long nmber);
    ProductRes updProduct(ProductEntity p);
    void delProduct(Long number);
}
