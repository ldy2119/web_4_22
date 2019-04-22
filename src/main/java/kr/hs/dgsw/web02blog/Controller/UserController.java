package kr.hs.dgsw.web02blog.Controller;

import kr.hs.dgsw.web02blog.Service.UserService;
import kr.hs.dgsw.web02blog.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    public User addUser(@RequestBody User user)
    {
        return userService.addUser(user);
    }

    @GetMapping("/findUser/{account}")
    public User findUser(@PathVariable String account)
    {
        return userService.readUser(account);
    }

    @PutMapping("/updateUser")
    public User updateUser(@RequestBody User user)
    {
        return userService.updateUser(user);
    }

    @DeleteMapping("/deleteUser/{id}")
    public boolean deleteUser(@PathVariable Long id)
    {
        return userService.deleteUser(id);
    }
}
