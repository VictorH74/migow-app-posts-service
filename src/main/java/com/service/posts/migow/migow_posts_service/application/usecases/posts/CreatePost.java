package com.service.posts.migow.migow_posts_service.application.usecases.posts;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.service.posts.migow.migow_posts_service.application.dtos.UserActivyDTO;
import com.service.posts.migow.migow_posts_service.application.dtos.posts.CreatePostDTO;
import com.service.posts.migow.migow_posts_service.domain.entities.Post;
import com.service.posts.migow.migow_posts_service.domain.entities.User;
import com.service.posts.migow.migow_posts_service.domain.interfaces.repositories.PostRepository;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.posts.CreatePostUseCase;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.users.GetUserByIdUseCase;

import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
public class CreatePost implements CreatePostUseCase {

    private final PostRepository postRepository;
    private final GetUserByIdUseCase getUserByIdUseCase;

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public CreatePost(PostRepository postRepository,
            GetUserByIdUseCase getUserByIdUseCase,
            KafkaTemplate<String, Object> kafkaTemplate) {
        this.postRepository = postRepository;
        this.getUserByIdUseCase = getUserByIdUseCase;
        this.kafkaTemplate = kafkaTemplate;
    }

    @Value("${kafka.topic.postCreated}")
    private String postCreatedTopic;
    @Value("${kafka.topic.sharedPostCreated}")
    private String sharedPostCreatedTopic;

    @Override
    public Post execute(CreatePostDTO obj) {
        User user = getUserByIdUseCase.execute(obj.getOwnerId());
        Post post = new Post();
        String topic;

        post.setOwner(user);
        post.setText(obj.getText());
        post.setMediaList(obj.getMediaList());

        if (obj.getSharedPost() != null) {
            Post sharedPost = new Post();
            sharedPost.setId(obj.getSharedPost());
            post.setSharedPost(sharedPost);
            topic = sharedPostCreatedTopic;
        } else {
            topic = postCreatedTopic;
        }

        Post createdPost = postRepository.createUpdate(post);

        log.info("created post: " + createdPost.toString());

        UserActivyDTO userActivityData = new UserActivyDTO();
        userActivityData.setOwnerId(user.getId());
        userActivityData.setPostId(createdPost.getId());

        kafkaTemplate.send(topic, userActivityData);
        return createdPost;
    }
}
