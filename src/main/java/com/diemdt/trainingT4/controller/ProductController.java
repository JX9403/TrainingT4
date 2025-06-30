package com.diemdt.trainingT4.controller;

import com.diemdt.trainingT4.dto.ProductDTO;
import com.diemdt.trainingT4.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody  @Valid ProductDTO productDTO){
        return ResponseEntity.ok(productService.createProduct(productDTO));
    }

    @PutMapping( "/{id}")
    public ResponseEntity<ProductDTO> updateProduct(@PathVariable Long id,
                                                    @RequestBody @Valid ProductDTO productDTO
                                                    ){
        return ResponseEntity.ok(productService.updateProduct(id, productDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProduct(@PathVariable Long id){
        return ResponseEntity.ok(productService.getProduct(id));
    }

    @GetMapping
    public ResponseEntity<Page<ProductDTO>> getAllProducts(@PageableDefault(size = 10) Pageable pageable,  @RequestParam(required = false) String search){
        return ResponseEntity.ok(productService.getAllProducts(search, pageable));
    }
}