package com.service.posts.migow.migow_posts_service.infra.db.repositories.implementations;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.service.posts.migow.migow_posts_service.domain.entities.User;
import com.service.posts.migow.migow_posts_service.domain.interfaces.repositories.UserRepository;
import com.service.posts.migow.migow_posts_service.infra.db.repositories.jpa.JpaUserRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Repository
public class UserRepositoryImpl implements UserRepository {
    private final JpaUserRepository jpaUserRepository;

    @Override
    public List<User> createManyUser(List<User> objs) {
        return jpaUserRepository.saveAllAndFlush(objs);
    }

    @Override
    public User createUpdateUser(User obj) {
        return jpaUserRepository.save(obj);
    }

    @Override
    public void deleteUserById(UUID id) {
        jpaUserRepository.deleteById(id);
    }

    @Override
    public Optional<User> getUserById(UUID id) {
        return jpaUserRepository.findById(id);
    }

    @Override
    public Optional<User> getUserByUsername(String username) {
        return jpaUserRepository.findByUsername(username);
    }

}
