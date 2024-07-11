package com.service.posts.migow.migow_posts_service.application.usecases.posts;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.service.posts.migow.migow_posts_service.application.interfaces.repositories.PostRepository;
import com.service.posts.migow.migow_posts_service.application.interfaces.usecases.comments.GetCommentCountByPostIdUseCase;
import com.service.posts.migow.migow_posts_service.application.interfaces.usecases.posts.GetAllFollowedUserPostUseCase;
import com.service.posts.migow.migow_posts_service.application.interfaces.usecases.shared_posts.GetSharedPostCountByPostIdUseCase;
import com.service.posts.migow.migow_posts_service.infra.http.dtos.posts.PostResponseDTO;

@Component
public class GetAllFollowedUserPost implements GetAllFollowedUserPostUseCase {
    private final PostRepository postRepository;
    // private final GetReactionCoundByPostIdUseCase
    // getReactionCoundByPostIdUseCase;
    private final GetCommentCountByPostIdUseCase getCommentCountByPostIdUseCase;
    private final GetSharedPostCountByPostIdUseCase getSharedPostCountByPostIdUseCase;

    public GetAllFollowedUserPost(PostRepository postRepository,
            // GetReactionCoundByPostIdUseCase ctionCoundByPostIdUseCase,
            GetCommentCountByPostIdUseCase getCommentCountByPostIdUseCase,
            GetSharedPostCountByPostIdUseCase getSharedPostCountByPostIdUseCase) {
        this.postRepository = postRepository;
        // this.ctionCoundByPostIdUseCase = ctionCoundByPostIdUseCase;
        this.getCommentCountByPostIdUseCase = getCommentCountByPostIdUseCase;
        this.getSharedPostCountByPostIdUseCase = getSharedPostCountByPostIdUseCase;
    }

    @Override
    public Page<PostResponseDTO> execute(UUID followerId, Pageable pageable) {
        return postRepository.getAllFollowedUserPost(followerId, pageable).map(post -> {
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
