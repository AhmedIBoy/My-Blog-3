package com.myblog3.demo.myblog.repositories;

import com.myblog3.demo.myblog.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Long> {
}
