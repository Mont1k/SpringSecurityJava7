package com.example.springsecurityjava7.api;

import com.example.springsecurityjava7.entity.Product;
import com.example.springsecurityjava7.service.ProductServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor

public class ProductController {
private final ProductServiceImpl service;
@RequestMapping("/")
public String findAll(Model model){
    model.addAttribute("allProduct", new Product());
    return "/mainPage";
}
@RequestMapping("/new")
public String newProduct(Model model){
    model.addAttribute("newProduct", new Product());
    return "/innerPage";
}
@RequestMapping(value = "/save",method = RequestMethod.POST)
public String saveProduct(@ModelAttribute("newProduct") Product product){
    service.saveProduct(product);
    return "redirect:/";
}
@RequestMapping("/edit/{id}")
public ModelAndView updateProduct(@PathVariable(name = "id")Long id){
    ModelAndView view = new ModelAndView("edit_product");
    Product product =service.findByIdProduct(id);
    view.addObject("product",product);
    return view;
}
@RequestMapping("delete{id}")
public String deleteProduct(@PathVariable(name = "id")Long id){
    service.deleteByIdProduct(id);
    return "redirect:/";
}

}
