package com.diemdt.trainingT4.repository;


import com.diemdt.trainingT4.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("select p from Product p where :name is null or length(trim(:name)) = 0 or p.name like %:name%")
    Page<Product> findByNameContainingIgnoreCase(String name, Pageable pageable);
}
