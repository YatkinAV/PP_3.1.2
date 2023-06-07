package com.my_group.pp_312_spring_boot.controller;

import com.my_group.pp_312_spring_boot.model.User;
import com.my_group.pp_312_spring_boot.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class UserController {
        private final UserService userService;

        public UserController(UserService userService) {
            this.userService = userService;
        }


        @GetMapping("/")
        public String allUsers(Model model) {
            List<User> userList = userService.getAllUsers();
            model.addAttribute("userList", userList);
            return "users";
        }

        @RequestMapping(value = "/add", method = RequestMethod.GET)
        public String addPage() {
            return "addUser";
        }

        @RequestMapping(value = "/add", method = RequestMethod.POST)
        public String addUser(@ModelAttribute("user") User user) {
            userService.saveUser(user);
            return "redirect:/";
        }
        @GetMapping("/edit/{id}")
        public String showEditUserForm(@PathVariable("id") Integer id, Model model) {
            User user = userService.findById(id);
            if (user == null) {
                return "redirect:/";
            }
            model.addAttribute("user", user);
            return "editUser";
        }

        @PostMapping("/edit")
        public String updateUserSubmit(User user) {
            userService.saveUser(user);
            return "redirect:/";
        }

        @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
        public String deleteUser(@PathVariable("id") int id) {
            userService.deleteById(id);
            return "redirect:/";
        }
}
