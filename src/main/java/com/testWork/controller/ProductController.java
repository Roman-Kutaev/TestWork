package com.testWork.controller;


import static org.springframework.data.jpa.domain.Specification.*;

import com.testWork.dto.ProductDTO;
import com.testWork.services.ProductService;
import com.testWork.services.mapper.ProductMapper;

import com.testWork.specifications.ProductSpecification;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/shop/product")
public class ProductController {
    private final ProductService productService;
    private final ProductMapper productMapper;

    public ProductController(ProductService productService, ProductMapper productMapper) {
        this.productService = productService;
        this.productMapper = productMapper;
    }

    @GetMapping()
    public ResponseEntity<List<ProductDTO>> getProductsByName(@RequestParam("nameFilter") String nameFilter) {
        return ResponseEntity.ok(productMapper.toDto(productService.getProductsByName(where(ProductSpecification.getTitle(nameFilter)))));
    }
}
