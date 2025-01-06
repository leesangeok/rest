package com.ll.rest.domain.post.post.Service;


import com.ll.rest.domain.post.post.entity.Post;
import com.ll.rest.domain.post.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public long count(){
        return postRepository.count();

    }
    public Post write(String title, String content){
        Post post = Post.builder()
                .title(title)
                .content(content)
                .build();

        return postRepository.save(post);
    }

    public List<Post> findAllByOrderByIdDesc() {
        return postRepository.findAllByOrderByIdDesc();
    }

    public Optional<Post> findById(long id) {
        return postRepository.findById(id);
    }

    public void delete(Post post) {
        postRepository.delete(post);
    }

    public void modify(Post post, String title, String content) {
        post.setTitle(title);
        post.setContent(content);

        postRepository.save(post);

    }
}