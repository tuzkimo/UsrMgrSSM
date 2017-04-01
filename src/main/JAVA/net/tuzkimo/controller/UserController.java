package net.tuzkimo.controller;

import net.tuzkimo.model.User;
import net.tuzkimo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by tuzkimo on 2017-03-17.
 */
@Controller
@RequestMapping
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping
    public String index(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "index";
    }

    @RequestMapping("/add")
    public String add(Model model) {
        model.addAttribute("user", new User());
        return "addUser";
    }

    @RequestMapping("/addSave")
    public String addSave(Model model, @ModelAttribute("user") User user) {
        if (userService.addUser(user) > 0) {
            return "redirect:/";
        }
        model.addAttribute("user", user);
        return "addUser";
    }

    @RequestMapping("/edit/{id}")
    public String edit(Model model, @PathVariable Integer id) {
        model.addAttribute("user", userService.getUserById(id));
        return "editUser";
    }

    @RequestMapping("/editSave")
    public String editSave(Model model, @ModelAttribute("user") User user) {
        if (userService.editUser(user) > 0) {
            return "redirect:/";
        }
        model.addAttribute("user", user);
        return "editUser";
    }

    @RequestMapping("/delete/{id}")
    public String delete(Model model, @PathVariable Integer id) {
        userService.deleteUserById(id);
        return "redirect:/";
    }

}
