package com.khmil.controller.admin;

import com.khmil.controller.Controller;
import com.khmil.model.Product;
import com.khmil.service.ProductService;
import com.khmil.web.Request;
import com.khmil.web.ViewModel;

import java.util.List;

public class GetAllProductsAdminController implements Controller {

    private ProductService productService;

    public GetAllProductsAdminController(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public ViewModel process(Request request) {
        List<Product> products = productService.findAll();
        ViewModel vm = ViewModel.of("manageProducts");
        vm.addAttribute("products", products);
        return vm;
    }
}
