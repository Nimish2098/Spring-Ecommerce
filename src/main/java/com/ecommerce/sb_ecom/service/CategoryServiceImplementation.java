package com.ecommerce.sb_ecom.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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
      .findFirst()
      .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
      categories.remove(category);
      return "Category removed :"+categoryId+" successfully";
   }
   @Override
   public String UpdateCategory(Category category, Long categoryId){
      Optional<Category>optionalCategory = categories.stream()
      .filter(c->c.getCategoryId().equals(categoryId))
      .findFirst();
      if(optionalCategory.isPresent()){
         Category existingCategory = optionalCategory.get();
         existingCategory.setCategoryName(category.getCategoryName());
         return "Updated Successfully";
      }
      else{
         throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Category not found");
      }
   }

   

}
