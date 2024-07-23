package com.service.posts.migow.migow_posts_service.domain.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "reactions")
@Getter
@Setter
@AllArgsConstructor
public class Reaction implements Serializable {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    private String target;
    private int type;
    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    private User owner;

    private Instant createdAt;

    public Reaction() {
        this.createdAt = Instant.now();
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
