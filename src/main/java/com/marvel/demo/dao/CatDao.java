package com.marvel.demo.dao;

import com.marvel.demo.domain.Cat;
import org.springframework.stereotype.Repository;

/**
 * Created by Marvel on 2019/9/6.
 */
@Repository
public interface CatDao {
    Cat getCat(Long id);

    int insert(Cat cat);
}
