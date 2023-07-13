package com.sparta.market.dto;

import com.sparta.market.entity.Post;
import lombok.Getter;

@Getter
public class ReponseDto {
    private Long id;
    private String title;
    private String content;
    private int price;
    private String username;

    public ReponseDto(Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.price = post.getPrice();
        this.username = post.getUsername();
    }
}
