//package com.marvel.demo;
//
//import com.marvel.demo.domain.Customer;
//import com.marvel.demo.domain.CustomerRepository;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.List;
//
///**
// * Created by Marvel on 18/09/14.
// */
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class CustomerTests {
//
//    private Logger logger = LoggerFactory.getLogger(getClass());
//
//    @Autowired
//    private CustomerRepository customerRepository;
//
//    @Test
//    public void testCustomer() {
//        logger.info("testCustomer=========================");
//
////        Customer c = new Customer("aaa", 12);
////        customerRepository.save(c);
//
//        Iterable<Customer> cs = customerRepository.findAll();
//        logger.info(cs.toString());
//
//        logger.info("testCustomer=========================");
//    }
//}
