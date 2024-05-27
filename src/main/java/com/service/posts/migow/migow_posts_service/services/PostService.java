package com.service.posts.migow.migow_posts_service.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.service.posts.migow.migow_posts_service.DTOs.PostDTO;
import com.service.posts.migow.migow_posts_service.entities.Post;
import com.service.posts.migow.migow_posts_service.repositories.CommentRepository;
import com.service.posts.migow.migow_posts_service.repositories.PostRepository;
import com.service.posts.migow.migow_posts_service.repositories.PostShareActivityRecordRepository;
import com.service.posts.migow.migow_posts_service.repositories.ReactionRepository;

@Service
public class PostService {
    @Autowired
    PostRepository postRepository;
    @Autowired
    ReactionRepository reactionRepository;
    @Autowired
    CommentRepository commentRepository;
    @Autowired
    PostShareActivityRecordRepository postShareActivityRecordRepository;

    public Page<PostDTO> findAllByUserId(UUID userId, Pageable pageable) {
        return postRepository.findAllByUserId(userId, pageable).map(post -> {
            UUID postId = post.getId();
            Long reactionCount = reactionRepository.countByPostId(postId);
            Long commentCount = commentRepository.countByPostId(postId);
            Long shareCount = postShareActivityRecordRepository.countByPostId(postId);
            PostDTO postDTO = (PostDTO) post;
            postDTO.setReactCount(reactionCount);
            postDTO.setCommentCount(commentCount);
            postDTO.setShareCount(shareCount);
            return postDTO;
        });
    }

    public Post save(Post obj) {
        return postRepository.save(obj);
    }
}
