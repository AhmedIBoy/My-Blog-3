package com.myblog3.demo.myblog.service.impl;

import com.myblog3.demo.myblog.entity.Comment;
import com.myblog3.demo.myblog.entity.Post;
import com.myblog3.demo.myblog.exception.ResourceNotFoundException;
import com.myblog3.demo.myblog.paylod.CommentDto;
import com.myblog3.demo.myblog.repositories.CommentRepository;
import com.myblog3.demo.myblog.repositories.PostRepository;
import com.myblog3.demo.myblog.service.CommentService;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    private  CommentRepository commentRepo;
    private  PostRepository postRepo;

    public CommentServiceImpl(CommentRepository commentRepo, PostRepository postRepo) {
        this.commentRepo = commentRepo;
        this.postRepo = postRepo;
    }

    @Override
    public CommentDto createComment(CommentDto commentDto, long postId) {
        Post post = postRepo.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Resource Not Found With Id : " + postId));
        Comment comment = new Comment();
        comment.setTitle(commentDto.getTitle());
        comment.setEmail(commentDto.getEmail());
        comment.setPost(post);
        Comment savedComment = commentRepo.save(comment);
        CommentDto commentDto1 = new CommentDto();
        commentDto1.setTitle(savedComment.getTitle());
        commentDto1.setEmail(savedComment.getEmail());
        return commentDto1;
    }
}
