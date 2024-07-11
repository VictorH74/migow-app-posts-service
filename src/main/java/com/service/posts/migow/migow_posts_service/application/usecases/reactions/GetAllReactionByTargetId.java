package com.service.posts.migow.migow_posts_service.application.usecases.reactions;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.service.posts.migow.migow_posts_service.application.interfaces.repositories.ReactionRepository;
import com.service.posts.migow.migow_posts_service.application.interfaces.usecases.reactions.GetAllReactionByTargetIdUseCase;
import com.service.posts.migow.migow_posts_service.domain.entities.Comment;
import com.service.posts.migow.migow_posts_service.domain.entities.Post;
import com.service.posts.migow.migow_posts_service.domain.entities.Reaction;
import com.service.posts.migow.migow_posts_service.domain.entities.ReplyComment;

public class GetAllReactionByTargetId implements GetAllReactionByTargetIdUseCase {
    private final ReactionRepository reactionRepository;

    public GetAllReactionByTargetId(ReactionRepository reactionRepository) {
        this.reactionRepository = reactionRepository;
    }

    @Override
    public Page<Reaction> execute(UUID targetId, Class<?> targetClass, Pageable pageable) {
        String target;

        if (targetClass == Post.class) {
            target = "post_" + targetId;
        } else if (targetClass == Comment.class) {
            target = "comment_" + targetId;
        } else if (targetClass == ReplyComment.class) {
            target = "reply_comment_" + targetId;
        } else {
            // TODO: implement http exception
            throw new IllegalArgumentException("Invalid target class!");
        }

        return reactionRepository.getAllReactionByTarget(target, pageable);
    }

}
