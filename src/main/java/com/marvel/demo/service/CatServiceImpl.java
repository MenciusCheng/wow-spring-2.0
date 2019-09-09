package com.marvel.demo.service;

import com.marvel.demo.dao.CatDao;
import com.marvel.demo.domain.Cat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Marvel on 2019/9/9.
 */
@Service
public class CatServiceImpl implements CatService {

    private final CatDao catDao;

    @Autowired
    public CatServiceImpl(CatDao catDao) {
        this.catDao = catDao;
    }

    @Override
    public Cat findById(Long id) {
        return catDao.getCat(id);
    }

    @Override
    @Transactional
    public Integer insert(String name, Integer age) {
        Cat cat = new Cat();
        cat.setName(name);
        cat.setAge(age);
        Integer i = catDao.insert(cat);
        if (true) {
            throw new RuntimeException("插入错误");
        }
        return i;
    }

    /**
     * 无事务
     */
    @Override
    public Integer insertNT(String name, Integer age) {
        Cat cat = new Cat();
        cat.setName(name);
        cat.setAge(age);
        Integer i = catDao.insert(cat);
        if (true) {
            throw new RuntimeException("插入错误");
        }
        return i;
    }
}
