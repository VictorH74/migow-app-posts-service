package com.service.posts.migow.migow_posts_service.application.interfaces.usecases.followers;

import java.util.List;

import com.service.posts.migow.migow_posts_service.domain.entities.Follower;

public interface CreateManyFollowerUseCase {
    List<Follower> execute(List<Follower> objs);
}
