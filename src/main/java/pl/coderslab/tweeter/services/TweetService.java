package pl.coderslab.tweeter.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.tweeter.dal.repositories.TweetRepository;
import pl.coderslab.tweeter.domain.Tweet;
import pl.coderslab.tweeter.domain.User;
import pl.coderslab.tweeter.web.controllers.LoginController;
import pl.coderslab.tweeter.web.dtos.TweetDTO;
import pl.coderslab.tweeter.web.dtos.UserDTO;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class TweetService {

	@Autowired
	TweetRepository tweetRepository;


	public List<TweetDTO> tweetList(){
		List<TweetDTO> tweets = new ArrayList<>();
		List<Tweet> tweet = tweetRepository.findAllTweets();
		for (Tweet t: tweet) {
			TweetDTO tweetDTO = new TweetDTO();
			tweetDTO.setId(t.getId());
			tweetDTO.setText(t.getText());
			tweetDTO.setCreated(t.getCreated());

			UserDTO userDTO = new UserDTO();
			userDTO.setId(t.getUser().getId());
			userDTO.setEmail(t.getUser().getEmail());
			userDTO.setLogin(t.getUser().getLogin());

			tweetDTO.setUser(userDTO);

			tweets.add(tweetDTO);
		}
		return tweets;
	}

	public void newTweet(@Valid TweetDTO tweetDTO, HttpSession session) {
		Tweet tweet = new Tweet();
		tweet.setCreated(new Timestamp(System.currentTimeMillis()));
		tweet.setText(tweetDTO.getText());

		UserDTO userDTO = (UserDTO) session.getAttribute(LoginController.LOGGED_USER_KEY);
		User user = new User();
		user.setId(userDTO.getId());
		tweet.setUser(user);
		tweetRepository.save(tweet);

	}

	public List<TweetDTO> userTweetList(UserDTO userDTO) {
		List<TweetDTO> tweets = new ArrayList<>();
		User user = new User();
		List<Tweet> tweet = tweetRepository.getAllByUserIdOrderByCreatedDesc(userDTO.getId());
		for (Tweet t: tweet) {
			TweetDTO tweetDTO = new TweetDTO();
			tweetDTO.setId(t.getId());
			tweetDTO.setText(t.getText());
			tweetDTO.setCreated(t.getCreated());

//			UserDTO userDTO = new UserDTO();
			userDTO.setId(t.getUser().getId());
			userDTO.setEmail(t.getUser().getEmail());
			userDTO.setLogin(t.getUser().getLogin());

			tweetDTO.setUser(userDTO);

			tweets.add(tweetDTO);
		}
		return tweets;
	}


}
