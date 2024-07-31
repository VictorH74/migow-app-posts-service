package com.service.posts.migow.migow_posts_service.application.usecases.posts;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.service.posts.migow.migow_posts_service.application.dtos.DateRangeFilter;
import com.service.posts.migow.migow_posts_service.application.dtos.posts.PostResponseDTO;
import com.service.posts.migow.migow_posts_service.application.dtos.reactions.ReactionTypeCountsDTO;
import com.service.posts.migow.migow_posts_service.application.dtos.reactions.SimpleReactionDTO;
import com.service.posts.migow.migow_posts_service.domain.entities.Reaction;
import com.service.posts.migow.migow_posts_service.domain.interfaces.repositories.PostRepository;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.comments.GetCommentCountByPostIdUseCase;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.posts.GetAllPostByUserIdUseCase;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.reactions.GetReactionByOwnerIdUseCase;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.reactions.GetTargetReactionTypeCountsUseCase;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.shared_posts.GetSharedPostCountByPostIdUseCase;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class GetAllPostByUserId implements GetAllPostByUserIdUseCase {
    private final PostRepository postRepository;

    private final GetTargetReactionTypeCountsUseCase getTargetReactionTypeCountsUseCase;
    private final GetCommentCountByPostIdUseCase getCommentCountByPostIdUseCase;
    private final GetSharedPostCountByPostIdUseCase getSharedPostCountByPostIdUseCase;
    private final GetReactionByOwnerIdUseCase getReactionByOwnerIdUseCase;

    @Override
    public Page<PostResponseDTO> execute(UUID userId, DateRangeFilter dateRangeFilter, Pageable pageable) {
        return postRepository.getAllPostByUserId(userId, dateRangeFilter, pageable).map(post -> {
            UUID postId = post.getId();
            ReactionTypeCountsDTO reactionTypeCountsDTO = getTargetReactionTypeCountsUseCase.execute(post.getId(),
                    "post_");

            Long reactionCount = reactionTypeCountsDTO.reactionTotal();
            Long commentCount = getCommentCountByPostIdUseCase.execute(postId);
            Long shareCount = getSharedPostCountByPostIdUseCase.execute(postId);

            Optional<Reaction> reaction = getReactionByOwnerIdUseCase.execute(userId, "post_" + post.getId());

            PostResponseDTO postDTO = new PostResponseDTO(post, commentCount, commentCount, shareCount);
            postDTO.setReactCount(reactionCount);
            postDTO.setCommentCount(commentCount);
            postDTO.setShareCount(shareCount);
            postDTO.setReactionTypeCounts(reactionTypeCountsDTO);

            if (reaction.isPresent())
                postDTO.setCurrentUserReaction(new SimpleReactionDTO(reaction.get()));

            return postDTO;
        });
    }

}
