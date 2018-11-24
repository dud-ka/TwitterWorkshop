package pl.coderslab.tweeter.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.tweeter.dal.repositories.UserRepository;
import pl.coderslab.tweeter.domain.User;
import pl.coderslab.tweeter.web.dtos.UserDTO;

import javax.transaction.Transactional;

@Service
@Transactional
public class LoginService {

	@Autowired
	UserRepository userRepository;

	public boolean checkCredentials(String login, String password) {
		if(login == null || login.isEmpty()) {
			return false;
		}
		if(password == null || password.isEmpty()) {
			return false;
		}
		User user = userRepository.findByLoginAndPassword(login, password);
		return user != null;

	}

	public UserDTO login(String login, String password) {
		if(login == null || login.isEmpty()) {
			return null;
		}
		if(password == null || password.isEmpty()) {
			return null;
		}
		User user = userRepository.findByLoginAndPassword(login, password);
		UserDTO userDTO = new UserDTO();
		userDTO.setId(user.getId());
		userDTO.setEmail(user.getEmail());
		userDTO.setLogin(user.getLogin());
		return userDTO;
	}
}
