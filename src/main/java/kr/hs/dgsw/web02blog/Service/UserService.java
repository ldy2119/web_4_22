package kr.hs.dgsw.web02blog.Service;

import kr.hs.dgsw.web02blog.domain.User;

import java.util.List;

public interface UserService {

    User addUser(User user);
    List<User> listUser();
    User readUser(String account);
    User updateUser(User user);
    boolean deleteUser(Long userId);

}
