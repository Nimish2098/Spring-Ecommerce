package com.ecommerce.sb_ecom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.ecommerce.sb_ecom.model.Category;
import com.ecommerce.sb_ecom.service.CategoryService;

@RestController
public class CategoryController {

    @Autowired private CategoryService categoryService;

    @GetMapping("/api/public/categories")
    public ResponseEntity<List<Category>> getAllCategories(){
        List<Category> categories = categoryService.getAllCategories();
        return new  ResponseEntity<>(categories,HttpStatus.OK);
    }


    @PostMapping("/api/public/categories")
    public ResponseEntity<String> createCategory(@RequestBody Category category){
        String status = categoryService.createCategory(category);
        return new ResponseEntity<>(status,HttpStatus.CREATED);
    }

    @DeleteMapping("/api/admin/categories/{categoryId}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long categoryId){
        try{
        String status = categoryService.DeleteCategory(categoryId);
        return new ResponseEntity<>(status,HttpStatus.OK);
        // return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(status);
        // return ResponseEntity.ok(status);
        }
        catch(ResponseStatusException e){
            return new ResponseEntity<>(e.getReason(),e.getStatusCode());
        }

    }

    // @PutMapping("/api/public/categories/{categoryId}")
    // public ResponseEntity<String> updateCategory(@RequestBody Category category,@PathVariable Long categoryId){
    //     // try{
    //     //     String savedCategory = categoryService.UpdateCategory(category, categoryId);
    //     //     return new ResponseEntity<>("Category updated successfully"+categoryId,HttpStatus.OK);
    //     // }
        
    // }
    
        
    

}
