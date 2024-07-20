package com.service.posts.migow.migow_posts_service.application.usecases.posts;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.service.posts.migow.migow_posts_service.application.dtos.posts.PostResponseDTO;
import com.service.posts.migow.migow_posts_service.domain.interfaces.repositories.PostRepository;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.comments.GetCommentCountByPostIdUseCase;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.posts.GetAllPostByUserIdUseCase;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.shared_posts.GetSharedPostCountByPostIdUseCase;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class GetAllPostByUserId implements GetAllPostByUserIdUseCase {

    private final PostRepository postRepository;
    // private final GetReactionCoundByPostIdUseCase getReactionCoundByPostIdUseCase;
    private final GetCommentCountByPostIdUseCase getCommentCountByPostIdUseCase;
    private final GetSharedPostCountByPostIdUseCase getSharedPostCountByPostIdUseCase;

    @Override
    public Page<PostResponseDTO> execute(UUID userId, Pageable pageable) {
        return postRepository.getAllPostByUserId(userId, pageable).map(post -> {
            UUID postId = post.getId();
            // Long reactionCount = getReactionCoundByPostIdUseCase.execute(postId);
            Long commentCount = getCommentCountByPostIdUseCase.execute(postId);
            Long shareCount = getSharedPostCountByPostIdUseCase.execute(postId);
            PostResponseDTO postDTO = new PostResponseDTO(post, commentCount, commentCount, shareCount);
            postDTO.setReactCount(Integer.toUnsignedLong(0));
            // postDTO.setReactCount(reactionCount);
            postDTO.setCommentCount(commentCount);
            postDTO.setShareCount(shareCount);
            return postDTO;
        });
    }

}
