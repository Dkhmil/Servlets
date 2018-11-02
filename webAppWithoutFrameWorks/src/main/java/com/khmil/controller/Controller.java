package com.khmil.controller;

import com.khmil.web.Request;
import com.khmil.web.ViewModel;

public interface Controller {

    ViewModel process(Request request);

}
