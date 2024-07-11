package com.service.posts.migow.migow_posts_service.application.interfaces.usecases.comments;

import java.util.UUID;

public interface DeleteCommentByIdUseCase {
    void execute(UUID id);
}
