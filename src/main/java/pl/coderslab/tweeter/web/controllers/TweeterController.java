package pl.coderslab.tweeter.web.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import pl.coderslab.tweeter.services.TweetService;
import pl.coderslab.tweeter.web.dtos.TweetDTO;
import pl.coderslab.tweeter.web.dtos.UserDTO;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
public class TweeterController {
	@Autowired
	TweetService tweetService;

	@GetMapping("/userPage")
	public String userTweetList(Model model, @SessionAttribute(value = LoginController.LOGGED_USER_KEY,
			required = false) UserDTO loggedUser) {


		List<TweetDTO> tweetDTOS = tweetService.userTweetList(loggedUser);
		model.addAttribute("allTweets",tweetDTOS );
		model.addAttribute("addTweetOnUserPage", new TweetDTO());

		return "userWebsite";
	}


	@PostMapping("/")
	public String createTweet(@ModelAttribute("addTweet") @Valid TweetDTO tweetDTO,
	                          BindingResult bindingResult, HttpSession session) {
		if(bindingResult.hasErrors()){
			return "redirect:/";
		}
		tweetService.newTweet(tweetDTO, session);
		return "redirect:/";
	}

	@PostMapping("/userPage")
	public String createTweetOnUserPage(@ModelAttribute("addTweetOnUserPage") @Valid TweetDTO tweetDTO,
	                          BindingResult bindingResult, HttpSession session) {
		if(bindingResult.hasErrors()){
			return "redirect:/userPage";
		}
		tweetService.newTweet(tweetDTO, session);
		return "redirect:/userPage";
	}

}
