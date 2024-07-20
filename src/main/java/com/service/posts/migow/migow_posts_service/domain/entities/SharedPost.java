package com.service.posts.migow.migow_posts_service.domain.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import com.service.posts.migow.migow_posts_service.domain.entities.pks.SharedPostPK;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table(name="shared_posts")
@Getter
public class SharedPost implements Serializable {
    @EmbeddedId
    final private SharedPostPK id = new SharedPostPK();
    private Instant createdAt;

    public SharedPost() {
    }

    public SharedPost(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        SharedPost other = (SharedPost) obj;
        return Objects.equals(id, other.id);
    }

}
