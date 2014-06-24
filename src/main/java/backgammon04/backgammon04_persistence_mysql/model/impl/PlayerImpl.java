package backgammon04.backgammon04_persistence_mysql.model.impl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import backgammon04.backgammon04_persistence_interface.model.Game;
import backgammon04.backgammon04_persistence_interface.model.Player;
import backgammon04.backgammon04_persistence_interface.model.User;
import backgammon04.backgammon04_persistence_interface.util.Color;

@Entity(name = "player")
@Table(name = "player")
@NamedQueries({ @NamedQuery(name = "get.my.games", query = "select distinct game from player p where p.user=:user order by p.game.id desc") })
public class PlayerImpl implements Player {

	@Id
	@GeneratedValue
	@Column(name = "player_id")
	private long id;

	@ManyToOne(targetEntity = UserImpl.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id", nullable = true, referencedColumnName = "user_id")
	private User user;

	@ManyToOne(targetEntity = GameImpl.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "game_id", nullable = false, referencedColumnName = "game_id")
	private Game game;

	@Enumerated(EnumType.STRING)
	@Column(name = "color")
	private Color color;

	@Override
	public long getId() {
		return id;
	}

	@Override
	public void setId(long id) {
		this.id = id;
	}

	@Override
	public User getUser() {
		return user;
	}

	@Override
	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public Game getGame() {
		return game;
	}

	@Override
	public void setGame(Game game) {
		this.game = game;
	}

	@Override
	public Color getColor() {
		return color;
	}

	@Override
	public void setColor(Color color) {
		this.color = color;
	}
}
