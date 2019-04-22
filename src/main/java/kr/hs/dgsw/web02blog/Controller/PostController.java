package kr.hs.dgsw.web02blog.Controller;

import kr.hs.dgsw.web02blog.Service.PostService;
import kr.hs.dgsw.web02blog.domain.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("/addPost")
    public Post addUser(@RequestBody Post post)
    {
        return postService.addPost(post);
    }

    @GetMapping("/findPost/{id}")
    public Post findUser(@PathVariable Long id)
    {
        return postService.readPost(id);
    }

    @PutMapping("/updatePost")
    public Post updateUser(@RequestBody Post post)
    {
        return postService.updatePost(post);
    }

    @DeleteMapping("/deletePost/{id}")
    public boolean deleteUser(@PathVariable Long id)
    {
        return postService.deletePost(id);
    }
}
