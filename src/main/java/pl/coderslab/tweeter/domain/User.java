package pl.coderslab.tweeter.domain;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.hibernate.validator.constraints.Currency;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String password;
	@Column(nullable = false)
	private String login;
	@Column(nullable = false, unique = true)
	private String email;
	@Column(nullable = false)
	private Boolean enabled;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", login='" + login + '\'' +
				", email='" + email + '\'' +
				", enabled=" + enabled +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		User user = (User) o;
		return Objects.equals(id, user.id) &&
				Objects.equals(password, user.password) &&
				Objects.equals(login, user.login) &&
				Objects.equals(email, user.email) &&
				Objects.equals(enabled, user.enabled);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, password, login, email, enabled);
	}
}
