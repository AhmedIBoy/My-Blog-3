package com.myblog3.demo.myblog.repositories;

import com.myblog3.demo.myblog.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Long> {

}
