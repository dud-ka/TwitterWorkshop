package pl.coderslab.tweeter.web.dtos;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

public class LoginFormDTO {

	@NotBlank(message = "należy podać login")
	@NotNull(message = "należy podać login")
	private String login;
	@NotBlank(message = "należy podać hasło")
	@NotNull(message = "należy podać hasło")
	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
}
