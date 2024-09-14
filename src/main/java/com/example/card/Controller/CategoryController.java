package com.example.card.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.card.Model.CategoryModel;
import com.example.card.Service.CategoryService;



@RequestMapping("/api/v1/applications")
@RestController

public class CategoryController {
    @Autowired
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    // get all categories
    @GetMapping
    public ResponseEntity< List<CategoryModel>> getAllCategories() {
        return ResponseEntity.ok().body(categoryService.getAllCategories());
    }

    // get category by id
    @GetMapping("/{id}")
    public ResponseEntity<CategoryModel> getCategoryById(@PathVariable Long id) {
        return ResponseEntity.ok().body(categoryService.getCategoryById(id));
    }

    // add category
    @PostMapping
    public ResponseEntity<CategoryModel> addCategory(@RequestBody @Validated CategoryModel category) {
        return ResponseEntity.ok().body(categoryService.addCategory(category));
    }

    // update category
    @PutMapping("/{id}")
    public ResponseEntity<CategoryModel> updateCategory(@PathVariable Long id,
            @RequestBody  @Validated CategoryModel category) {
                System.out.println("id: "+id);
        CategoryModel updatedCategory = categoryService.updateCategory(id, category);
        return ResponseEntity.ok(updatedCategory);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }

}
