package com.ecommerce.sb_ecom.service;

import java.util.List;

import com.ecommerce.sb_ecom.model.Category;

public interface CategoryService {

    List<Category>getAllCategories();
    public String createCategory(Category category);
    public String DeleteCategory(Long categoryId);
    public String UpdateCategory(Category category,Long categoryId);
}
