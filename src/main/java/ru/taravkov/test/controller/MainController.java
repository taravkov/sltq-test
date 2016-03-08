package ru.taravkov.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by vladislav on 08.03.16.
 */
@Controller
public class MainController {

    @RequestMapping({ "/", "/login", "/table" })
    public String index() {
        return "index.html";
    }
}
