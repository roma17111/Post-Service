package com.service.post.repository;

import com.service.post.entity.PostOffice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostOfficeRepository extends JpaRepository<PostOffice, Long> {
    PostOffice findByName(String name);
    PostOffice findByIndex(String index);

}
