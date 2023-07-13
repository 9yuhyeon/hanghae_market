package com.sparta.market.dto;

import lombok.Getter;

@Getter
public class RequestDto {
    private String title;
    private String content;
    private int price;
    private String username;
}
