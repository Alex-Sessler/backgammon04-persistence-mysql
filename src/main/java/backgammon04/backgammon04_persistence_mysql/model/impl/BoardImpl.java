package backgammon04.backgammon04_persistence_mysql.model.impl;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import backgammon04.model.Board;
import backgammon04.model.Game;
import backgammon04.model.Point;

@Entity(name = "board")
@Table(name = "board")
public class BoardImpl implements Board {

	@Id
	@Column(name = "game_id", unique = true, nullable = false)
	private long id;

	@OneToOne(targetEntity = GameImpl.class)
	@PrimaryKeyJoinColumn
	private Game game;

	@OneToMany(targetEntity = PointImpl.class, mappedBy = "board", fetch = FetchType.EAGER)
	@OrderBy("internId")
	private Set<Point> pointList;

	@Override
	public long getId() {
		return id;
	}

	@Override
	public void setId(long id) {
		this.id = id;
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
	public Set<Point> getPointList() {
		return pointList;
	}

	@Override
	public void setPointList(Set<Point> pointList) {
		this.pointList = pointList;
	}

}
