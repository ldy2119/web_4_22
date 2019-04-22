package kr.hs.dgsw.web02blog.Repository;

import kr.hs.dgsw.web02blog.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

}
