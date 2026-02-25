package com.adminPanel.app.controller;

import com.adminPanel.app.model.Product;
import com.adminPanel.app.model.ProductDetails;
import com.adminPanel.app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String showAllProducts(Model model) {

        List<Product> products = productService.findAll();
        model.addAttribute("products", products);

        return "homePage";
    }

    @RequestMapping(value = "/viewMore", method = RequestMethod.GET)
    public String viewMore(@RequestParam("id") int id, Model model) {
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "viewMorePage";
    }


    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String showAddForm(Model model) {

        Product product = new Product();
        product.setProductDetails(new ProductDetails());

        model.addAttribute("product", product);
        return "addProductFormPage";
    }


    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveProduct(
            @Valid @ModelAttribute("product") Product product,
            BindingResult result, @RequestParam("imageFile") MultipartFile file) throws IOException {

        if (result.hasErrors()) {
            return "addProductFormPage";
        }
        if (product.getProductDetails() != null) {
            product.getProductDetails().setProduct(product);
        }
        if (!file.isEmpty()) {
            String uploadDir = "C:/uploads/";
            String fileName = file.getOriginalFilename();
            file.transferTo(new File(uploadDir + fileName));
            product.setImagePath("uploads/" + fileName);
        }
        productService.save(product);


        return "redirect:/products/list";

    }


    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String showUpdateForm(@RequestParam("id") int id, Model model) {

        Product product = productService.findById(id);
        model.addAttribute("product", product);

        return "updateProductDetails";
    }


    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateProduct(
            @Valid @ModelAttribute("product") Product product,
            BindingResult result, @RequestParam("imageFile") MultipartFile file) throws IOException {

        if (result.hasErrors()) {
            return "updateProductDetails";
        }
        if (product.getProductDetails() != null) {
            product.getProductDetails().setProduct(product);
        }
        if (!file.isEmpty()) {
            String uploadDir = "C:/uploads/";
            String fileName = file.getOriginalFilename();
            file.transferTo(new File(uploadDir + fileName));
            product.setImagePath("uploads/" + fileName);
        }
        productService.update(product);

        return "redirect:/products/list";

    }


    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteProduct(@RequestParam("id") int id) {

        productService.delete(id);
        return "redirect:/products/list";

    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
}