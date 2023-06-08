package com.my_group.pp_312_spring_boot.controller;

import com.my_group.pp_312_spring_boot.model.User;
import com.my_group.pp_312_spring_boot.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@RequiredArgsConstructor
@Controller
@RequestMapping("/")
public class UserControllerImpl implements UserController {

    private final UserService userService;

    @Override
    public String allUsers(Model model) {
        List<User> userList = userService.getAllUsers();
        model.addAttribute("userList", userList);
        return "users";
    }

    @Override
    public String addPage() {
        return "addUser";
    }

    @Override
    public String addUser(User user) {
        userService.saveUser(user);
        return "redirect:/";
    }

    @Override
    public String showEditUserForm(Integer id, Model model) {
        User user = userService.findById(id);
        if (user == null) {
            return "redirect:/";
        }
        model.addAttribute("user", user);
        return "editUser";
    }

    @Override
    public String updateUserSubmit(User user) {
        userService.saveUser(user);
        return "redirect:/";
    }

    @Override
    public String deleteUser(int id) {
        userService.deleteById(id);
        return "redirect:/";
    }
}
