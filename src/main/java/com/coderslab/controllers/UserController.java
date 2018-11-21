package com.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.coderslab.entity.User;
import com.coderslab.repository.TweetRepository;
import com.coderslab.repository.UserRepository;

import javax.validation.Valid;
import java.util.Collection;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TweetRepository tweetRepository;


    @GetMapping("/{id}/tweets")
    private String showTweet(@PathVariable("id") Long id, Model model) {
        Collection tweet = tweetRepository.findByUserId(id);
        model.addAttribute("tweet", tweet);
        return "tweetByUserId";
    }

    @GetMapping("/add")
    private String putUser(Model model, @ModelAttribute User newUser) {
        User user = new User();
        model.addAttribute("user", user);
        model.addAttribute("newUser", newUser);
        return "addUser";
    }

    @PostMapping("/add")
    private String saveUserToDatabase(Model model, @Valid @ModelAttribute User newUser, final BindingResult bresult) {
        if (bresult.hasErrors()) {
            User user = new User();
            model.addAttribute("user", user);
            model.addAttribute("newUser", newUser);
            return "addUser";
        }
        userRepository.save(newUser);
        return "redirect:../homepage";
    }

    @GetMapping("/all")
    private String showAlluser(Model model) {
        Collection<User> users = userRepository.findAll();
        model.addAttribute("users", users);
        return "showAllUsers";
    }


    @GetMapping("/delete")
    private String deleteUser(Model model, @RequestParam(name = "id") String id) {
        userRepository.deleteById(Long.valueOf(id));
        return "redirect:all";
    }

    @GetMapping("/edit")
    private String editUser(Model model, @RequestParam(name = "id") String id) {
        User user = userRepository.getOne(Long.valueOf(id));
        model.addAttribute("newUser", user);
        return "editUser";
    }

    @PostMapping("/editSaveToDB")
    private String editUserInDatabase(Model model, @Valid @ModelAttribute User newUser, final BindingResult bresult) {
        if (bresult.hasErrors()) {
            User user = new User();
            model.addAttribute("user", user);
            model.addAttribute("newUser", newUser);
            return "edit?id=" + newUser.getId();
        }
        userRepository.save(newUser);
        return "redirect:all";
    }


}