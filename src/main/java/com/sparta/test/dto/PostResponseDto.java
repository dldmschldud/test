package com.sparta.test.dto;

import com.sparta.test.entity.Post;
import lombok.Getter;

@Getter
public class PostResponseDto {
    private Long id;
    private String username;
    private String title;
    private String content;
    private int price;


    public PostResponseDto(Post post){
        this.id = post.getId();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.price = post.getPrice();
        this.username = post.getUsername();
    }
}
