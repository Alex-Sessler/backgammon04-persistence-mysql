package backgammon04.backgammon04_persistence_mysql.model.impl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import backgammon04.model.Checker;
import backgammon04.model.Player;
import backgammon04.model.Point;

@Entity(name = "checker")
@Table(name = "checker")
public class CheckerImpl implements Checker {

	@Id
	@GeneratedValue
	@Column(name = "checker_id")
	private long id;

	@Column(name = "intern_id")
	private byte internId;

	@ManyToOne(targetEntity = PlayerImpl.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "player_id", nullable = true, referencedColumnName = "player_id")
	private Player player;

	@ManyToOne(targetEntity = PointImpl.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "point_id", nullable = false, referencedColumnName = "point_id")
	private Point point;

	@Override
	public long getId() {
		return id;
	}

	@Override
	public void setId(long id) {
		this.id = id;
	}

	@Override
	public byte getInternId() {
		return internId;
	}

	@Override
	public void setInternId(byte internId) {
		this.internId = internId;
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
	public Point getPoint() {
		return point;
	}

	@Override
	public void setPoint(Point point) {
		this.point = point;
	}

}
