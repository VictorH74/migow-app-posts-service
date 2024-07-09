package com.service.posts.migow.migow_posts_service.application.interfaces.usecases.comments;

import com.service.posts.migow.migow_posts_service.domain.entities.Comment;
import com.service.posts.migow.migow_posts_service.domain.pks.CommentPK;

public interface UpdateCommentByIdUseCase {
    Comment execute(CommentPK id, Comment obj);

}
