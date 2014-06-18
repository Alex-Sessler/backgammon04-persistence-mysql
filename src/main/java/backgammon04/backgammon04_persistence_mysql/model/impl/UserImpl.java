package backgammon04.backgammon04_persistence_mysql.model.impl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

import backgammon04.model.User;

@Entity(name = "user")
@Table(name = "user")
public class UserImpl implements User {

	@Id
	@GeneratedValue
	@Column(name = "user_id")
	public Long id;

	@Column(nullable = false)
	public String username;

	@Email
	@Column(nullable = false)
	public String email;

	@Length(min = 4)
	@Column(nullable = false)
	public String password;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
