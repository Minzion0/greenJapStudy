package com.green.jpaexam.product;

import com.green.jpaexam.product.model.ProductEntity;
import com.green.jpaexam.product.model.ProductRes;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ProductDaoImpl implements ProductDao {
//dao 쪽은 로직이 아니라 단순 변환이 필요하면 여기서 처리해준다
    private final ProductRepository rep;

    @Override
    public ProductRes saveProduct(ProductEntity p) {
        ProductEntity result = rep.save(p);
       return ProductRes.builder()
                .number(result.getNumber())
                .name(result.getName())
                .price(result.getPrice())
                .stock(result.getStock())
                .build();
    }

    @Override
    public Page<ProductRes> getProductAll(Pageable page) {

        Page<ProductEntity> totalList = rep.findAll(page);
        long totalElements = totalList.getTotalElements();

        List<ProductRes> list = totalList.getContent().stream().map(item ->
                                        ProductRes.builder()
                                        .number(item.getNumber())
                                        .name(item.getName())
                                        .price(item.getPrice())
                                        .stock(item.getStock())
                                        .build()).toList();

//        List<ProductRes> result = list.stream().map(itme -> ProductRes.builder()
//                .number(itme.getNumber())
//                .name(itme.getName())
//                .price(itme.getPrice())
//                .stock(itme.getStock())
//                .build()).toList();

        return new PageImpl<>(list,page,totalElements);

    }

    @Override
    public Optional<ProductEntity> getProduct(Long number) {

        return rep.findById(number);
    }

    @Override
    public ProductRes updProduct(ProductEntity p) {
        Optional<ProductEntity> opt = rep.findById(p.getNumber());
        if (!opt.isPresent()) {
        return null;
        }
        ProductEntity entity = opt.get();

        entity.setName(p.getName());
        entity.setPrice(p.getPrice());
        entity.setStock(p.getStock());

        ProductEntity result = rep.save(entity);
        return ProductRes.builder().number(result.getNumber())
                .name(result.getName())
                .price(result.getPrice())
                .stock(result.getStock())
                .build();
    }

    @Override
    public void delProduct(Long number) {
        rep.deleteById(number);

    }
}
