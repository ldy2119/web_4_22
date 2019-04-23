package kr.hs.dgsw.web02blog.Controller;

import kr.hs.dgsw.web02blog.Protocol.ResponseFormat;
import kr.hs.dgsw.web02blog.Protocol.ResponseType;
import kr.hs.dgsw.web02blog.Service.PostService;
import kr.hs.dgsw.web02blog.domain.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("/addPost")
    public ResponseFormat addUser(@RequestBody Post post)
    {
        return new ResponseFormat(ResponseType.POST_ADD, postService.addPost(post));
    }

    @GetMapping("/findPost/{id}")
    public ResponseFormat findUser(@PathVariable Long id)
    {
        return new ResponseFormat(ResponseType.POST_GET, postService.readPost(id));
    }

    @PutMapping("/updatePost")
    public ResponseFormat updateUser(@RequestBody Post post)
    {
        return new ResponseFormat(ResponseType.POST_UPDATE, postService.updatePost(post));
    }

    @DeleteMapping("/deletePost/{id}")
    public ResponseFormat deleteUser(@PathVariable Long id)
    {
        return new ResponseFormat(ResponseType.POST_UPDATE, postService.deletePost(id));
    }
}
