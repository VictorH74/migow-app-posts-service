package com.service.posts.migow.migow_posts_service.application.usecases.posts;

import org.springframework.stereotype.Component;

import com.service.posts.migow.migow_posts_service.application.dtos.posts.CreatePostDTO;
import com.service.posts.migow.migow_posts_service.domain.entities.Post;
import com.service.posts.migow.migow_posts_service.domain.entities.User;
import com.service.posts.migow.migow_posts_service.domain.interfaces.repositories.PostRepository;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.posts.CreatePostUseCase;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.users.GetUserByIdUseCase;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class CreatePost implements CreatePostUseCase {
    private final PostRepository postRepository;
    private final GetUserByIdUseCase getUserByIdUseCase;

    @Override
    public Post execute(CreatePostDTO obj) {
        User user = getUserByIdUseCase.execute(obj.getOwnerId());
        Post post = new Post();

        post.setOwner(user);
        post.setText(obj.getText());
        post.setMediaList(obj.getMediaList());
        post.setSharedPost(obj.getSharedPost());

        return postRepository.createUpdatePost(post);
    }
}
