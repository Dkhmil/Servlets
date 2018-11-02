package com.khmil.dao;

import com.khmil.model.Category;

import java.util.List;

public interface CategoryDao {

    Category findById(Long id);

    List<Category> findAll();
}
