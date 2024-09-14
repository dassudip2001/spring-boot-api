package com.example.card.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.card.Model.CategoryModel;
import com.example.card.Repo.CategoryRepository;

import jakarta.transaction.Transactional;

@Service
public class CategoryService {

    @Autowired
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    // get all categories
    public List<CategoryModel> getAllCategories() {
        return categoryRepository.findAll();
    }

    // get category by id
    public CategoryModel getCategoryById(Long id) {
        return categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category not found"));
    }

    // add category
    @Transactional
    public CategoryModel addCategory(CategoryModel category) {
        return categoryRepository.save(category);
    }

    // update category
    @Transactional
    public CategoryModel updateCategory(Long id, CategoryModel category) {
        Optional<CategoryModel> existingCategoryOpt = categoryRepository.findById(id);
        if(existingCategoryOpt.isPresent()) {
            CategoryModel existingCategory = existingCategoryOpt.get();
            existingCategory.setApplicationId(category.getApplicationId());
            return categoryRepository.save(existingCategory);
        } else {
            throw new RuntimeException("Category with id " + id + " not found");
        }
    }

    // delete category
    @Transactional
    public String deleteCategory(Long id) {
        if(categoryRepository.findById(id).isPresent()) {
            categoryRepository.deleteById(id);
            return "Category removed!! " + id;
        } else {
            throw new RuntimeException("Category with id " + id + " not found");
        }
    }
}
