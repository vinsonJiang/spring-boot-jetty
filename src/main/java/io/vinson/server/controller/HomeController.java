package io.vinson.server.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @author: jiangweixin
 * @date: 2019/4/3
 */
@RestController
public class HomeController {

    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }
}
