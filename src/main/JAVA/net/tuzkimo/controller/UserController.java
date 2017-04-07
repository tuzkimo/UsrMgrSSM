package net.tuzkimo.controller;

import net.tuzkimo.model.User;
import net.tuzkimo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;

/**
 * 用户控制器
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

    @RequestMapping("/upPhoto/{id}")
    public String upPhoto(Model model, @PathVariable Integer id) {
        model.addAttribute("user", userService.getUserById(id));
        return "upPhoto";
    }

    @RequestMapping("/upPhotoSave/{id}")
    public String upPhotoSave(Model model, @PathVariable Integer id, @RequestParam MultipartFile photo, HttpServletRequest request) {

        User user = userService.getUserById(id);

        // 文件非空判断
        if (photo.isEmpty()) {
            model.addAttribute("message", "Please upload a photo.");
            model.addAttribute("user", user);
            return "upPhoto";
        }

        // 获取文件名
        String photoName = photo.getOriginalFilename();

        if (!(photoName.endsWith(".jpg") || photoName.endsWith(".png"))) {
            model.addAttribute("message", "Sorry, we only accept ipg or png file.");
            model.addAttribute("user", user);
            return "upPhoto";
        }

        String path = request.getSession().getServletContext().getRealPath("/photos");

        File tempFile = new File(path, photoName);

        if (!tempFile.getParentFile().exists()) {
            tempFile.getParentFile().mkdir();
        }

        try {
            photo.transferTo(tempFile);
            user.setPhoto(photo.getOriginalFilename());
            userService.editUser(user);
            return "redirect:/";
        } catch (Exception e) {
            e.printStackTrace();
        }

        model.addAttribute("user", user);
        return "upPhoto";

    }

}
