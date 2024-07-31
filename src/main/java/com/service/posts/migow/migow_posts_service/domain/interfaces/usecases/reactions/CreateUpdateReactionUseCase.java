package com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.reactions;

import com.service.posts.migow.migow_posts_service.application.dtos.reactions.CreateUpdateReactionDTO;
import com.service.posts.migow.migow_posts_service.application.dtos.reactions.SimpleReactionDTO;

public interface CreateUpdateReactionUseCase {
    SimpleReactionDTO execute(CreateUpdateReactionDTO obj);

}
