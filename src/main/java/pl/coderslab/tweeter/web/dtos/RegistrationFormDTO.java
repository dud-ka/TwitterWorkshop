package pl.coderslab.tweeter.web.dtos;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RegistrationFormDTO {


	@NotNull(message = "hasło musi zostać podane")
	@NotBlank(message = "hasło nie może być puste")
	private String password;
	@NotNull(message = "login musi zostać podany") @NotBlank @Size(min = 3, max = 12, message = "Login musi zawierać od 3 do 12 znaków")
	private String login;
	@NotNull(message = "login musi zostać podany") @Email(message = "Niepoprawny format email")
	private String email;
	@NotNull(message = "powtórzone hasło musi zostać podane")
	@NotBlank(message = "powtórzone hasło nie może być puste")
	private String confirmPassword;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

}


