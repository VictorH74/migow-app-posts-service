package com.service.posts.migow.migow_posts_service.domain.entities;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "reactions")
public class Reaction implements Serializable {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    private String target;
    private int type;
    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    private User owner;

    public Reaction() {
    }

    public Reaction(UUID id, String target, int type, User owner) {
        this.id = id;
        this.target = target;
        this.type = type;
        this.owner = owner;
    }

    public UUID getId() {
        return id;
    }

    public String getTarget() {
        return target;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setTarget(String target) {
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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

}
