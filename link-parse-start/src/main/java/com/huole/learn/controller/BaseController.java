package com.huole.learn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author hanning.hn
 * @date 2024/8/3
 */
@RestController
@RequestMapping("api/users")
public class BaseController {
    @GetMapping("/{id}")
    public String getUserById(@PathVariable Integer id) {
        return "userService.getUserById(id)";
    }
}
