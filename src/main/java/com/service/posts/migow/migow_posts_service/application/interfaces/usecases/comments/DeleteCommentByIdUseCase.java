package com.service.posts.migow.migow_posts_service.application.interfaces.usecases.comments;

import com.service.posts.migow.migow_posts_service.domain.pks.CommentPK;

public interface DeleteCommentByIdUseCase {
    void execute(CommentPK id);

}
