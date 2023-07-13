package com.sparta.market.controller;

import com.sparta.market.dto.ReponseDto;
import com.sparta.market.dto.RequestDto;
import com.sparta.market.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PostController {
    private final PostService postService;

    // Service 의존성 생성자 주입
    public PostController(PostService postService) {
        this.postService = postService;
    }

    // 판매글 작성 API
    @PostMapping("/post")
    public ReponseDto createPost(@RequestBody RequestDto requestDto){
        return postService.createPost(requestDto);
    }

    // 전체 판매글 조회 API
    @GetMapping("/post")
    public List<ReponseDto> getAllPost(){
        return postService.getAllPost();
    }

    // 판매글 상세 조회 API
    @GetMapping("/post/{postId}")
    public ReponseDto findPost(@PathVariable Long postId){
        return postService.findPost(postId);
    }

    // 판매글 수정 API
    @PutMapping("/post/{postId}")
    public ReponseDto updatePost(@PathVariable Long postId, @RequestBody RequestDto requestDto){
        return postService.updatePost(postId, requestDto);
    }

    @DeleteMapping("/post/{postId}")
    public String deletePost(@PathVariable Long postId){
        return postService.deletePost(postId);
    }
}
