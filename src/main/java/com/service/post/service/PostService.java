package com.service.post.service;

import com.service.post.entity.dto.PostInfoDto;
import com.service.post.entity.dto.PostRegisterDto;

public interface PostService {
    PostInfoDto register(PostRegisterDto postRegister);
}
