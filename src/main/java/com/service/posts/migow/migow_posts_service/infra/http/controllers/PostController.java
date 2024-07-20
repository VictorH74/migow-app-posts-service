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

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.service.posts.migow.migow_posts_service.application.dtos.posts.PostResponseDTO;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.posts.CreatePostUseCase;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.posts.GetAllPopularFriendPostUseCase;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.posts.GetAllRecentFriendPostUseCase;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.posts.GetPostByIdUseCase;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/posts")
@AllArgsConstructor
public class PostController {

    private final GetPostByIdUseCase getPostByIdUseCase;
    private final GetAllRecentFriendPostUseCase getAllRecentFriendPostUseCase;
    private final GetAllPopularFriendPostUseCase getAllPopularFriendPostUseCase;
    private final CreatePostUseCase createPostUseCase;

    @GetMapping("/{userId}/recent")
    public Page<PostResponseDTO> getAllRecentFriendPost(
            @PathVariable UUID userId,
            @RequestParam(name = "pageNumber", defaultValue = "0") int pageNumber,
            @RequestParam(name = "pageSize", defaultValue = "15") int pageSize) {
        try {
            Pageable pageable = PageRequest.of(pageNumber, pageSize);
            return this.getAllRecentFriendPostUseCase.execute(userId, pageable);
        } catch (UsernameNotFoundException e) {
            throw e;
        } catch (AuthenticationException e) {
            throw  e;
        }

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
