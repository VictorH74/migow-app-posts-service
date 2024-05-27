package com.service.posts.migow.migow_posts_service.pks;

import java.io.Serializable;
import java.util.Objects;

import com.service.posts.migow.migow_posts_service.entities.Comment;
import com.service.posts.migow.migow_posts_service.entities.User;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class ReplyCommentPK implements Serializable {
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "comment_id")
    private Comment comment;

    public User getUser() {
        return user;
    }

    public Comment getComment() {
        return comment;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, comment);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        ReplyCommentPK other = (ReplyCommentPK) obj;
        return Objects.equals(user, other.user) && Objects.equals(comment, other.comment);
    }
}
