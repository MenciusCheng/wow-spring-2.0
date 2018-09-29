package com.marvel.demo.controller;

import com.marvel.demo.domain.RabbitRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 字段校验
 *
 * Created by Marvel on 18/09/29.
 */
@RestController
@RequestMapping(path = "/rabbit")
public class RabbitController {

    private static Logger logger = LoggerFactory.getLogger(RabbitController.class);

    @GetMapping(path = "add")
    public String addRabbit(@Validated({RabbitRequest.Add.class}) RabbitRequest request, BindingResult result) {
        if (result.hasErrors()) {
            List<ObjectError> allErrors = result.getAllErrors();
            FieldError error = (FieldError)allErrors.get(0);
            logger.info(error.getObjectName() + "," + error.getField() + "," + error.getDefaultMessage());
        } else {
            logger.info("0 error");
        }
        return "addRabbit";
    }

    @GetMapping(path = "modify")
    public String modifyRabbit(@Validated({RabbitRequest.Modify.class})RabbitRequest request, BindingResult result) {
        if (result.hasErrors()) {
            List<ObjectError> allErrors = result.getAllErrors();
            FieldError error = (FieldError)allErrors.get(0);
            logger.info(error.getObjectName() + "," + error.getField() + "," + error.getDefaultMessage());
        } else {
            logger.info("0 error");
        }
        return "modifyRabbit";
    }

    @GetMapping(path = "find")
    public String findRabbit(@Validated RabbitRequest request, BindingResult result) {
        if (result.hasErrors()) {
            List<ObjectError> allErrors = result.getAllErrors();
            FieldError error = (FieldError)allErrors.get(0);
            logger.info(error.getObjectName() + "," + error.getField() + "," + error.getDefaultMessage());
        } else {
            logger.info("0 error");
        }
        return "findRabbit";
    }
}
