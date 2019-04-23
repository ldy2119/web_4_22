package kr.hs.dgsw.web02blog.Controller;

import kr.hs.dgsw.web02blog.Protocol.ResponseFormat;
import kr.hs.dgsw.web02blog.Protocol.ResponseType;
import kr.hs.dgsw.web02blog.Service.UserService;
import kr.hs.dgsw.web02blog.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    public ResponseFormat addUser(@RequestBody User user)
    {
        return new ResponseFormat(ResponseType.USER_ADD, userService.addUser(user));
    }

    @GetMapping("/listUser")
    public ResponseFormat list()
    {
        return new ResponseFormat(ResponseType.USER_GET, userService.listUser());

    }

    @GetMapping("/findUser/{account}")
    public ResponseFormat findUser(@PathVariable String account)
    {
        return new ResponseFormat(ResponseType.USER_GET, userService.readUser(account));
    }

    @PutMapping("/updateUser")
    public ResponseFormat updateUser(@RequestBody User user)
    {
        return new ResponseFormat(ResponseType.USER_UPDATE, userService.updateUser(user));
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseFormat deleteUser(@PathVariable Long id)
    {
        return new ResponseFormat(ResponseType.USER_DELETE, userService.deleteUser(id));
    }
}
