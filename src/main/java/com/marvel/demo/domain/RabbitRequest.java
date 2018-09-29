package com.marvel.demo.domain;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

/**
 * Created by Marvel on 18/09/29.
 */
public class RabbitRequest {
    @NotNull(groups = Modify.class)
    @Null(groups = Add.class)
    private Long id;
    @Size(min=3, max=20)
    private String name;
    @Email
    private String email;

    public interface Add{}
    public interface Modify{}

    public RabbitRequest() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
