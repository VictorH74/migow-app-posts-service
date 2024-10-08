package com.service.posts.migow.migow_posts_service.application.usecases.reactions;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.service.posts.migow.migow_posts_service.application.dtos.UserActivyDTO;
import com.service.posts.migow.migow_posts_service.application.dtos.reactions.CreateUpdateReactionDTO;
import com.service.posts.migow.migow_posts_service.application.dtos.reactions.SimpleReactionDTO;
import com.service.posts.migow.migow_posts_service.domain.entities.Comment;
import com.service.posts.migow.migow_posts_service.domain.entities.Reaction;
import com.service.posts.migow.migow_posts_service.domain.entities.ReplyComment;
import com.service.posts.migow.migow_posts_service.domain.entities.User;
import com.service.posts.migow.migow_posts_service.domain.enums.ReactionType;
import com.service.posts.migow.migow_posts_service.domain.helpers.validators.ReactionTargetValidator;
import com.service.posts.migow.migow_posts_service.domain.interfaces.repositories.ReactionRepository;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.comments.GetCommentByIdUseCase;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.reactions.CreateUpdateReactionUseCase;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.reply_comments.GetReplyCommentByIdUseCase;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.users.GetUserByIdUseCase;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class CreateUpdateReaction implements CreateUpdateReactionUseCase {

    private final ReactionRepository reactionRepository;
    private final GetUserByIdUseCase getUserByIdUseCase;
    private final GetCommentByIdUseCase getCommentByIdUseCase;
    private final GetReplyCommentByIdUseCase getReplyCommentByIdUseCase;

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public CreateUpdateReaction(ReactionRepository reactionRepository,
            GetUserByIdUseCase getUserByIdUseCase,
            GetCommentByIdUseCase getCommentByIdUseCase,
            GetReplyCommentByIdUseCase getReplyCommentByIdUseCase,
            KafkaTemplate<String, Object> kafkaTemplate) {
        this.reactionRepository = reactionRepository;
        this.getUserByIdUseCase = getUserByIdUseCase;
        this.getCommentByIdUseCase = getCommentByIdUseCase;
        this.getReplyCommentByIdUseCase = getReplyCommentByIdUseCase;
        this.kafkaTemplate = kafkaTemplate;
    }

    @Value("${kafka.topic.postReactionCreated}")
    private String postReactionCreatedTopic;
    @Value("${kafka.topic.commentReactionCreated}")
    private String commentReactionCreatedTopic;
    @Value("${kafka.topic.replyCommentReactionCreated}")
    private String replyCommentReactionCreatedTopic;

    @Override
    public SimpleReactionDTO execute(CreateUpdateReactionDTO obj) {

        String reactionType = obj.getTargetType() + obj.getTargetId();

        if (!ReactionTargetValidator.validateString(reactionType)) {
            throw new IllegalArgumentException("Invalid target string format!: " + reactionType);
        }

        User user = getUserByIdUseCase.execute(obj.getOwnerId());

        Reaction reaction = new Reaction();
        reaction.setOwner(user);
        reaction.setType(ReactionType.valueOf(obj.getType()).getCode());
        reaction.setTarget(reactionType);

        reaction.setId(obj.getId() == null ? UUID.randomUUID() : obj.getId());

        Reaction createdReaction = reactionRepository.createUpdate(reaction);

        log.info("reaction id", obj.getId());
        if (obj.getId() == null) {
            UserActivyDTO userActivityData = new UserActivyDTO();
            userActivityData.setOwnerId(user.getId());
            userActivityData.setReactionId(createdReaction.getId());

            String topic;
            UUID postId;

            log.info(obj.getTargetType());

            switch (obj.getTargetType()) {
                case "post_" -> {
                    log.info("post reaction");
                    postId = obj.getTargetId();
                    topic = postReactionCreatedTopic;
                }

                case "comment_" -> {
                    log.info("comment reaction");
                    Comment c = getCommentByIdUseCase.execute(obj.getTargetId());
                    postId = c.getPostId();
                    topic = commentReactionCreatedTopic;
                }
                case "reply_comment_" -> {
                    log.info("reply reaction");
                    ReplyComment rC = getReplyCommentByIdUseCase.execute(obj.getTargetId());
                    postId = rC.getComment().getPostId();
                    topic = replyCommentReactionCreatedTopic;
                }
                default -> {
                    throw new IllegalArgumentException("Invalid target string format!");
                }
            }

            userActivityData.setPostId(postId);
            kafkaTemplate.send(topic, userActivityData);
        }

        return new SimpleReactionDTO(createdReaction);
    }

}
