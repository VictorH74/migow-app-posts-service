package com.service.posts.migow.migow_posts_service.infra.http.handlers;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ResponseErrorBody implements Serializable {
    private final String message;
    private final int status;
}
