package pl.coderslab.tweeter.dal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.tweeter.domain.Tweet;
import pl.coderslab.tweeter.domain.User;

import java.awt.print.Book;
import java.util.List;

public interface TweetRepository extends JpaRepository<Tweet, Long> {

	List<Tweet> findAllByUserOrderByCreatedDesc(User user);
	List<Tweet> getAllByUserIdOrderByCreatedDesc(Long id);

	@Query("select t from Tweet t order by t.created desc ")
	List<Tweet> findAllTweets();

}

