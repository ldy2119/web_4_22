package kr.hs.dgsw.web02blog.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Attachment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String storedPath;

    @ManyToOne
    private Post post;

    public Attachment(String storedPath, Post post)
    {
        this.storedPath = storedPath;
        this.post = post;
    }

    public Attachment()
    {

    }
}
