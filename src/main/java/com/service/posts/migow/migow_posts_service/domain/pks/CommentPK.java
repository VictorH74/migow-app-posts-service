package com.service.posts.migow.migow_posts_service.domain.pks;

import java.io.Serializable;
import java.util.Objects;

import com.service.posts.migow.migow_posts_service.domain.entities.Post;
import com.service.posts.migow.migow_posts_service.domain.entities.User;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class CommentPK implements Serializable {
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, post);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        CommentPK other = (CommentPK) obj;
        return Objects.equals(user, other.user) && Objects.equals(post, other.post);
    }

}
