package com.testWork.specifications;

import com.testWork.model.Product;

import com.testWork.model.Product_;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProductSpecification {
    public static Specification<Product> getTitle(String name) {

        name = name.replaceAll("[^A-Za-zА-Яа-я]", "");
        String[] letters = name.split("");

        if (letters.length == 1) {
            return ((root, query, criteriaBuilder) -> {
                return criteriaBuilder.notLike(root.get(Product_.NAME), letters[0] + "%");
            });
        } else {
            return ((root, query, criteriaBuilder) -> {
                List<Predicate> predicates = new ArrayList<>();
                for (String letter : letters) {
                    predicates.add(criteriaBuilder.notLike(root.get(Product_.NAME), "%" + letter + "%"));
                }
                return criteriaBuilder.and(predicates.toArray(Predicate[]::new));
            });
        }
    }
}
