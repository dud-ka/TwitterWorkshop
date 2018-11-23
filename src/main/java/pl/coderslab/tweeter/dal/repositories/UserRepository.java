package pl.coderslab.tweeter.dal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.tweeter.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByLogin(String login);

	User findByEmail(String email);

	User findByLoginAndPassword(String login, String password);
}
