package com.diemdt.trainingT4.controller;

import com.diemdt.trainingT4.model.Category;
import com.diemdt.trainingT4.service.CategoryService;
import com.diemdt.trainingT4.service.CategoryV2Service;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/categories")
@Tag(name = "Category APIs", description = "API Category")
public class CategoryController {

    private final CategoryService categoryService;
    private final CategoryV2Service categoryV2Service;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Tạo mới category")
    public ResponseEntity<Category> createCategory(@RequestBody @Valid Category category) {
        return ResponseEntity.ok(categoryV2Service.save(category));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Xoá category theo ID")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        categoryV2Service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Lấy thông tin category theo ID")
    public ResponseEntity<Category> getCategory(@PathVariable Long id) {
        return ResponseEntity.ok(categoryV2Service.findById(id));
    }

    @GetMapping
    @Operation(summary = "Lấy danh sách category (phân trang)")
    public ResponseEntity<Page<Category>> getAllCategories(@PageableDefault(size = 10) Pageable pageable) {
        return ResponseEntity.ok(categoryService.getAllCategories(pageable));
    }
}
