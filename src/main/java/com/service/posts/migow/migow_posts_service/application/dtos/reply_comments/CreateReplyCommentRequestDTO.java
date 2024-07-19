package com.service.posts.migow.migow_posts_service.application.dtos.reply_comments;

import java.util.UUID;

public class CreateReplyCommentRequestDTO {
    private UUID postId;
    private String content;

    public CreateReplyCommentRequestDTO(UUID postId, String content) {
        this.content = content;
        this.postId = postId;
    }

    public UUID getPostId() {
        return postId;
    }

    public String getContent() {
        return content;
    }

    public void setPostId(UUID postId) {
        this.postId = postId;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
