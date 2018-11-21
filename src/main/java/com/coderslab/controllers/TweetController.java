package com.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.coderslab.entity.Tweet;
import com.coderslab.entity.User;
import com.coderslab.repository.TweetRepository;
import com.coderslab.repository.UserRepository;

import javax.validation.Valid;
import java.util.Collection;

@Controller
@RequestMapping("/tweet")
public class TweetController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    TweetRepository tweetRepository;

    @GetMapping("/add")
    private String putTweet(Model model, @ModelAttribute Tweet newTweet) {
        Tweet tweet = new Tweet();
        model.addAttribute("tweet", tweet);
        model.addAttribute("newTweet", newTweet);
        return "addTweet";
    }

    @PostMapping("/add")
    private String saveTweetToDatabase(Model model, @Valid @ModelAttribute Tweet newTweet, final BindingResult bresult) {
        if (bresult.hasErrors()) {
            Tweet tweet = new Tweet();
            model.addAttribute("tweet", tweet);
            model.addAttribute("newTweet",newTweet);
            return "addTweet";
        }
        tweetRepository.save(newTweet);
        return "redirect:../home";
    }

    @ModelAttribute("users")
    private Collection<User> listOfuser(Model model){
        Collection <User> listofUsers = userRepository.findAll();
        return listofUsers;
    }
}