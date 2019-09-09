package com.marvel.demo.controller;

import com.marvel.demo.domain.Cat;
import com.marvel.demo.service.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Marvel on 2019/9/6.
 */
@RestController
@RequestMapping("/cat")
public class CatController {

    private final CatService catService;

    @Autowired
    public CatController(CatService catService) {
        this.catService = catService;
    }

    @RequestMapping("/{id}")
    public Cat findById(@PathVariable Long id) {
        return catService.findById(id);
    }

    @RequestMapping("/insert")
    public Integer insert(String name, Integer age) {
        return catService.insert(name, age);
    }

    @RequestMapping("/insertNT")
    public Integer insertNT(String name, Integer age) {
        return catService.insertNT(name, age);
    }
}
