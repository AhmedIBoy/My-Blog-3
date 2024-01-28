package com.myblog3.demo.myblog.service;

import com.myblog3.demo.myblog.paylod.PostDto;
import com.myblog3.demo.myblog.util.PostResponse;

import java.util.List;

public interface PostService {
    PostDto createPost(PostDto postDto);

    PostResponse getAllPost(int pageNo, int pageSize, String sortBy, String sortDir);
    PostDto getPostById(Long id);
}
