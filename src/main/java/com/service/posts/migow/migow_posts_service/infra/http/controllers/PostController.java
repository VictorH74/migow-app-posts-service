package com.service.posts.migow.migow_posts_service.infra.http.controllers;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.service.posts.migow.migow_posts_service.application.dtos.DateRangeFilter;
import com.service.posts.migow.migow_posts_service.application.dtos.posts.CreatePostDTO;
import com.service.posts.migow.migow_posts_service.application.dtos.posts.PostResponseDTO;
import com.service.posts.migow.migow_posts_service.application.dtos.posts.UpdatePostDTO;
import com.service.posts.migow.migow_posts_service.domain.entities.Post;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.posts.CreatePostUseCase;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.posts.DeletePostByIdUseCase;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.posts.GetAllPopularFriendPostUseCase;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.posts.GetAllRecentFriendPostUseCase;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.posts.GetPostByIdUseCase;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.posts.UpdatePostByIdUseCase;

import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/posts")
@AllArgsConstructor
@Log4j2
public class PostController {

    private final GetPostByIdUseCase getPostByIdUseCase;
    private final GetAllRecentFriendPostUseCase getAllRecentFriendPostUseCase;
    private final GetAllPopularFriendPostUseCase getAllPopularFriendPostUseCase;
    private final CreatePostUseCase createPostUseCase;
    private final UpdatePostByIdUseCase updatePostByIdUseCase;
    private final DeletePostByIdUseCase deletePostByIdUseCase;

    @GetMapping("/recent")
    public Page<PostResponseDTO> getAllRecentFriendPost(
            @RequestParam(name = "startDate", defaultValue = "") String startDate,
            @RequestParam(name = "endDate", defaultValue = "") String endDate,
            @RequestParam(name = "pageNumber", defaultValue = "0") int pageNumber,
            @RequestParam(name = "pageSize", defaultValue = "15") int pageSize,
            HttpServletRequest request) {
        UUID userId = UUID.fromString(request.getHeader("userId"));

        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        DateRangeFilter dateRangeFilter = DateRangeFilter.of(startDate, endDate);
        return this.getAllRecentFriendPostUseCase.execute(userId, dateRangeFilter, pageable);

    }

    @GetMapping("/popular")
    public Page<PostResponseDTO> getAllPopularFriendPost(
            @RequestParam(name = "startDate", defaultValue = "") String startDate,
            @RequestParam(name = "endDate", defaultValue = "") String endDate,
            @RequestParam(name = "pageNumber", defaultValue = "0") int pageNumber,
            @RequestParam(name = "pageSize", defaultValue = "15") int pageSize,
            HttpServletRequest request) {
        UUID userId = UUID.fromString(request.getHeader("userId"));

        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        DateRangeFilter dateRangeFilter = DateRangeFilter.of(startDate, endDate);
        return this.getAllPopularFriendPostUseCase.execute(userId, dateRangeFilter, pageable);
    }

    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody CreatePostDTO obj,
            HttpServletRequest request) {
        UUID userId = UUID.fromString(request.getHeader("userId"));

        obj.setOwnerId(userId);
        Post post = createPostUseCase.execute(obj);

        return ResponseEntity.status(HttpStatus.CREATED).body(post);
    }

    @GetMapping("/{postId}")
    public PostResponseDTO getPostById(@PathVariable UUID postId) {
        return getPostByIdUseCase.execute(postId);
    }

    @PatchMapping("/{postId}")
    public Post updatePost(@PathVariable UUID postId, @RequestBody UpdatePostDTO obj) {
        // TODO: provide created entity to kafka
        return updatePostByIdUseCase.execute(postId, obj);
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<String> deletePost(@PathVariable UUID postId) {
        deletePostByIdUseCase.execute(postId);
        // TODO: provide created entity to kafka
        return ResponseEntity.status(HttpStatus.OK).body(String.format("Post with id '%s' deleted!", postId));
    }

}
