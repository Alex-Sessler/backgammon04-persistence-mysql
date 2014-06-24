package backgammon04.backgammon04_persistence_mysql.model.impl;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import backgammon04.backgammon04_persistence_interface.model.Board;
import backgammon04.backgammon04_persistence_interface.model.Game;
import backgammon04.backgammon04_persistence_interface.model.Movement;
import backgammon04.backgammon04_persistence_interface.model.Player;
import backgammon04.backgammon04_persistence_interface.util.Color;

@Entity(name = "game")
@Table(name = "game")
@NamedQueries({
		@NamedQuery(name = "get.open.games", query = "select distinct g from game g where g.ended is null and g.started is null order by id"),
		@NamedQuery(name = "get.started.games", query = "select distinct g from game g where g.ended is null order by id") })
public class GameImpl implements Game {

	@Id
	@GeneratedValue
	@Column(name = "game_id")
	private long id;

	@OneToMany(targetEntity = PlayerImpl.class, mappedBy = "game", fetch = FetchType.EAGER)
	@OrderBy("id")
	private Set<Player> players;

	private Date initialized;

	private Date started;

	private Date ended;

	@OneToOne(targetEntity = BoardImpl.class, mappedBy = "game", cascade = CascadeType.ALL)
	private Board board;

	@OneToMany(targetEntity = MovementImpl.class, mappedBy = "game", fetch = FetchType.EAGER)
	private Set<Movement> movementList;

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
	public Date getStarted() {
		return started;
	}

	@Override
	public void setStarted(Date started) {
		this.started = started;
	}

	@Override
	public Date getInitialized() {
		return initialized;
	}

	@Override
	public void setInitialized(Date initialized) {
		this.initialized = initialized;
	}

	@Override
	public Board getBoard() {
		return board;
	}

	@Override
	public void setBoard(Board board) {
		this.board = board;
	}

	@Override
	public Set<Movement> getMovementList() {
		return movementList;
	}

	@Override
	public void setMovementList(Set<Movement> movementList) {
		this.movementList = movementList;
	}

	@Override
	public Set<Player> getPlayers() {
		return players;
	}

	@Override
	public void setPlayers(Set<Player> players) {
		this.players = players;
	}

	@Override
	public Color getColor() {
		return color;
	}

	@Override
	public void setColor(Color color) {
		this.color = color;
	}

	@Override
	public Date getEnded() {
		return ended;
	}

	@Override
	public void setEnded(Date ended) {
		this.ended = ended;
	}
}
