package com.service.post.web.controllers;

import com.service.post.entity.dto.PostInfoDto;
import com.service.post.entity.dto.PostRegisterDto;
import com.service.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping("/register")
    public ResponseEntity<PostInfoDto> registerPost(@RequestBody PostRegisterDto reg) {
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(postService.register(reg));
    }
}
