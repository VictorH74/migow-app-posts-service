package com.service.posts.migow.migow_posts_service.infra.http.controllers;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.service.posts.migow.migow_posts_service.application.interfaces.usecases.posts.CreatePostUseCase;
import com.service.posts.migow.migow_posts_service.application.interfaces.usecases.posts.GetAllFollowedUserPostUseCase;
import com.service.posts.migow.migow_posts_service.application.interfaces.usecases.posts.GetPostByIdUseCase;
import com.service.posts.migow.migow_posts_service.infra.http.dtos.posts.PostResponseDTO;

@RestController
@RequestMapping("/posts")
public class PostController {

    private final GetPostByIdUseCase getPostByIdUseCase;
    private final GetAllFollowedUserPostUseCase getAllFollowedUserPostUseCase;
    private final CreatePostUseCase createPostUseCase;

    public PostController(
            GetPostByIdUseCase getPostByIdUseCase,
            GetAllFollowedUserPostUseCase getAllFollowedUserPostUseCase,
            CreatePostUseCase createPostUseCase) {
        this.getPostByIdUseCase = getPostByIdUseCase;
        this.getAllFollowedUserPostUseCase = getAllFollowedUserPostUseCase;
        this.createPostUseCase = createPostUseCase;
    }

    @GetMapping("/{followerId}")
    public Page<PostResponseDTO> getAllPostByUserId(
            @PathVariable UUID followerId,
            @RequestParam(name = "pageNumber", defaultValue = "0") int pageNumber,
            @RequestParam(name = "pageSize", defaultValue = "15") int pageSize) {

        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return this.getAllFollowedUserPostUseCase.execute(followerId, pageable);
    }

}
