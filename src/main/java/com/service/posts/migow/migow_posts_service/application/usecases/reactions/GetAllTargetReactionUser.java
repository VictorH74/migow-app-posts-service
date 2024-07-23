package com.service.posts.migow.migow_posts_service.application.usecases.reactions;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.service.posts.migow.migow_posts_service.application.dtos.DateRangeFilter;
import com.service.posts.migow.migow_posts_service.application.dtos.users.SimpleUserDTO;
import com.service.posts.migow.migow_posts_service.domain.helpers.validators.ReactionTargetValidator;
import com.service.posts.migow.migow_posts_service.domain.interfaces.repositories.ReactionRepository;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.reactions.GetAllTargetReactionUserUseCase;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class GetAllTargetReactionUser implements GetAllTargetReactionUserUseCase {
    private final ReactionRepository repository;

    @Override
    public Page<SimpleUserDTO> execute(String target, String usernamePrefix, DateRangeFilter dateRangeFilter,
            Pageable pageable) {

        if (ReactionTargetValidator.validateString(target))
            return repository.getAllTargetReaction(
                    target,
                    usernamePrefix,
                    dateRangeFilter,
                    pageable)
                    .map(r -> new SimpleUserDTO(r.getOwner()));

        throw new IllegalArgumentException("Invalid target format!");
    }

}
