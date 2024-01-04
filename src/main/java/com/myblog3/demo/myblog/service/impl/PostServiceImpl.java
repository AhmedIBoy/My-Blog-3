package com.myblog3.demo.myblog.service.impl;

import com.myblog3.demo.myblog.entity.Post;
import com.myblog3.demo.myblog.paylod.PostDto;
import com.myblog3.demo.myblog.repositories.PostRepository;
import com.myblog3.demo.myblog.service.PostService;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepo;

    public PostServiceImpl(PostRepository postRepo) {
        this.postRepo = postRepo;
    }

    @Override
    public PostDto createPost(PostDto postDto) {
        Post post = new Post();
        post.setTittle(postDto.getTittle());
        post.setComments(postDto.getComments());
        post.setDescription(postDto.getDescription());
        Post savePost = postRepo.save(post);

        PostDto dto = new PostDto();
        dto.setTittle(savePost.getTittle());
        dto.setComments(savePost.getComments());
        dto.setDescription(savePost.getDescription());
        return dto;
    }
}
