package com.service.posts.migow.migow_posts_service.application.interfaces.usecases.reactions;

import com.service.posts.migow.migow_posts_service.domain.entities.Reaction;

public interface CreateReactionUseCase {
    Reaction execute(Reaction obj);

}
