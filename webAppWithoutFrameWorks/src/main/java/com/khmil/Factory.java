package com.khmil;

import com.khmil.controller.GetAllCategoriesController;
import com.khmil.controller.LogOutController;
import com.khmil.controller.LoginController;
import com.khmil.controller.RegisterController;
import com.khmil.controller.admin.AddProductController;
import com.khmil.controller.admin.GetAllCategoriesAdminController;
import com.khmil.controller.admin.GetAllProductsAdminController;
import com.khmil.dao.CategoryDaoImpl;
import com.khmil.dao.ProductDao;
import com.khmil.dao.ProductDaoImpl;
import com.khmil.dao.UserDaoImpl;
import com.khmil.service.ProductService;
import com.khmil.service.ProductServiceImpl;
import com.khmil.service.UserServiceImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Factory {

    private static Connection connection;

    static {
        try {
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:h2:tcp://localhost/~/test1", "sa", "");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return connection;
    }

    public static GetAllCategoriesController getAllCategoriesController() {
        return new GetAllCategoriesController(getCategoryDaoImpl(getConnection()));
    }

    public static GetAllCategoriesAdminController getAllCategoriesAdminController(String viewName) {
        return new GetAllCategoriesAdminController(getCategoryDaoImpl(getConnection()), viewName);
    }

    public static GetAllProductsAdminController getAllProductsAdminController() {
        return new GetAllProductsAdminController(getProductService(getConnection()));
    }

    public static AddProductController getAddProductController() {
        return new AddProductController(getProductService(getConnection()));
    }

    public static ProductService getProductService(Connection connection) {
        return new ProductServiceImpl(getProductDao(connection));
    }

    private static ProductDao getProductDao(Connection connection) {
        return new ProductDaoImpl(connection);
    }

    public static CategoryDaoImpl getCategoryDaoImpl(Connection connection) {
        return new CategoryDaoImpl(connection);
    }

    public static LoginController getLoginPageController() {
        return new LoginController(getUserService());
    }

    public static LogOutController getLogOutController() {
        return new LogOutController();
    }

    public static RegisterController getRegisterController() {
        return new RegisterController(getUserService());
    }

    public static UserServiceImpl getUserService() {
        return new UserServiceImpl(getUserDao());
    }

    public static UserDaoImpl getUserDao() {
        return new UserDaoImpl(getConnection());
    }
}
