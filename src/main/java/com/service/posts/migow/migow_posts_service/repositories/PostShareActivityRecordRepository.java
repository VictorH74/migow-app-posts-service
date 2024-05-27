package com.service.posts.migow.migow_posts_service.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.service.posts.migow.migow_posts_service.entities.PostShareActivityRecord;
import com.service.posts.migow.migow_posts_service.pks.PostShareActivityRecordPK;

public interface PostShareActivityRecordRepository
                extends JpaRepository<PostShareActivityRecord, PostShareActivityRecordPK> {

        @Query("SELECT COUNT(p) FROM PostShareActivityRecord p WHERE p.id.post.id = :postId")
        long countByPostId(UUID postId);

}
