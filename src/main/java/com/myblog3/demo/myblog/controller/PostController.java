package com.myblog3.demo.myblog.controller;

import com.myblog3.demo.myblog.paylod.PostDto;
import com.myblog3.demo.myblog.repositories.PostRepository;
import com.myblog3.demo.myblog.service.PostService;
import com.myblog3.demo.myblog.util.PostResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/post")
public class PostController {
    private final PostService postService;
//http://localhost:8081/api/post
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public ResponseEntity<PostDto> CreatePostAdd(@RequestBody PostDto postDto){
        PostDto postDto1 = postService.createPost(postDto);
        return new ResponseEntity<>(postDto1, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<PostResponse> getAllPost
            (
               @RequestParam(name = "pageNo",required = false,defaultValue = "0") int pageNo,
               @RequestParam(name = "pageSize",required = false,defaultValue = "3") int pageSize,
               @RequestParam(name = "sortBy", required = false,defaultValue = "id") String sortBy,
               @RequestParam(name = "sortDir",required = false,defaultValue = "id") String sortDir
            ){
         PostResponse postResponse =  postService.getAllPost(pageNo,pageSize,sortBy,sortDir);
        return new ResponseEntity<>(postResponse,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDto> GetPostbyId(@PathVariable long id){
        PostDto postById = postService.getPostById(id);
        return new ResponseEntity<>(postById,HttpStatus.OK);
    }
}
