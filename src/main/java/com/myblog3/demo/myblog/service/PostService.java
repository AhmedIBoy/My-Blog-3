package com.myblog3.demo.myblog.service;

import com.myblog3.demo.myblog.paylod.PostDto;

import java.util.List;

public interface PostService {
    PostDto createPost(PostDto postDto);
    List<PostDto> getAllPost();

    PostDto getPostById(Long id);
}
