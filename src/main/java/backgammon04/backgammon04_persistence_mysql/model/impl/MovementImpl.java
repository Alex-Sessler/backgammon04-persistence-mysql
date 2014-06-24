package backgammon04.backgammon04_persistence_mysql.model.impl;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import backgammon04.backgammon04_persistence_interface.model.Checker;
import backgammon04.backgammon04_persistence_interface.model.Dice;
import backgammon04.backgammon04_persistence_interface.model.Game;
import backgammon04.backgammon04_persistence_interface.model.Movement;
import backgammon04.backgammon04_persistence_interface.model.Player;
import backgammon04.backgammon04_persistence_interface.model.Point;

@Entity(name = "movement")
@Table(name = "movement")
@NamedQueries({
		@NamedQuery(name = "get.movement", query = "select distinct m from movement m where m.game=:game and m.player=:player order by id desc"),
		@NamedQuery(name = "get.last.movements", query = "select distinct m from movement m where m.game=:game and m.checker is not null and m.targetPoint is not null order by id desc"),
		@NamedQuery(name = "get.last.movement", query = "select distinct m from movement m where m.game=:game order by id desc") })
public class MovementImpl implements Movement {

	@Id
	@GeneratedValue
	@Column(name = "movement_id")
	private long id;

	private Date created;

	@ManyToOne(targetEntity = GameImpl.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "game_id", nullable = false, referencedColumnName = "game_id")
	private Game game;

	@ManyToOne(targetEntity = PlayerImpl.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "player_id", nullable = false, referencedColumnName = "player_id")
	private Player player;

	@ManyToOne(targetEntity = CheckerImpl.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "checker_id", nullable = true, referencedColumnName = "checker_id")
	private Checker checker;

	@ManyToOne(targetEntity = PointImpl.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "point_id", nullable = true, referencedColumnName = "point_id")
	private Point targetPoint;

	@OneToMany(targetEntity = DiceImpl.class, mappedBy = "movement", fetch = FetchType.EAGER)
	@OrderBy("id")
	private Set<Dice> dices;

	@Override
	public long getId() {
		return id;
	}

	@Override
	public void setId(long id) {
		this.id = id;
	}

	@Override
	public Date getCreated() {
		return created;
	}

	@Override
	public void setCreated(Date created) {
		this.created = created;
	}

	@Override
	public Player getPlayer() {
		return player;
	}

	@Override
	public void setPlayer(Player player) {
		this.player = player;
	}

	@Override
	public Checker getChecker() {
		return checker;
	}

	@Override
	public void setChecker(Checker checker) {
		this.checker = checker;
	}

	@Override
	public Point getTargetPoint() {
		return targetPoint;
	}

	@Override
	public void setTargetPoint(Point targetPoint) {
		this.targetPoint = targetPoint;
	}

	@Override
	public Set<Dice> getDices() {
		return dices;
	}

	@Override
	public void setDices(Set<Dice> dices) {
		this.dices = dices;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}
}
