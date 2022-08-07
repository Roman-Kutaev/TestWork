package com.testWork.services;

import com.testWork.model.Product;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface ProductService {
    List<Product> getProductsByName(Specification<Product> specifications);
}
