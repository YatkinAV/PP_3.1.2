package com.my_group.pp_312_spring_boot.controller;

import com.my_group.pp_312_spring_boot.model.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/default")
public interface UserController {

    @GetMapping("/")
    String allUsers(Model model);

    @GetMapping("/add")
    String addPage();

    @PostMapping("/add")
    String addUser(@ModelAttribute("user") User user);

    @GetMapping("/edit/{id}")
    String showEditUserForm(@PathVariable("id") Integer id, Model model);

    @PostMapping("/edit")
    String updateUserSubmit(User user);

    @GetMapping("/delete/{id}")
    String deleteUser(@PathVariable("id") int id);

}
