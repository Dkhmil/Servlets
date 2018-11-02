package com.khmil.controller.admin;

import com.khmil.controller.Controller;
import com.khmil.model.Category;
import com.khmil.model.Product;
import com.khmil.service.ProductService;
import com.khmil.web.Request;
import com.khmil.web.ViewModel;

import java.util.List;

public class AddProductController implements Controller {

    private final ProductService productService;

    public AddProductController(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public ViewModel process(Request request) {
        String productName = request.getParamByName("productName");
        double price = Double.valueOf(request.getParamByName("price"));
        String description = request.getParamByName("description");
        long categoryId = Long.valueOf(request.getParamByName("categoryId"));

        Product product = new Product(productName, price, description);
        Category category = new Category();
        category.setId(categoryId);
        product.setCategory(category);

        productService.save(product);

        List<Product> products = productService.findAll();

        ViewModel vm = ViewModel.of("manageProducts");
        vm.addAttribute("products", products);

        return vm;
    }
}
