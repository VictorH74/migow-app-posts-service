package com.service.posts.migow.migow_posts_service.application.usecases.posts;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.service.posts.migow.migow_posts_service.application.dtos.posts.PostResponseDTO;
import com.service.posts.migow.migow_posts_service.application.dtos.reactions.ReactionCountByTypeDTO;
import com.service.posts.migow.migow_posts_service.domain.entities.Post;
import com.service.posts.migow.migow_posts_service.domain.interfaces.repositories.PostRepository;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.comments.GetCommentCountByPostIdUseCase;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.posts.GetPostByIdUseCase;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.posts.GetPostShareCountUseCase;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.reactions.GetTargetReactionTypeCountsUseCase;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class GetPostById implements GetPostByIdUseCase {

    private final PostRepository postRepository;
    private final GetTargetReactionTypeCountsUseCase getTargetReactionTypeCountsUseCase;
    private final GetCommentCountByPostIdUseCase getCommentCountByPostIdUseCase;
    private final GetPostShareCountUseCase getPostShareCountUseCase;

    @Override
    public PostResponseDTO execute(UUID id) {
        // TODO: impl not found error
        Post post = postRepository.getById(id).get();

        UUID postId = post.getId();
        ReactionCountByTypeDTO reactionCountByTypeDTO = getTargetReactionTypeCountsUseCase.execute(post.getId(),
                "post_");

        Long reactionCount = reactionCountByTypeDTO.reactionTotal();
        Long commentCount = getCommentCountByPostIdUseCase.execute(postId);
        Long shareCount = getPostShareCountUseCase.execute(postId);

        PostResponseDTO postDTO = new PostResponseDTO(post, commentCount, commentCount, shareCount);
        postDTO.setReactCount(reactionCount);
        postDTO.setCommentCount(commentCount);
        postDTO.setShareCount(shareCount);
        postDTO.setReactionCountByType(reactionCountByTypeDTO);

        return postDTO;
    }

}
