package com.service.posts.migow.migow_posts_service.application.usecases.posts;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.service.posts.migow.migow_posts_service.domain.interfaces.repositories.PostRepository;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.posts.GetPostShareCountUseCase;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class GetPostShareCount implements GetPostShareCountUseCase {

    private final PostRepository postRepository;

    @Override
    public Long execute(UUID id) {
        return postRepository.getShareCount(id);
    }

}
