package com.khmil.controller.admin;

import com.khmil.controller.Controller;
import com.khmil.dao.CategoryDao;
import com.khmil.model.Category;
import com.khmil.web.Request;
import com.khmil.web.ViewModel;

import java.util.List;

public class GetAllCategoriesAdminController implements Controller {

    private final CategoryDao categoryDao;
    private final String VIEW_NAME;

    public GetAllCategoriesAdminController(CategoryDao categoryDao, String viewName) {
        this.categoryDao = categoryDao;
        this.VIEW_NAME = viewName;
    }


    @Override
    public ViewModel process(Request request) {
        List<Category> categories = categoryDao.findAll();
        ViewModel vm = ViewModel.of(VIEW_NAME);
        vm.addAttribute("categories", categories);
        return vm;
    }
}
