package com.sparta.market.service;

import com.sparta.market.dto.ReponseDto;
import com.sparta.market.dto.RequestDto;
import com.sparta.market.entity.Post;
import com.sparta.market.repository.PostRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PostService {
    private final PostRepository postRepository;

    // Repository 의존성 생성자 주입
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    // 판매글 작성
    public ReponseDto createPost(RequestDto requestDto) {
        Post post = new Post(requestDto);
        postRepository.save(post);
        return new ReponseDto(post);
    }

    // 전체 판매글 조회
    public List<ReponseDto> getAllPost() {
        List<ReponseDto> posts = postRepository.findAll().stream().map(ReponseDto::new).toList();
        return posts;
    }

    // 판매글 상세 조회
    public ReponseDto findPost(Long postId) {
        ReponseDto post = new ReponseDto(findPostById(postId));
        return post;
    }

    // 판매글 수정
    @Transactional
    public ReponseDto updatePost(Long postId, RequestDto requestDto) {
        Post post = findPostById(postId);
        post.update(requestDto);
        return new ReponseDto(post);
    }

    // 판매글 삭제
    public String deletePost(Long postId) {
        postRepository.delete(findPostById(postId));
        return "msg : 삭제 완료";
    }

    // 판매글 찾는 메서드
    private Post findPostById(Long postId){
        return postRepository.findById(postId)
                .orElseThrow(() -> new NullPointerException("해당 판매글이 존재하지 않습니다."));
    }
}
