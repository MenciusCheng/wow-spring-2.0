package com.marvel.demo.domain;

import java.time.LocalDateTime;

/**
 * Created by Marvel on 18/12/03.
 */
public class WebRequest {

    private int id;
    private String method;
    private String parameters;
    private LocalDateTime requestTime;
    private String contentType;

    public WebRequest() {
    }

    public WebRequest(int id, String method, String parameters, LocalDateTime requestTime, String contentType) {
        this.id = id;
        this.method = method;
        this.parameters = parameters;
        this.requestTime = requestTime;
        this.contentType = contentType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getParameters() {
        return parameters;
    }

    public void setParameters(String parameters) {
        this.parameters = parameters;
    }

    public LocalDateTime getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(LocalDateTime requestTime) {
        this.requestTime = requestTime;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("WebRequest{");
        sb.append("id=").append(id);
        sb.append(", method='").append(method).append('\'');
        sb.append(", parameters='").append(parameters).append('\'');
        sb.append(", requestTime=").append(requestTime);
        sb.append(", contentType='").append(contentType).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
