package kr.hs.dgsw.web02blog.Service;

import kr.hs.dgsw.web02blog.Repository.PostRepository;
import kr.hs.dgsw.web02blog.domain.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @PostConstruct
    private void init()
    {
        postRepository.save(new Post("11", "22", 1L));
        postRepository.save(new Post("33", "44", 1L));
    }

    @Override
    public Post addPost(Post post) {
        return postRepository.save(post);
    }

    @Override
    public Post readPost(Long id) {
        return postRepository.findById(id).orElse(null);
    }

    @Override
    public Post get(Long userId)
    {
        return postRepository.findTopByUserIdOrderByIdDesc(userId).orElse(null);
    }

    @Override
    public List<Post> list() {
        return postRepository.findAll();
    }

    @Override
    public Post updatePost(Post post) {
        return postRepository.findById(post.getId()).map(f ->
        {
            f.setContent(post.getContent());
            f.setTitle(post.getTitle());
            f.setPictures(post.getPictures());
            return postRepository.save(f);
        }).orElse(null);
    }

    @Override
    public boolean deletePost(Long id) {
        return postRepository.findById(id).map(f ->
        {
            postRepository.delete(f);
            return true;
        }).orElse(false);
    }
}
