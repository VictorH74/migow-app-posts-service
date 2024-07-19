package com.service.posts.migow.migow_posts_service.infra.http.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.service.posts.migow.migow_posts_service.domain.entities.User;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.users.GetAllUserUseCase;


@RestController
@RequestMapping("/users")
public class UserController {

    private final GetAllUserUseCase getAllUserUseCase;

    public UserController(GetAllUserUseCase getAllUserUseCase) {
        this.getAllUserUseCase = getAllUserUseCase;
    }

    @GetMapping
    public Page<User> getUsers(@RequestParam(defaultValue = "0", name = "pageNumber") int pageNumber,
            @RequestParam(defaultValue = "10", name = "pageSize") int pageSize) {

        Pageable pageable = PageRequest.of(pageNumber, pageSize);

        return getAllUserUseCase.execute(pageable);
    }

}
