package com.khmil.controller;

import com.khmil.web.Request;
import com.khmil.web.ViewModel;

import javax.servlet.http.Cookie;

import static com.khmil.web.filters.UserFilter.COOKIE_NAME;

public class LogOutController implements Controller {

    @Override
    public ViewModel process(Request request) {
        ViewModel vm = ViewModel.of("login");
        Cookie[] cookies = request.getCookies();

        if (cookies == null) {
            return vm;
        }

        for (int i = 0; i < cookies.length; i++) {
            Cookie c = cookies[i];
            if (c.getName().equals(COOKIE_NAME)) {
                cookies[i].setMaxAge(0);
            }
        }
        vm.setCookies(cookies);
        return vm;
    }
}
