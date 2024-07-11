package com.service.posts.migow.migow_posts_service.application.interfaces.usecases.reactions;

import java.util.List;

import com.service.posts.migow.migow_posts_service.domain.entities.Reaction;

public interface CreateManyReactionUseCase {
    List<Reaction> execute(List<Reaction> objs);
}
