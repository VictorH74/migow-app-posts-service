package com.service.posts.migow.migow_posts_service.application.usecases.reactions;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.service.posts.migow.migow_posts_service.application.dtos.DateRangeFilter;
import com.service.posts.migow.migow_posts_service.application.dtos.users.ReactionSimpleUserDTO;
import com.service.posts.migow.migow_posts_service.domain.enums.ReactionType;
import com.service.posts.migow.migow_posts_service.domain.helpers.validators.ReactionTargetValidator;
import com.service.posts.migow.migow_posts_service.domain.interfaces.repositories.ReactionRepository;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.reactions.GetAllTargetReactionUserByReactionTypeUseCase;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class GetAllTargetReactionUserByReactionType implements GetAllTargetReactionUserByReactionTypeUseCase {
    private final ReactionRepository repository;

    @Override
    public Page<ReactionSimpleUserDTO> execute(String target, String usernamePrefix, int reactionTypeCode,
            DateRangeFilter dateRangeFilter, Pageable pageable) {
        if (ReactionTargetValidator.validateString(target))
            return repository.getAllTargetReactionByReactionType(target,
                    usernamePrefix,
                    ReactionType.valueOf(reactionTypeCode).getCode(),
                    dateRangeFilter, pageable)
                    .map(r -> new ReactionSimpleUserDTO(r.getOwner(), r.getType()));

        throw new IllegalArgumentException("Invalid target format!");
    }

}
