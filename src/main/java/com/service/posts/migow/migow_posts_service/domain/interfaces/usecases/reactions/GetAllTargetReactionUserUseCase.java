package com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.reactions;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.service.posts.migow.migow_posts_service.application.dtos.DateRangeFilter;
import com.service.posts.migow.migow_posts_service.application.dtos.users.ReactionSimpleUserDTO;

public interface GetAllTargetReactionUserUseCase {
    public Page<ReactionSimpleUserDTO> execute(String target, String usernamePrefix,  DateRangeFilter dateRangeFilter, Pageable pageable);
}
