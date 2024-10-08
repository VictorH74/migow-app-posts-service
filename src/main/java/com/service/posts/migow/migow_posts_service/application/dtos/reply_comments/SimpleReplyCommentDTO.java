package com.service.posts.migow.migow_posts_service.application.dtos.reply_comments;

import java.time.Instant;
import java.util.UUID;

import com.service.posts.migow.migow_posts_service.application.dtos.reactions.ReactionCountByTypeDTO;
import com.service.posts.migow.migow_posts_service.application.dtos.users.SimpleUserDTO;
import com.service.posts.migow.migow_posts_service.domain.entities.ReplyComment;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SimpleReplyCommentDTO {

    private UUID id;
    private SimpleUserDTO owner;
    private UUID comment;
    private String content;
    private Instant createdAt;
    private Long reactCount;
    private ReactionCountByTypeDTO reactionCountByType;

    public SimpleReplyCommentDTO(ReplyComment replyComment) {
        this.id = replyComment.getId();
        this.owner = new SimpleUserDTO(replyComment.getOwner());
        this.comment = replyComment.getComment().getId();
        this.content = replyComment.getContent();
        this.createdAt = replyComment.getCreatedAt();
    }

}
