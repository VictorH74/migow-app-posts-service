package com.service.posts.migow.migow_posts_service.infra.db.repositories.jpa;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.service.posts.migow.migow_posts_service.domain.entities.Reaction;

public interface JpaReactionRepository extends JpaRepository<Reaction, UUID> {
    @Query("SELECT COUNT(r) FROM Reaction r WHERE r.target = :target")
    long countByTarget(String target);

    @Query("SELECT r FROM Reaction r WHERE r.target = :target AND r.owner.username LIKE CONCAT(:usernamePrefix, '%') AND r.createdAt BETWEEN :startDate AND :endDate ORDER BY r.createdAt DESC")
    Page<Reaction> findAll(String target, String usernamePrefix, Instant startDate, Instant endDate, Pageable pageable);

    @Query("SELECT r FROM Reaction r WHERE r.target = :target AND r.owner.username LIKE CONCAT(:usernamePrefix, '%') AND r.type = :reactionTypeCode AND r.createdAt BETWEEN :startDate AND :endDate ORDER BY r.createdAt DESC")
    Page<Reaction> findAllByReactioType(String target, String usernamePrefix, int reactionTypeCode, Instant startDate, Instant endDate, Pageable pageable);

    @Query("SELECT COUNT(r) FROM Reaction r WHERE r.target = :target AND r.type = :reactionTypeCode")
    Long findCountByReactionType(String target, int reactionTypeCode);

    @Query("SELECT r FROM Reaction r WHERE r.owner.id = :ownerId AND r.target = :target")
    Optional<Reaction> findReactionByOwnerId(UUID ownerId, String target);

    @Query("DELETE FROM Reaction r WHERE r.target = :target")
    void deleteAllByTarget(String target);

}
