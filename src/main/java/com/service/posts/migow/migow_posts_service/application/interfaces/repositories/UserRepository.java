package com.service.posts.migow.migow_posts_service.application.interfaces.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.service.posts.migow.migow_posts_service.domain.entities.User;

public interface UserRepository {
    List<User> createManyUser(List<User> objs);

    Page<User> getAllUser(Pageable pageable);

    User createUpdateUser(User obj);

    Optional<User> getUserById(UUID id);

    Optional<User> getUserByUsername(String username);

    void deleteUserById(UUID id);
}
