package com.marvel.demo.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.marvel.demo.domain.WebRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Marvel on 18/12/03.
 */
@RestController
@RequestMapping(path = "/webhook")
public class WebhookController {

    private static Logger logger = LoggerFactory.getLogger(RabbitController.class);
    private static LinkedList<WebRequest> webRequests = new LinkedList<>();
    private static Gson gson = new GsonBuilder().disableHtmlEscaping().create();

    @RequestMapping(path = "")
    public List<WebRequest> index(HttpServletRequest request, HttpServletResponse response) {
        if (request.getParameterMap().size() > 0) {
            String parameters = gson.toJson(request.getParameterMap());
            WebRequest webRequest = new WebRequest(webRequests.size() + 1, request.getMethod(), parameters, LocalDateTime.now(), request.getHeader("content-type"));
            logger.info(webRequest.toString());
            webRequests.push(webRequest);
        }
        return webRequests;
    }
}
