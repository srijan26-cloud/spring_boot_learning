package com.jpatut.jpatutorial.Controllers;

import com.jpatut.jpatutorial.Entities.ProductEntity;
import com.jpatut.jpatutorial.Repositories.ProductRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "v1/api")
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping(path = "/getProductsByNameOrderByPrice")
    public List<ProductEntity> getProductsByNameOrderByPrice(){
        return productRepository.findByProductNameContainingIgnoreCaseOrderByProductPriceDesc("PEPSI");
    }

    @GetMapping(path = "/getAllProductsOrderByPrice")
    public List<ProductEntity> getAllProductsOrderByPrice(){
        return productRepository.findByOrderByProductPriceDesc();
    }

    @GetMapping(path = "/getAllProductsByDynamicSortParam")
    public List<ProductEntity> getAllProductsByDynamicSortParam(
            @RequestParam(defaultValue = "productId") String sortBy){

        //return productRepository.findAll(Sort.by(sortBy));

        //return productRepository.findAll(Sort.by(Sort.Direction.DESC ,sortBy , "createdAt"));

        return productRepository.findAll(Sort.by(Sort.Order.desc(sortBy) ,
                Sort.Order.asc("createdAt")));
    }

    @GetMapping(path = "/getProductsUsingPagination")
    public List<ProductEntity> getProductsUsingPagination(
            @RequestParam(defaultValue = "productId") String sortBy,
            @RequestParam(defaultValue = "0") Integer pageNo){

        //Pageable pageable = PageRequest.of(pageNo , 1);
        Pageable pageable = PageRequest.of(pageNo , 1, Sort.by(sortBy));
        return productRepository.findAll(pageable).getContent();
    }

    //"http://localhost:8080/v1/api/getProductsByUsingPaginationAndSoring?productQuantity=12&pageNo=0&sortBy=productPrice"
    @GetMapping(path = "/getProductsByUsingPaginationAndSoring")
    public List<ProductEntity> getProductsByUsingPaginationAndSoring(
            @RequestParam Integer productQuantity,
            @RequestParam(defaultValue = "productId") String sortBy,
            @RequestParam(defaultValue = "0") Integer pageNo){

        //Pageable pageable = PageRequest.of(pageNo , 1);
        Pageable pageable = PageRequest.of(pageNo , 2, Sort.by(sortBy));
        return productRepository.findByProductQuantity(
                productQuantity,
                pageable);
    }
}
