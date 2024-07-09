package com.service.posts.migow.migow_posts_service.infra.http.controllers;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.service.posts.migow.migow_posts_service.application.interfaces.usecases.posts.CreatePostUseCase;
import com.service.posts.migow.migow_posts_service.application.interfaces.usecases.posts.GetAllPostByUserIdUseCase;
import com.service.posts.migow.migow_posts_service.application.interfaces.usecases.posts.GetPostByIdUseCase;
import com.service.posts.migow.migow_posts_service.infra.http.dtos.PostDTO;

@RestController
@RequestMapping("/posts")
public class PostController {

    private final GetPostByIdUseCase getPostByIdUseCase;
    private final GetAllPostByUserIdUseCase getAllPostByUserIdUseCase;
    private final CreatePostUseCase createPostUseCase;

    public PostController(
            GetPostByIdUseCase getPostByIdUseCase,
            GetAllPostByUserIdUseCase getAllPostByUserIdUseCase,
            CreatePostUseCase createPostUseCase) {
        this.getPostByIdUseCase = getPostByIdUseCase;
        this.getAllPostByUserIdUseCase = getAllPostByUserIdUseCase;
        this.createPostUseCase = createPostUseCase;
    }

    @GetMapping
    public Page<PostDTO> getMethodName(
            @RequestParam(name = "userId") UUID userId,
            @RequestParam(name = "pageNumber", defaultValue = "0") int pageNumber,
            @RequestParam(name = "pageSize", defaultValue = "15") int pageSize) {

        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return this.getAllPostByUserIdUseCase.execute(userId, pageable);
        // return service.findAllByUserId(userId, pageable);
    }

}
