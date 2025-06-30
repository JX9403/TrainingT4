package com.diemdt.trainingT4.controller;

import com.diemdt.trainingT4.dto.ProductDTO;
import com.diemdt.trainingT4.service.ProductService;
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
@RequestMapping("/api/products")
@RequiredArgsConstructor
@Tag(name = "Product APIs", description = "API Product")
public class ProductController {

    private final ProductService productService;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Tạo mới product")
    public ResponseEntity<ProductDTO> createProduct(@RequestBody @Valid ProductDTO productDTO) {
        return ResponseEntity.ok(productService.createProduct(productDTO));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Cập nhật product theo ID")
    public ResponseEntity<ProductDTO> updateProduct(@PathVariable Long id, @RequestBody @Valid ProductDTO productDTO) {
        return ResponseEntity.ok(productService.updateProduct(id, productDTO));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Xoá product theo ID")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Lấy thông tin product theo ID")
    public ResponseEntity<ProductDTO> getProduct(@PathVariable Long id) {
        return ResponseEntity.ok(productService.getProduct(id));
    }

    @GetMapping
    @Operation(summary = "Lấy danh sách product (phân trang và tìm kiếm)")
    public ResponseEntity<Page<ProductDTO>> getAllProducts(@PageableDefault(size = 10) Pageable pageable, @RequestParam(required = false) String search) {
        return ResponseEntity.ok(productService.getAllProducts(search, pageable));
    }
}
