package com.green.jpaexam.product;

import com.green.jpaexam.product.model.ProductDto;
import com.green.jpaexam.product.model.ProductRes;
import com.green.jpaexam.product.model.ProductUpdDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prodcut")
@RequiredArgsConstructor
@Slf4j
public class ProductController {


    private final ProductService service;

    @PostMapping
    public ResponseEntity<ProductRes> postProduct(@RequestBody ProductDto dto){
       ProductRes res=service.saveProduct(dto);
       return ResponseEntity.ok(res);
    }
    @GetMapping
    public ResponseEntity<Page<ProductRes>>  getProductAll(@PageableDefault(sort = "number",direction = Sort.Direction.DESC,size = 20)Pageable page){
        return ResponseEntity.ok(service.getProductAll(page));
    }
    @GetMapping("/{number}")
    public ResponseEntity<ProductRes>getProdcut(@PathVariable Long number){
        return ResponseEntity.ok(service.getProduct(number));
    }




    @PutMapping
    public ResponseEntity<ProductRes> updProduct(@RequestBody ProductUpdDto dto){
        return ResponseEntity.ok(service.updProduct(dto));
    }

    @DeleteMapping
    public ResponseEntity<Integer> delProduct(@RequestParam Long number){
        service.delProduct(number);
        return ResponseEntity.ok(1);
    }



}
