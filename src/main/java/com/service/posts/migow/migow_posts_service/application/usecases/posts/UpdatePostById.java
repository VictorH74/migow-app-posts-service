package com.service.posts.migow.migow_posts_service.application.usecases.posts;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.service.posts.migow.migow_posts_service.application.dtos.posts.UpdatePostDTO;
import com.service.posts.migow.migow_posts_service.domain.entities.Post;
import com.service.posts.migow.migow_posts_service.domain.interfaces.repositories.PostRepository;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.posts.UpdatePostByIdUseCase;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class UpdatePostById implements UpdatePostByIdUseCase {
    private final PostRepository postRepository;

    @Override
    public Post execute(UUID id, UpdatePostDTO obj) {
        Post post = new Post();
        post.setId(id);

        if (!obj.getText().isBlank())
            post.setText(obj.getText());

        if (!obj.getMediaList().isEmpty())
            post.setMediaList(obj.getMediaList());

        return postRepository.createUpdatePost(post);
    }

}
