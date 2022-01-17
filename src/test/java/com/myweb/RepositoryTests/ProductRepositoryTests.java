package com.myweb.RepositoryTests;


import com.myweb.models.Product;
import com.myweb.repository.ProductRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)

public class ProductRepositoryTests {
  @Autowired
  private ProductRepository repo;


    @Test
    public void  AddNewProduct(){
        Product product = new Product();
        product.setProductName("mango");
        product.setProductType("fruits");
        product.setAvailability(true);

        Product savedProduct = repo.save(product);
        Assertions.assertThat(savedProduct).isNotNull();
        Assertions.assertThat(savedProduct.getId()).isGreaterThan(0);


    }

}
