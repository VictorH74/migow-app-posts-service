package com.service.posts.migow.migow_posts_service.application.usecases.comments;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.service.posts.migow.migow_posts_service.application.dtos.UserActivyDTO;
import com.service.posts.migow.migow_posts_service.application.dtos.comments.CreateCommentDTO;
import com.service.posts.migow.migow_posts_service.domain.entities.Comment;
import com.service.posts.migow.migow_posts_service.domain.entities.User;
import com.service.posts.migow.migow_posts_service.domain.interfaces.repositories.CommentRepository;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.comments.CreateCommentUseCase;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.users.GetUserByIdUseCase;

@Component
public class CreateComment implements CreateCommentUseCase {

    private final CommentRepository commentRepository;
    private final GetUserByIdUseCase getUserByIdUseCase;

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public CreateComment(CommentRepository commentRepository,
            GetUserByIdUseCase getUserByIdUseCase,
            KafkaTemplate<String, Object> kafkaTemplate) {
        this.commentRepository = commentRepository;
        this.getUserByIdUseCase = getUserByIdUseCase;
        this.kafkaTemplate = kafkaTemplate;
    }

    @Value("${kafka.topic.commentCreated}")
    private String commentCreatedTopic;

    @Override
    public Comment execute(CreateCommentDTO obj) {
        User user = getUserByIdUseCase.execute(obj.getUserId());

        Comment comment = new Comment();
        comment.setContent(obj.getContent());
        comment.setOwner(user);
        comment.setPostId(obj.getPostId());

        Comment createdComment = commentRepository.createUpdate(comment);

        UserActivyDTO userActivityData = new UserActivyDTO();
        userActivityData.setOwnerId(user.getId());
        userActivityData.setPostId(comment.getPostId());
        userActivityData.setCommentId(comment.getId());

        kafkaTemplate.send(commentCreatedTopic, userActivityData);
        return createdComment;
    }

}
