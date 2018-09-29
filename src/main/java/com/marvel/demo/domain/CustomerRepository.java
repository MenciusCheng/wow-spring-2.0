package com.marvel.demo.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Marvel on 18/09/14.
 */
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByName(String name);
}
