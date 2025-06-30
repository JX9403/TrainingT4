package com.diemdt.trainingT4.service;

import com.diemdt.trainingT4.model.Category;
import com.diemdt.trainingT4.service.base.BaseServiceImpl;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional(rollbackOn = Exception.class)
public class CategoryV2ServiceImpl extends BaseServiceImpl<Category> implements CategoryV2Service {
}
