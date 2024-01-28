package com.myblog3.demo.myblog.service.impl;

import com.myblog3.demo.myblog.entity.Post;
import com.myblog3.demo.myblog.exception.ResourceNotFoundException;
import com.myblog3.demo.myblog.paylod.PostDto;
import com.myblog3.demo.myblog.repositories.PostRepository;
import com.myblog3.demo.myblog.service.PostService;
import com.myblog3.demo.myblog.util.PostResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
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
    public PostResponse getAllPost(int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNo,pageSize, sort);
        Page<Post> pagePost = postRepo.findAll(pageable);
        List<Post> allPost = pagePost.getContent();
        List<PostDto> dto = allPost.stream().map(this::postToPostDto).collect(Collectors.toList());

        PostResponse postResponse = new PostResponse();
        postResponse.setFirstPage(pagePost.isFirst());
        postResponse.setContent(dto);
        postResponse.setPageNumber(pagePost.getNumber());
        postResponse.setPageSize(pagePost.getSize());
        postResponse.setTotalElement(pagePost.getTotalElements());
        postResponse.setTotalPages(pagePost.getTotalPages());
        postResponse.setLastPage(pagePost.isLast());
        return postResponse;
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
