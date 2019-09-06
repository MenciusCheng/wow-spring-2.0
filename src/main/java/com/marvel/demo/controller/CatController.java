package com.marvel.demo.controller;

import com.marvel.demo.dao.CatDao;
import com.marvel.demo.domain.Cat;
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

    @Autowired
    private CatDao catDao;


//    public CatController(CatDao catDao) {
//        this.catDao = catDao;
//    }

    @RequestMapping("/{id}")
    public Cat findById(@PathVariable Long id) {
        return catDao.getCat(id);
    }
}
