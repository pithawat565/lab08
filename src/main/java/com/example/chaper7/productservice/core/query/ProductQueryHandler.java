package com.example.chaper7.productservice.core.query;

import com.example.chaper7.productservice.core.ProductEntity;
import com.example.chaper7.productservice.core.data.ProductRepository;
import com.example.chaper7.productservice.core.query.rest.ProductRestModel;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductQueryHandler {

    @Autowired
    private final ProductRepository productRepository;

    public ProductQueryHandler(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @QueryHandler
    List<ProductRestModel> findProducts(FindProductQuery query){
        List<ProductRestModel> productsRest = new ArrayList<>();
        List<ProductEntity> storedProducts = productRepository.findAll();
        for(ProductEntity product : storedProducts){
            ProductRestModel productRestModel= new ProductRestModel();
            BeanUtils.copyProperties(product, productRestModel);
            productsRest.add(productRestModel);
        }
        return productsRest;
    }
}
