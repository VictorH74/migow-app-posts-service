package com.service.posts.migow.migow_posts_service.application.usecases.posts;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.service.posts.migow.migow_posts_service.application.interfaces.repositories.PostRepository;
import com.service.posts.migow.migow_posts_service.application.interfaces.usecases.comments.GetCommentCountByPostIdUseCase;
import com.service.posts.migow.migow_posts_service.application.interfaces.usecases.posts.GetAllPostByUserIdUseCase;
import com.service.posts.migow.migow_posts_service.application.interfaces.usecases.reactions.GetReactionCoundByPostIdUseCase;
import com.service.posts.migow.migow_posts_service.application.interfaces.usecases.shared_posts.GetSharedPostCountByPostIdUseCase;
import com.service.posts.migow.migow_posts_service.infra.http.dtos.PostDTO;

@Component
public class GetAllPostByUserId implements GetAllPostByUserIdUseCase {

    private final PostRepository postRepository;
    private final GetReactionCoundByPostIdUseCase getReactionCoundByPostIdUseCase;
    private final GetCommentCountByPostIdUseCase getCommentCountByPostIdUseCase;
    private final GetSharedPostCountByPostIdUseCase getSharedPostCountByPostIdUseCase;

    public GetAllPostByUserId(PostRepository postRepository,
            GetReactionCoundByPostIdUseCase getReactionCoundByPostIdUseCase,
            GetCommentCountByPostIdUseCase getCommentCountByPostIdUseCase,
            GetSharedPostCountByPostIdUseCase getSharedPostCountByPostIdUseCase) {
        this.postRepository = postRepository;
        this.getReactionCoundByPostIdUseCase = getReactionCoundByPostIdUseCase;
        this.getCommentCountByPostIdUseCase = getCommentCountByPostIdUseCase;
        this.getSharedPostCountByPostIdUseCase = getSharedPostCountByPostIdUseCase;
    }

    @Override
    public Page<PostDTO> execute(UUID userId, Pageable pageable) {
        return postRepository.getAllPostByUserId(userId, pageable).map(post -> {
            UUID postId = post.getId();
            Long reactionCount = getReactionCoundByPostIdUseCase.execute(postId);
            Long commentCount = getCommentCountByPostIdUseCase.execute(postId);
            Long shareCount = getSharedPostCountByPostIdUseCase.execute(postId);
            PostDTO postDTO = (PostDTO) post;
            postDTO.setReactCount(reactionCount);
            postDTO.setCommentCount(commentCount);
            postDTO.setShareCount(shareCount);
            return postDTO;
        });
    }

}
