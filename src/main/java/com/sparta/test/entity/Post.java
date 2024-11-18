package com.sparta.test.entity;


import com.sparta.test.dto.PostRequestDto;
import com.sparta.test.dto.PostResponseDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "post")
public class Post {

    /*
    id - 게시글 번호 db인덱스
    title string 게시글제목
    content string게시글 내용

    price int 가격
    username string 작성자자
    */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "content", nullable = false, length = 400)
    private String content;

    @Column(name = "price", nullable = false)
    private int price;

    @Column(name = "username", nullable = false)
    private String username;

    public Post(PostRequestDto requestDto){
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
        this.price = requestDto.getPrice();
        this.username = requestDto.getUsername();
    }

    public void update(PostRequestDto requestDto){
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
        this.price = requestDto.getPrice();
    }
}
