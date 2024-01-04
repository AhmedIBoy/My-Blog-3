package com.myblog3.demo.myblog.controller;

import com.myblog3.demo.myblog.paylod.PostDto;
import com.myblog3.demo.myblog.repositories.PostRepository;
import com.myblog3.demo.myblog.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/post")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public ResponseEntity<PostDto> CreatePostAdd(@RequestBody PostDto postDto){
        PostDto postDto1 = postService.createPost(postDto);
        return new ResponseEntity<>(postDto1, HttpStatus.CREATED);
    }
}
