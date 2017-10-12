package may.i.jhq.thymeleaf.web;

import may.i.jhq.thymeleaf.entity.User;
import may.i.jhq.thymeleaf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author jinhuaquan
 * @create 2017-09-26 下午5:45
 * @desc 用户相关的Controller层
 **/
@Controller
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String listUser(Model model) {
        List<User> users = userService.listUser();
        model.addAttribute("users", users);

        return "user/list";
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String saveUser(User user) {
        userService.saveUser(user);

        return "redirect:/api/users";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String toAdd() {
        return "user/userAdd";
    }
}
