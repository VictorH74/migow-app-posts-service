package com.service.posts.migow.migow_posts_service.application.usecases.posts;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.service.posts.migow.migow_posts_service.application.dtos.DateRangeFilter;
import com.service.posts.migow.migow_posts_service.application.dtos.posts.PostResponseDTO;
import com.service.posts.migow.migow_posts_service.application.dtos.reactions.ReactionTypeCountsDTO;
import com.service.posts.migow.migow_posts_service.domain.interfaces.repositories.PostRepository;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.comments.GetCommentCountByPostIdUseCase;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.posts.GetAllRecentFriendPostUseCase;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.reactions.GetTargetReactionTypeCountsUseCase;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.shared_posts.GetSharedPostCountByPostIdUseCase;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class GetAllRecentFriendPost implements GetAllRecentFriendPostUseCase {
    private final PostRepository postRepository;

    private final GetTargetReactionTypeCountsUseCase getTargetReactionTypeCountsUseCase;
    private final GetCommentCountByPostIdUseCase getCommentCountByPostIdUseCase;
    private final GetSharedPostCountByPostIdUseCase getSharedPostCountByPostIdUseCase;

    @Override
    public Page<PostResponseDTO> execute(UUID userId, DateRangeFilter dateRangeFilter, Pageable pageable) {
        return postRepository.getAllFriendRecentPost(userId, dateRangeFilter, pageable).map(post -> {
            UUID postId = post.getId();
            ReactionTypeCountsDTO reactionTypeCountsDTO = getTargetReactionTypeCountsUseCase.execute(post.getId(),
                    "post_");

            Long reactionCount = reactionTypeCountsDTO.reactionTotal();
            Long commentCount = getCommentCountByPostIdUseCase.execute(postId);
            Long shareCount = getSharedPostCountByPostIdUseCase.execute(postId);

            PostResponseDTO postDTO = new PostResponseDTO(post, commentCount, commentCount, shareCount);
            postDTO.setReactCount(reactionCount);
            postDTO.setCommentCount(commentCount);
            postDTO.setShareCount(shareCount);
            postDTO.setReactionTypeCounts(reactionTypeCountsDTO);
            return postDTO;
        });
    }

}
