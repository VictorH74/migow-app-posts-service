package com.service.posts.migow.migow_posts_service.application.usecases.posts;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.service.posts.migow.migow_posts_service.application.dtos.posts.PostResponseDTO;
import com.service.posts.migow.migow_posts_service.domain.interfaces.repositories.PostRepository;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.comments.GetCommentCountByPostIdUseCase;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.posts.GetAllRecentFriendPostUseCase;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.reactions.GetReactionCountByTargetIdUseCase;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.shared_posts.GetSharedPostCountByPostIdUseCase;

@Component
public class GetAllRecentFriendPost implements GetAllRecentFriendPostUseCase {
    private final PostRepository postRepository;

    private final GetReactionCountByTargetIdUseCase getReactionCountByTargetIdUseCase;
    private final GetCommentCountByPostIdUseCase getCommentCountByPostIdUseCase;
    private final GetSharedPostCountByPostIdUseCase getSharedPostCountByPostIdUseCase;

    public GetAllRecentFriendPost(PostRepository postRepository,
            GetReactionCountByTargetIdUseCase getReactionCountByTargetIdUseCase,
            GetCommentCountByPostIdUseCase getCommentCountByPostIdUseCase,
            GetSharedPostCountByPostIdUseCase getSharedPostCountByPostIdUseCase) {
        this.postRepository = postRepository;
        this.getReactionCountByTargetIdUseCase = getReactionCountByTargetIdUseCase;
        this.getCommentCountByPostIdUseCase = getCommentCountByPostIdUseCase;
        this.getSharedPostCountByPostIdUseCase = getSharedPostCountByPostIdUseCase;
    }

    @Override
    public Page<PostResponseDTO> execute(UUID userId, Pageable pageable) {
        return postRepository.getAllFriendRecentPost(userId, pageable).map(post -> {
            UUID postId = post.getId();
            Long reactionCount = getReactionCountByTargetIdUseCase.execute(postId, post.getClass());
            Long commentCount = getCommentCountByPostIdUseCase.execute(postId);
            Long shareCount = getSharedPostCountByPostIdUseCase.execute(postId);
            PostResponseDTO postDTO = new PostResponseDTO(post, commentCount, commentCount, shareCount);
            postDTO.setReactCount(reactionCount);
            postDTO.setCommentCount(commentCount);
            postDTO.setShareCount(shareCount);
            return postDTO;
        });
    }

}
