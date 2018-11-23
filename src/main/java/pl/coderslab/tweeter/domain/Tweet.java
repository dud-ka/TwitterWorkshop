package pl.coderslab.tweeter.domain;


import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.sql.Timestamp;

@Entity
@Table(name = "tweets")
public class Tweet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	@ManyToOne
	@JoinColumn(name = "user")
	private User user;
	@Size(min = 1, max = 140)
	@NotBlank
	private String text;
	@Column(nullable = false)
	private Timestamp created;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Timestamp getCreated() {
		return created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}
}
