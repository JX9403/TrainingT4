package com.diemdt.trainingT4.service.base;

import com.diemdt.trainingT4.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BaseServiceImpl<T> implements BaseService<T> {
    @SuppressWarnings("all")
    @Autowired
    JpaRepository<T, Long> repository;

    @Override
    public T findById(long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("id not found : " + id));
    }

    @Override
    public List<T> findAll() {
        return repository.findAll();
    }

    @Override
    public T save(T t) {
        return repository.save(t);
    }

    @Override
    public void deleteById(long id) {
        repository.deleteById(id);
    }

    @Override
    public Page<T> findAll(T model, Pageable pageable) {
        Example<T> example = Example.of(model);
        return repository.findAll(example, pageable);
    }
}
