package com.service.posts.migow.migow_posts_service.infra.configs;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;

@Configuration
public class KafkaTopicConfig {

    @Value("${kafka.topic.postCreated}")
    private String postCreatedTopic;

    @Value("${kafka.topic.commentCreated}")
    private String commentCreatedTopic;

    @Value("${kafka.topic.replyCommentCreated}")
    private String replyCommentCreatedTopic;

    @Value("${kafka.topic.postReactionCreated}")
    private String postReactionCreatedTopic;

    @Value("${kafka.topic.commentReactionCreated}")
    private String commentReactionCreatedTopic;

    @Value("${kafka.topic.replyCommentReactionCreated}")
    private String replyCommentReactionCreatedTopic;

    @Value("${kafka.topic.sharedPostCreated}")
    private String sharedPostCreatedTopic;

    @Value("${kafka.topic.postDeleted}")
    private String postDeletedTopic;

    @Value("${kafka.topic.commentDeleted}")
    private String commentDeletedTopic;

    @Value("${kafka.topic.replyCommentDeleted}")
    private String replyCommentDeletedTopic;

    @Value("${kafka.topic.reactionDeleted}")
    private String reactionDeletedTopic;

    @Value(value = "${spring.kafka.bootstrap-servers}")
    private String bootstrapAddress;

    @Bean
    public KafkaAdmin kafkaAdmin() {
        Map<String, Object> configs = new HashMap<>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        return new KafkaAdmin(configs);
    }

    @Bean
    public NewTopic topic1() {
        return new NewTopic(postCreatedTopic, 1, (short) 1);
    }

    @Bean
    public NewTopic topic2() {
        return new NewTopic(commentCreatedTopic, 1, (short) 1);
    }

    @Bean
    public NewTopic topic3() {
        return new NewTopic(replyCommentCreatedTopic, 1, (short) 1);
    }

    @Bean
    public NewTopic topic4() {
        return new NewTopic(postReactionCreatedTopic, 1, (short) 1);
    }

    @Bean
    public NewTopic topic5() {
        return new NewTopic(commentReactionCreatedTopic, 1, (short) 1);
    }

    @Bean
    public NewTopic topic6() {
        return new NewTopic(replyCommentReactionCreatedTopic, 1, (short) 1);
    }

    @Bean
    public NewTopic topic11() {
        return new NewTopic(sharedPostCreatedTopic, 1, (short) 1);
    }

    @Bean
    public NewTopic topic7() {
        return new NewTopic(postDeletedTopic, 1, (short) 1);
    }

    @Bean
    public NewTopic topic8() {
        return new NewTopic(commentDeletedTopic, 1, (short) 1);
    }

    @Bean
    public NewTopic topic9() {
        return new NewTopic(replyCommentDeletedTopic, 1, (short) 1);
    }

    @Bean
    public NewTopic topic10() {
        return new NewTopic(reactionDeletedTopic, 1, (short) 1);
    }
}
