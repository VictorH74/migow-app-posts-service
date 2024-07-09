package com.service.posts.migow.migow_posts_service.domain.pks;

import java.util.Objects;
import java.util.UUID;

public class ReactionTarget {
    private UUID postId;
    private CommentPK commentId;

    public UUID getPostId() {
        return postId;
    }

    public CommentPK getCommentId() {
        return commentId;
    }

    public void setPostId(UUID postId) {
        this.postId = postId;
    }

    public void setCommentId(CommentPK commentId) {
        this.commentId = commentId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(postId, commentId);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ReactionTarget other = (ReactionTarget) obj;
        return Objects.equals(postId, other.postId) && Objects.equals(commentId, other.commentId);
    }

}
