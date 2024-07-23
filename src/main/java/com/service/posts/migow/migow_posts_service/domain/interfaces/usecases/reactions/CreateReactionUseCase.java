package com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.reactions;

import com.service.posts.migow.migow_posts_service.application.dtos.reactions.CreateReactionDTO;
import com.service.posts.migow.migow_posts_service.application.dtos.reactions.SimpleReactionDTO;

public interface CreateReactionUseCase {
    SimpleReactionDTO execute(CreateReactionDTO obj);

}
