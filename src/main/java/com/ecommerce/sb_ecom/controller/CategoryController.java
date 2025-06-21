package com.ecommerce.sb_ecom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.sb_ecom.model.Category;
import com.ecommerce.sb_ecom.service.CategoryService;

@RestController
public class CategoryController {

    @Autowired private CategoryService categoryService;

    


    @GetMapping("/api/public/categories")
    public List<Category> getAllCategories(){
        return categoryService.getAllCategories();
    }


    @PostMapping("/api/public/categories")
    public String createCategory(@RequestBody Category category){
        String status = categoryService.createCategory(category);
        return status;
        // 
    }

    @DeleteMapping("/api/admin/categories/{categoryId}")
    public String deleteCategory(@PathVariable Long categoryId){

        String status = categoryService.DeleteCategory(categoryId);
        return status;
        
    }

}
