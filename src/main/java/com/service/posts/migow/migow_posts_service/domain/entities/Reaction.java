package com.service.posts.migow.migow_posts_service.domain.entities;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

import com.service.posts.migow.migow_posts_service.domain.pks.ReactionTarget;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "db_reaction")
public class Reaction implements Serializable {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    @Embedded
    private ReactionTarget target;

    public Reaction() {
    }

    public Reaction(UUID id, ReactionTarget target) {
        this.id = id;
        this.target = target;
    }

    public UUID getId() {
        return id;
    }

    public ReactionTarget getTarget() {
        return target;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setTarget(ReactionTarget target) {
        this.target = target;
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
        Reaction other = (Reaction) obj;
        return Objects.equals(id, other.id);
    }

}
