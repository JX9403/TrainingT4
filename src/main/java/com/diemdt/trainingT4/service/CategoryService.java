package com.diemdt.trainingT4.service;

import com.diemdt.trainingT4.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CategoryService {

    Category createCategory (Category category);
    Category updateCategory (Long id , Category category);
    void deleteCategory ( Long id );
    Category getCategory ( Long id);
    Page<Category> getAllCategories(Pageable pageable);
}
