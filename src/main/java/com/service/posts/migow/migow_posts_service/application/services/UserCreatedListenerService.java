// package com.service.posts.migow.migow_posts_service.application.services;

// import org.springframework.kafka.annotation.KafkaListener;
// import org.springframework.stereotype.Service;

// import com.fasterxml.jackson.core.JsonProcessingException;
// import com.fasterxml.jackson.databind.JsonMappingException;
// import com.service.posts.migow.migow_posts_service.domain.interfaces.repositories.UserRepository;

// import lombok.AllArgsConstructor;
// import lombok.extern.log4j.Log4j2;

// @Service
// @AllArgsConstructor
// @Log4j2
// public class UserCreatedListenerService {

//     private final UserRepository userRepository;
//     // ObjectMapper objectMapper = new ObjectMapper();

//     @KafkaListener(topics = "#{'${kafka.topic.userCreated}'}", groupId = "#{'${spring.kafka.consumer.group-id}'}")
//     public void consume(String message) throws JsonMappingException, JsonProcessingException {
//         log.info(message);

//         // User createdUser = objectMapper.readValue(message, User.class);
//         // userRepository.createUpdateUser(createdUser);
//     }
// }
