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

import com.service.posts.migow.migow_posts_service.application.dtos.posts.PostResponseDTO;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.posts.CreatePostUseCase;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.posts.GetAllPopularFriendPostUseCase;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.posts.GetAllRecentFriendPostUseCase;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.posts.GetPostByIdUseCase;

@RestController
@RequestMapping("/posts")
public class PostController {

    private final GetPostByIdUseCase getPostByIdUseCase;
    private final GetAllRecentFriendPostUseCase getAllRecentFriendPostUseCase;
    private final GetAllPopularFriendPostUseCase getAllPopularFriendPostUseCase;
    private final CreatePostUseCase createPostUseCase;

    public PostController(
            GetPostByIdUseCase getPostByIdUseCase,
            GetAllRecentFriendPostUseCase getAllRecentFriendPostUseCase,
            GetAllPopularFriendPostUseCase getAllPopularFriendPostUseCase,
            CreatePostUseCase createPostUseCase) {
        this.getPostByIdUseCase = getPostByIdUseCase;
        this.getAllRecentFriendPostUseCase = getAllRecentFriendPostUseCase;
        this.getAllPopularFriendPostUseCase = getAllPopularFriendPostUseCase;
        this.createPostUseCase = createPostUseCase;
    }

    @GetMapping("/{userId}/recent")
    public Page<PostResponseDTO> getAllRecentFriendPost(
            @PathVariable UUID userId,
            @RequestParam(name = "pageNumber", defaultValue = "0") int pageNumber,
            @RequestParam(name = "pageSize", defaultValue = "15") int pageSize) {

        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return this.getAllRecentFriendPostUseCase.execute(userId, pageable);
    }

    @GetMapping("/{userId}/popular")
    public Page<PostResponseDTO> getAllPopularFriendPost(
            @PathVariable UUID userId,
            @RequestParam(name = "pageNumber", defaultValue = "0") int pageNumber,
            @RequestParam(name = "pageSize", defaultValue = "15") int pageSize) {

        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return this.getAllPopularFriendPostUseCase.execute(userId, pageable);
    }

}
