package com.kata.demo.controller;

import com.kata.demo.service.UserService;
import jakarta.validation.Valid;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import org.springframework.validation.annotation.Validated;
import java.util.List;

@Controller
@RequestMapping("/")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String fullTable(ModelMap modelMap) {
        List<User> users = userService.getAllUsers();
        modelMap.addAttribute("allUsers", users);
        return "home";
    }

    @GetMapping("/creat")
    public String createNewUser(ModelMap modelMap) {
        modelMap.addAttribute("userForm", new com.kata.demo.model.User());
        return "createUser";
    }

    @PostMapping("/saveUser")
    public String saveNewUser(@ModelAttribute("userForm") @Valid User user,
                              BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/createUser";
        }
        userService.creatUser(user);
        return "redirect:/";
    }

    @GetMapping("/updateUser")
    public String updateById(ModelMap modelMap, @RequestParam("id") long id) {
        User user = userService.getUserId(id);
        modelMap.addAttribute("userForm", user);
        return "upd";
    }

    @PostMapping("/edit")
    public String editUser(@ModelAttribute("userForm") @Valid User user,
                           BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/upd";
        }
        userService.updatUser(user);
        return "redirect:/";
    }

    @RequestMapping("/deleteUser")
    public String deleteUser(@RequestParam("id") long id) {
        userService.delUser(id);
        return "redirect:/";
    }
}
