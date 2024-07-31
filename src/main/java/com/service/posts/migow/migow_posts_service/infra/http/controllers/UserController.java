package com.service.posts.migow.migow_posts_service.infra.http.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.posts.migow.migow_posts_service.domain.entities.User;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.users.CreateUpdateUserUseCase;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("users")
@AllArgsConstructor
@Log4j2
public class UserController {

    private final CreateUpdateUserUseCase createUpdateUserUseCase;

    @PostMapping
    public void createUser(@RequestBody User entity) {
        log.info("Request User >>> " + entity);
        createUpdateUserUseCase.execute(entity);

    }

}
