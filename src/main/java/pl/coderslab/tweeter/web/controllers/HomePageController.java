package pl.coderslab.tweeter.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.tweeter.services.TweetService;
import pl.coderslab.tweeter.web.dtos.TweetDTO;
import pl.coderslab.tweeter.web.dtos.UserDTO;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class HomePageController {

    @Autowired
    TweetService tweetService;

    @GetMapping
    public String prepareHomePage(Model model,
                                  @SessionAttribute(value = LoginController.LOGGED_USER_KEY,
                                          required = false) UserDTO loggedUser) {
        model.addAttribute("title", "Witaj w naszym serwisie!");
        if(loggedUser != null) {
            model.addAttribute("loggedUser", loggedUser);
            model.addAttribute("allTweets", tweetService.tweetList());
            model.addAttribute("addTweet", new TweetDTO());
        }

        return "/index";
    }

    @PostMapping
    public String createTweet(@ModelAttribute("addTweet") @Valid TweetDTO tweetDTO,
                              BindingResult bindingResult, HttpSession session) {
        if(bindingResult.hasErrors()){
            return "redirect:/";
        }
         tweetService.newTweet(tweetDTO, session);
         return "redirect:/";
    }


}
