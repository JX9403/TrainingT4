package com.diemdt.trainingT4.service;

import com.diemdt.trainingT4.exception.ResourceNotFoundException;
import com.diemdt.trainingT4.model.Category;
import com.diemdt.trainingT4.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    @Override
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Long id, Category category) {
        Category existingCategory = categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category not found"));

        existingCategory.setName(category.getName());

        return categoryRepository.save(existingCategory);
    }

    @Override
    public void deleteCategory(Long id) {
        Category existingCategory = categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category not found"));
         categoryRepository.deleteById(id);
    }

    @Override
    public Category getCategory(Long id) {
        Category existingCategory = categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category not found"));

        return existingCategory;
    }

    @Override
    public Page<Category> getAllCategories(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }
}
