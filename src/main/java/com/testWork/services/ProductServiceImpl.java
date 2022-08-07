package com.testWork.services;

import com.testWork.model.Product;
import com.testWork.repositories.ProductRepository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getProductsByName(Specification<Product> specifications) {
        return productRepository.findAll(specifications);
    }

}
