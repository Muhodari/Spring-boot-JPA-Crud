package com.myweb.Controllers;

import com.myweb.models.User;
import com.myweb.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public String ShowUsers(Model model){
    List<User> listUsers= userService.listAll();
    model.addAttribute("listUsers",listUsers);

        return "users";
    }


    @GetMapping("/users/new")
    public String ShowNewForm(Model model){
       model.addAttribute("user",new User());
        return "user_form";
    }

}
