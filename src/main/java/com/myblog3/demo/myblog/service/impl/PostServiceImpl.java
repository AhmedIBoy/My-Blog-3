package com.myblog3.demo.myblog.service.impl;

import com.myblog3.demo.myblog.entity.Post;
import com.myblog3.demo.myblog.exception.ResourceNotFoundException;
import com.myblog3.demo.myblog.paylod.PostDto;
import com.myblog3.demo.myblog.repositories.PostRepository;
import com.myblog3.demo.myblog.service.PostService;
import org.hibernate.ResourceClosedException;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    @Override
    public List<PostDto> getAllPost() {
        List<Post> allPost = postRepo.findAll();
        List<PostDto> dto = allPost.stream().map(this::postToPostDto).collect(Collectors.toList());
        return dto;
    }

    @Override
    public PostDto getPostById(Long id) {
        Post post = postRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post Not Found with id " + id));
        PostDto postDto = this.postToPostDto(post);
        return postDto;
    }



    public Post postDtoToPost(PostDto postDto){
        Post post = new Post();
        post.setId(post.getId());
        post.setTittle(postDto.getTittle());
        post.setComments(postDto.getComments());
        post.setDescription(postDto.getDescription());
        return post;
    }

    public PostDto postToPostDto(Post post){
        PostDto postDto = new PostDto();
        postDto.setId(post.getId());
        postDto.setTittle(post.getTittle());
        postDto.setDescription(post.getDescription());
        postDto.setComments(post.getComments());
        return postDto;
    }
}
