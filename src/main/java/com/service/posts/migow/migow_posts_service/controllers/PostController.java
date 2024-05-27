package com.service.posts.migow.migow_posts_service.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.service.posts.migow.migow_posts_service.DTOs.PostDTO;
import com.service.posts.migow.migow_posts_service.services.PostService;


@RestController("/posts")
public class PostController {
    @Autowired
    PostService service;

    @GetMapping("/posts")
    public Page<PostDTO> getMethodName(
            @RequestParam(name = "userId") UUID userId,
            @RequestParam(name = "pageNumber", defaultValue = "0") int pageNumber,
            @RequestParam(name = "pageSize", defaultValue = "15") int pageSize) {

        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return service.findAllByUserId(userId, pageable);
    }

}
