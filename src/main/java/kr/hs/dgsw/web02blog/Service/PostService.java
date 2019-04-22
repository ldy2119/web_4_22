package kr.hs.dgsw.web02blog.Service;

import kr.hs.dgsw.web02blog.domain.Post;

public interface PostService {

    Post addPost(Post post);
    Post readPost(Long id);
    Post updatePost(Post post);
    boolean deletePost(Long id);
}
