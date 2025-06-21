package com.ecommerce.sb_ecom.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ecommerce.sb_ecom.model.Category;


@Service
public class CategoryServiceImplementation implements CategoryService {
    
    
    private List<Category> categories = new ArrayList<>();
    private Long nextId = 1L;
    @Override
    public List<Category> getAllCategories() {
       return categories;
    }

    @Override
    public String createCategory(Category category) {
      category.setCategoryId(nextId++);
       categories.add(category);
       return "Category added successfully";
    }

    @Override
    public String DeleteCategory(Long categoryId) {
      Category category = categories.stream()
      .filter(c-> c.getCategoryId().equals(categoryId))
      .findFirst().orElse(null);

      if(category==null){
         return "Category not found";
      }

      categories.remove(category);
      return "Category removed :"+categoryId+"successfully";
   }

    

}
