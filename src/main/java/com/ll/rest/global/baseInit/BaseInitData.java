package com.ll.rest.global.baseInit;

import com.ll.rest.domain.post.post.Service.PostService;
import com.ll.rest.domain.post.post.entity.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.transaction.annotation.Transactional;


@Configuration
@RequiredArgsConstructor
public class BaseInitData {
    private final PostService postService;
    @Autowired
    @Lazy
    private BaseInitData self;

    @Bean
    public ApplicationRunner baseInitDataApplicationRunner() {
        return args -> {
            self.work1();
        };
    }

    @Transactional
    public void work1() {
        if(postService.count() > 0 ) return;

        Post post1 = postService.write("축구하실분?","14시 까지 22명을 모아야합니다.");
        Post post2 = postService.write("축구하실분?","15시 까지 22명을 모아야합니다.");
        Post post3 = postService.write("축구하실분?","16시 까지 22명을 모아야합니다.");


    }

}