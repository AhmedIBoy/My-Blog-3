package com.myblog3.demo.myblog.service;

import com.myblog3.demo.myblog.entity.Comment;
import com.myblog3.demo.myblog.paylod.CommentDto;

public interface CommentService {
    CommentDto createComment(CommentDto commentDto,long postId);
}
