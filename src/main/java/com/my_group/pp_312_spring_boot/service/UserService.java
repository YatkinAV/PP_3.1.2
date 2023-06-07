package com.my_group.pp_312_spring_boot.service;

import com.my_group.pp_312_spring_boot.model.User;
import com.my_group.pp_312_spring_boot.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public void deleteById(Integer id) {
        userRepository.deleteById(id);
    }

   /* public void editUser(Integer id, User user) {
        User user1 = userRepository.findById(id).orElse(null);;
        user1.setId(user.getId());
        user1.setFirstName(user.getFirstName());;
        user1.setLastName(user.getLastName());
        user1.setMail(user.getMail());
        user1.setAge(user.getAge());
        userRepository.save(user1);
    }*/
}
