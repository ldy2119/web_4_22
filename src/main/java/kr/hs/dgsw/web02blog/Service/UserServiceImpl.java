package kr.hs.dgsw.web02blog.Service;

import kr.hs.dgsw.web02blog.Repository.UserRepository;
import kr.hs.dgsw.web02blog.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    private void init()
    {
        User user = new User();
        user.setAccount("aaa");
        user.setEmail("aaa@dgsw");
        user.setName("동엽");
        user.setPhone("010-3204-5207");
        user.setPassword("1234");
        userRepository.save(user);
    }

    @Override
    public User addUser(User user)
    {
        Optional<User> found = userRepository.findByAccount(user.getAccount());
        if(found.isPresent())
            return null;
        return userRepository.save(user);
    }

    @Override
    public List<User> listUser() {
        return userRepository.findAll();
    }

    @Override
    public User readUser(String account)
    {
        return userRepository.findByAccount(account).orElse(null);
    }

    @Override
    public User updateUser(User user)
    {
        return userRepository.findById(user.getId()).map(f ->
        {
//            f.setPassword(user.getPassword());
            f.setPhone(user.getPhone());
            f.setName(user.getName());
            f.setEmail(user.getEmail());
            return userRepository.save(f);
        }).orElse(null);
    }

    @Override
    public boolean deleteUser(Long userId)
    {
        return userRepository.findById(userId).map(f ->
        {
            userRepository.delete(f);
            return true;
        }).orElse(false);
    }

    @Override
    public User Login(User user) {
        return userRepository.findByAccount(user.getAccount()).map(f ->
        {
            if(f.getPassword().equals(user.getPassword()))
                return f;
            else
                return null;
        }).orElse(null);
    }
}
