package com.example.springsecurityjava7.api;

import com.example.springsecurityjava7.entity.Product;
import com.example.springsecurityjava7.service.ProductServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
@RequiredArgsConstructor

public class ProductController {
private final ProductServiceImpl service;

public String findAll(Model model){
    model.addAttribute("allProduct", new Product());
    return "/mainPage";
}
public String newProduct(Model model){
    model.addAttribute("newProduct", new Product());
}
}
