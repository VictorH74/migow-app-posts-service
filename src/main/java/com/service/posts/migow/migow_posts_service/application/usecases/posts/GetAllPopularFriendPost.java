package com.service.posts.migow.migow_posts_service.application.usecases.posts;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.service.posts.migow.migow_posts_service.application.dtos.DateRangeFilter;
import com.service.posts.migow.migow_posts_service.application.dtos.posts.PostResponseDTO;
import com.service.posts.migow.migow_posts_service.application.dtos.reactions.ReactionCountByTypeDTO;
import com.service.posts.migow.migow_posts_service.application.dtos.reactions.SimpleReactionDTO;
import com.service.posts.migow.migow_posts_service.domain.entities.Reaction;
import com.service.posts.migow.migow_posts_service.domain.interfaces.repositories.PostRepository;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.comments.GetCommentCountByPostIdUseCase;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.posts.GetAllPopularFriendPostUseCase;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.posts.GetPostShareCountUseCase;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.reactions.GetReactionByOwnerIdUseCase;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.reactions.GetTargetReactionTypeCountsUseCase;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class GetAllPopularFriendPost implements GetAllPopularFriendPostUseCase {

    private final PostRepository postRepository;

    private final GetTargetReactionTypeCountsUseCase getTargetReactionTypeCountsUseCase;
    private final GetCommentCountByPostIdUseCase getCommentCountByPostIdUseCase;
    private final GetPostShareCountUseCase getPostShareCountUseCase;
    private final GetReactionByOwnerIdUseCase getReactionByOwnerIdUseCase;

    @Override
    public Page<PostResponseDTO> execute(UUID userId, DateRangeFilter dateRangeFilter, Pageable pageable) {
        return postRepository.getAllFriendPopularPost(userId, dateRangeFilter, pageable).map(post -> {
            UUID postId = post.getId();
            ReactionCountByTypeDTO reactionCountByTypeDTO = getTargetReactionTypeCountsUseCase.execute(post.getId(),
                    "post_");

            Long reactionCount = reactionCountByTypeDTO.reactionTotal();
            Long commentCount = getCommentCountByPostIdUseCase.execute(postId);
            Long shareCount = getPostShareCountUseCase.execute(postId);

            Optional<Reaction> reaction = getReactionByOwnerIdUseCase.execute(userId, "post_" + post.getId());

            PostResponseDTO postDTO = new PostResponseDTO(post, commentCount, commentCount, shareCount);
            postDTO.setReactCount(reactionCount);
            postDTO.setCommentCount(commentCount);
            postDTO.setShareCount(shareCount);
            postDTO.setReactionCountByType(reactionCountByTypeDTO);

            if (reaction.isPresent()) {
                postDTO.setCurrentUserReaction(new SimpleReactionDTO(reaction.get()));
            }

            return postDTO;
        });
    }
}
