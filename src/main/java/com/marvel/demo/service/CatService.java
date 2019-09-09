package com.marvel.demo.service;

import com.marvel.demo.domain.Cat;

/**
 * Created by Marvel on 2019/9/9.
 */
public interface CatService {

    Cat findById(Long id);

    Integer insert(String name, Integer age);

    Integer insertNT(String name, Integer age);
}
