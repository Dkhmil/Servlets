package com.khmil.controller;

import com.khmil.dao.CategoryDao;
import com.khmil.model.Category;
import com.khmil.web.Request;
import com.khmil.web.ViewModel;

import java.util.List;

public class GetAllCategoriesController implements Controller {

    private final CategoryDao categoryDao;


    public GetAllCategoriesController(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }


    @Override
    public ViewModel process(Request request) {
        List<Category> categories = categoryDao.findAll();
        ViewModel vm = ViewModel.of("categories");
        vm.addAttribute("categories", categories);
        return vm;
    }
}
