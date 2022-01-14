package com.myweb.Controllers;

import com.myweb.Exceptions.UserNotFoundException;
import com.myweb.models.User;
import com.myweb.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
       model.addAttribute("pageTitle","Add New User");
        return "user_form";
    }

  @PostMapping("/users/save")
  public String saveUser(User user, RedirectAttributes ra){
   userService.save(user);
   ra.addFlashAttribute("message","the user has been added successfully. ");
   return "redirect:/users";
  }

  @GetMapping("/users/edit/{id}")
    public  String ShowEditForm(@PathVariable("id")Integer id, Model model, RedirectAttributes ra){

        try {
      User user =userService.get(id);
      model.addAttribute("user",user);
      model.addAttribute("pageTitle","edit User (ID:" +id + ")");
      return "user_form";
      }
       catch (UserNotFoundException e){
           ra.addFlashAttribute("message","the user has been added successfully. ");
           return "redirect:/users";
        }


  }


}
