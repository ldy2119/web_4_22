package kr.hs.dgsw.web02blog.Protocol;

import kr.hs.dgsw.web02blog.domain.Post;
import lombok.Data;

@Data
public class PostUserNameProtocol extends Post {

    private String userName;

    public PostUserNameProtocol(Post p, String n)
    {
        super(p);
        this.userName = n;
    }
}
