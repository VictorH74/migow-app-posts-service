package com.service.posts.migow.migow_posts_service.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.service.posts.migow.migow_posts_service.entities.Comment;
import com.service.posts.migow.migow_posts_service.repositories.CommentRepository;

@Service
public class CommentService {
    @Autowired
    CommentRepository commentRepository;

    public Page<Comment> findAllCommentByPostId(UUID postId, Pageable pageable) {
        return commentRepository.findAllCommentByPostId(postId, pageable);
    }
}
