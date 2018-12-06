package com.marvel.demo.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.marvel.demo.domain.WebRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Marvel on 18/12/03.
 */
@RestController
@RequestMapping(path = "/webhook")
public class WebhookController {

    private static Logger logger = LoggerFactory.getLogger(WebhookController.class);
    private static LinkedList<WebRequest> webRequests = new LinkedList<>();
    private static Gson gson = new GsonBuilder().disableHtmlEscaping().create();

    @RequestMapping(path = "")
    public List<WebRequest> index(HttpServletRequest request, HttpServletResponse response) throws IOException {

        logger.info("Request URL: " + request.getRequestURL().toString());
        logger.info("Request Method: " + request.getMethod());

        logger.info("Request Headers");
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            logger.info("\t" + headerName + ": " + request.getHeader(headerName));
        }

        if ("application/json".equals(request.getHeader("content-type"))) {
            BufferedReader br = request.getReader();
            String str;
            List<String> strList = new ArrayList<>();
            while((str = br.readLine()) != null) {
                strList.add(str);
            }
            logger.info("Request Json:\n" + StringUtils.arrayToDelimitedString(strList.toArray(), "\n"));
        }

        logger.info("Request Parameters");
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String parameterName = parameterNames.nextElement();
            logger.info("\t" + parameterName + ": " + request.getParameter(parameterName));

        }

        if (request.getParameterMap().size() > 0) {
            String parameters = gson.toJson(request.getParameterMap());
            WebRequest webRequest = new WebRequest(webRequests.size() + 1, request.getMethod(), parameters, LocalDateTime.now(), request.getHeader("content-type"));
            logger.info(webRequest.toString());
            webRequests.push(webRequest);
        }
        return webRequests;
    }
}
