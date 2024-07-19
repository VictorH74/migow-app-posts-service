package com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.posts;

import java.util.List;

import com.service.posts.migow.migow_posts_service.domain.entities.Post;

public interface CreateManyPostUseCase {
    List<Post> execute(List<Post> objs);
}
