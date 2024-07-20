package com.service.posts.migow.migow_posts_service.application.dtos.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserCredentialsDTO {
    private String login; // email or username
    private String password;
}
