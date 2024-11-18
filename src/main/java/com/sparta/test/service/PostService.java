package com.sparta.test.service;

import com.sparta.test.dto.PostRequestDto;
import com.sparta.test.dto.PostResponseDto;
import com.sparta.test.entity.Post;
import com.sparta.test.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    public PostResponseDto createPost(PostRequestDto requestDto) {

        Post post = new Post(requestDto);
        Post newPost = postRepository.save(post);
        PostResponseDto postResponseDto = new PostResponseDto(newPost);
        return postResponseDto;
    }

    public List<PostResponseDto> getPosts() {
        return postRepository.findAll().stream().map(PostResponseDto::new).toList();
    }

    @Transactional
    public Long updatePost(Long id, PostRequestDto requestDto) {
        Post post = postRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("선택한 게시글은 존재하지 않습니다")
        );
        post.update(requestDto);
        return id;
    }


    public ResponseEntity<?> deletePost(Long id) {
        Post post = postRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("선택한 게시글은 존재하지 않습니다")
        );
        postRepository.delete(post);

        Map<String, String> response = new HashMap<>();
        response.put("msg", "삭제완료");
        return ResponseEntity.ok(response);
    }


}
