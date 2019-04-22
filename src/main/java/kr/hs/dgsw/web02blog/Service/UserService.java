package kr.hs.dgsw.web02blog.Service;

import kr.hs.dgsw.web02blog.domain.User;

public interface UserService {

    User addUser(User user);
    User readUser(String account);
    User updateUser(User user);
    boolean deleteUser(Long userId);

}
