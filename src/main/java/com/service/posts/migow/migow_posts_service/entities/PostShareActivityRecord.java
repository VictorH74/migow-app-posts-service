package com.service.posts.migow.migow_posts_service.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import com.service.posts.migow.migow_posts_service.pks.PostShareActivityRecordPK;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "db_post_share_activity_record")
public class PostShareActivityRecord implements Serializable {
    final private PostShareActivityRecordPK id = new PostShareActivityRecordPK();
    private Instant createdAt;

    public PostShareActivityRecord() {
    }

    public PostShareActivityRecord(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public PostShareActivityRecordPK getId() {
        return id;
    }

    public Instant getCreatedAt() {
        return createdAt;
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
        PostShareActivityRecord other = (PostShareActivityRecord) obj;
        return Objects.equals(id, other.id);
    }

}
