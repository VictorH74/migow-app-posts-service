package com.service.posts.migow.migow_posts_service.application.usecases.reply_comments;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.service.posts.migow.migow_posts_service.application.dtos.UserActivyDTO;
import com.service.posts.migow.migow_posts_service.application.dtos.reply_comments.CreateReplyCommentRequestDTO;
import com.service.posts.migow.migow_posts_service.application.dtos.reply_comments.SimpleReplyCommentDTO;
import com.service.posts.migow.migow_posts_service.domain.entities.Comment;
import com.service.posts.migow.migow_posts_service.domain.entities.ReplyComment;
import com.service.posts.migow.migow_posts_service.domain.entities.User;
import com.service.posts.migow.migow_posts_service.domain.interfaces.repositories.ReplyCommentRepository;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.comments.GetCommentByIdUseCase;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.reply_comments.CreateReplyCommentUseCase;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.users.GetUserByIdUseCase;

@Component
public class CreateReplyComment implements CreateReplyCommentUseCase {

    private final ReplyCommentRepository replyCommentRepository;
    private final GetUserByIdUseCase getUserByIdUseCase;
    private final GetCommentByIdUseCase getCommentByIdUseCase;

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public CreateReplyComment(ReplyCommentRepository replyCommentRepository,
            GetUserByIdUseCase getUserByIdUseCase,
            GetCommentByIdUseCase getCommentByIdUseCase,
            KafkaTemplate<String, Object> kafkaTemplate) {
        this.replyCommentRepository = replyCommentRepository;
        this.getUserByIdUseCase = getUserByIdUseCase;
        this.getCommentByIdUseCase = getCommentByIdUseCase;
        this.kafkaTemplate = kafkaTemplate;
    }

    @Value("${kafka.topic.replyCommentCreated}")
    private String replyCommentCreatedTopic;

    @Override
    public SimpleReplyCommentDTO execute(CreateReplyCommentRequestDTO obj) {
        Comment comment = getCommentByIdUseCase.execute(obj.getCommentId());

        User user = getUserByIdUseCase.execute(obj.getOwnerId());

        ReplyComment replyComment = new ReplyComment();
        replyComment.setOwner(user);
        replyComment.setComment(comment);
        replyComment.setContent(obj.getContent());

        ReplyComment createdReplyComment = replyCommentRepository.createUpdate(replyComment);

        UserActivyDTO userActivityData = new UserActivyDTO();
        userActivityData.setOwnerId(user.getId());
        userActivityData.setPostId(comment.getPostId());
        userActivityData.setReplyCommentId(createdReplyComment.getId());

        kafkaTemplate.send(replyCommentCreatedTopic, userActivityData);
        return new SimpleReplyCommentDTO(createdReplyComment);
    }

}
