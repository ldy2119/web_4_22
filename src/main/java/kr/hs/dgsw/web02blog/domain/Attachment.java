package kr.hs.dgsw.web02blog.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Attachment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String storedPath;

    private Long postId;

    public Attachment(String storedPath, Long postId)
    {
        this.storedPath = storedPath;
        this.postId = postId;
    }
}
