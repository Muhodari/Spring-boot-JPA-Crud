package com.myweb.services;

import com.myweb.models.Product;
import com.myweb.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
  private ProductRepository repo;

    public List<Product> listAll(){
        return repo.findAll();
    }

    public  void save(Product product){
        repo.save(product);
    }





}
