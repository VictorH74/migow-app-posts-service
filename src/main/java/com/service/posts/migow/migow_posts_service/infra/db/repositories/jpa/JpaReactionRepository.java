package com.service.posts.migow.migow_posts_service.infra.db.repositories.jpa;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.service.posts.migow.migow_posts_service.domain.entities.Reaction;

public interface JpaReactionRepository extends JpaRepository<Reaction, UUID> {
    @Query("SELECT COUNT(r) FROM Reaction r WHERE r.target = :target")
    long countByTarget(String target);

    @Query("SELECT r FROM Reaction r WHERE r.target = :target")
    Page<Reaction> findAllByTarget(String target, Pageable pageable);

}
