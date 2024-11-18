package com.sparta.test.controller;


import com.sparta.test.dto.PostRequestDto;
import com.sparta.test.dto.PostResponseDto;
import com.sparta.test.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping
    public PostResponseDto createPost(@RequestBody PostRequestDto requestDto){
        return postService.createPost(requestDto);
    }

    @GetMapping
    public List<PostResponseDto> getPosts(){
        return postService.getPosts();
    }

    @PutMapping("/{id}")
    public Long updatePost(@PathVariable Long id, @RequestBody PostRequestDto requestDto){
        return postService.updatePost(id, requestDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePost(@PathVariable Long id){
        return postService.deletePost(id);

    }
}
