package com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.comments;

import java.util.UUID;

public interface GetCommentCountByPostIdUseCase {
    Long execute(UUID postId);
}
