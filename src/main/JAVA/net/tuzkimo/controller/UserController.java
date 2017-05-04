package net.tuzkimo.controller;

import net.tuzkimo.model.User;
import net.tuzkimo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;

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
    public String index(Model model, @RequestParam(required = false, defaultValue = "1") Integer pageNo) {
        Integer size = 5;
        Integer usersCount = userService.getUsersCount();
        Integer pages;

        // 计算分页数
        if (usersCount % size == 0) {
            pages = usersCount / size;
        } else {
            pages = (usersCount / size) + 1;
        }

        // 控制分页边界
        if (pageNo < 1) {
            pageNo = 1;
        }
        if (pageNo > pages) {
            pageNo = pages;
        }

        model.addAttribute("pageNo", pageNo);
        model.addAttribute("users", userService.getUsersPaper(pageNo, size));
        model.addAttribute("pages", pages);
        return "index";
    }

    @RequestMapping("/add")
    public String add(Model model) {
        model.addAttribute("user", new User());
        return "addUser";
    }

    @RequestMapping("/addSave")
    public String addSave(Model model, @ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            if (userService.addUser(user) > 0) {
                return "redirect:/";
            }
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
    public String editSave(Model model, @ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            if (userService.editUser(user) > 0) {
                return "redirect:/";
            }
        }
        model.addAttribute("user", user);
        return "editUser";
    }

    @RequestMapping("/delete/{id}")
    public String delete(Model model, @PathVariable Integer id, @RequestParam(required = false, defaultValue = "1") Integer pageNo) {
        userService.deleteUserById(id);
        return "redirect:/?pageNo=" + pageNo;
    }

    @RequestMapping("/deletes")
    public String deletes(Model model, @RequestParam Integer[] id, @RequestParam(required = false, defaultValue = "1") Integer pageNo) {
        userService.deleteUsersByIds(id);
        return "redirect:/?pageNo=" + pageNo;
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
