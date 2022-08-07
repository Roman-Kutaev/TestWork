package com.testWork.services.mapper;
import com.testWork.dto.ProductDTO;
import com.testWork.model.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface ProductMapper extends EntityMapper<ProductDTO, Product> {
}
