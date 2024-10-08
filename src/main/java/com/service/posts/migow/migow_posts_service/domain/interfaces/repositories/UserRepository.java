package com.service.posts.migow.migow_posts_service.domain.interfaces.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.service.posts.migow.migow_posts_service.domain.entities.User;

public interface UserRepository {

    List<User> createMany(List<User> objs);

    User createUpdate(User obj);

    Optional<User> getById(UUID id);

    Optional<User> getByUsername(String username);

    void deleteById(UUID id);
}
