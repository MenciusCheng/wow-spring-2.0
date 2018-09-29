package com.marvel.demo.controller;

import com.marvel.demo.domain.Customer;
import com.marvel.demo.domain.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * Created by Marvel on 18/09/14.
 */
@RestController
@RequestMapping(path = "/customer")
public class CustomerController {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @PostMapping
    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteCustomerById(@PathVariable Long id) {
        customerRepository.deleteById(id);
    }

    @PutMapping(path = "/{id}")
    public Customer updateCustomer(@PathVariable Long id, Customer customer) {
        Optional<Customer> customerOpt = customerRepository.findById(id);
        if (customerOpt.isPresent()) {
            Customer c = customerOpt.get();
            c.setName(customer.getName());
            c.setAge(customer.getAge());
            return customerRepository.save(c);
        } else {
            throw new RuntimeException("不存在");
        }
    }

    @GetMapping(path = "")
    public Iterable<Customer> findAllCustomer() {
        return customerRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public Customer findCustomerById(@PathVariable Long id) {
        Optional<Customer> customerOpt = customerRepository.findById(id);
        return customerOpt.orElse(new Customer("null", 1));
    }
}
