package kr.hs.dgsw.web02blog.Service;

import kr.hs.dgsw.web02blog.Protocol.PostUserNameProtocol;
import kr.hs.dgsw.web02blog.domain.Post;

import java.util.List;

public interface PostService {

    Post addPost(Post post);
    PostUserNameProtocol readPost(Long id);
    PostUserNameProtocol get(Long userId);
    List<PostUserNameProtocol> list();
    Post updatePost(Post post);
    boolean deletePost(Long id);
}
