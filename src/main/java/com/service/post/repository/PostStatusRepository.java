package com.service.post.repository;

import com.service.post.entity.PostStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostStatusRepository extends JpaRepository<PostStatus,Long> {
}
