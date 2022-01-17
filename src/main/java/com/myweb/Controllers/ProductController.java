package com.myweb.Controllers;

import com.myweb.models.Product;
import com.myweb.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ProductController{
  @Autowired
  private ProductService productService;

  @GetMapping("/products")
    public  String showProduct(Model model){
//      List<Product> productList = productService.listAll();
//     model.addAttribute("listProducts",productList);

     return "products";
  }

}
