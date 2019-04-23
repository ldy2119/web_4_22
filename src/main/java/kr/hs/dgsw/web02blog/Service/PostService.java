package kr.hs.dgsw.web02blog.Service;

import kr.hs.dgsw.web02blog.domain.Post;

import java.util.List;

public interface PostService {

    Post addPost(Post post);
    Post readPost(Long id);
    Post get(Long userId);
    List<Post> list();
    Post updatePost(Post post);
    boolean deletePost(Long id);
}
