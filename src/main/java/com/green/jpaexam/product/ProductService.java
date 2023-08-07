package com.green.jpaexam.product;

import com.green.jpaexam.product.model.ProductDto;
import com.green.jpaexam.product.model.ProductEntity;
import com.green.jpaexam.product.model.ProductRes;
import com.green.jpaexam.product.model.ProductUpdDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    //service 는 로직적인 처리 담당
    private final ProductDao dao;

    public ProductRes saveProduct(ProductDto dto){
        ProductEntity entity = ProductEntity.builder()
                .name(dto.getName())
                .price(dto.getPrice())
                .stock(dto.getStock())
                .build();
        return dao.saveProduct(entity);

    }
    public List<ProductRes>getProductAll(){
        return  dao.getProductAll();
    }

    public ProductRes getProduct(Long number){
        Optional<ProductEntity> otp = dao.getProduct(number);
        if (!otp.isPresent()){
            return null;
        }
        ProductEntity result = otp.get();

        ProductRes res = ProductRes.builder().number(result.getNumber())
                .name(result.getName())
                .price(result.getPrice())
                .stock(result.getStock())
                .build();
        return res;
    }

    public ProductRes updProduct(ProductUpdDto dto){
        ProductEntity entity = ProductEntity.builder().number(dto.getNumber()).name(dto.getName()).price(dto.getPrice()).stock(dto.getStock()).build();

       return dao.updProduct(entity);
    }

    public void delProduct(Long number){
        dao.delProduct(number);
    }
}
