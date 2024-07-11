package com.service.posts.migow.migow_posts_service.infra.db.repositories.jpa;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.service.posts.migow.migow_posts_service.domain.entities.User;

public interface JpaUserRepository extends JpaRepository<User, UUID> {
    public Optional<User> findByUsername(String username);
}
