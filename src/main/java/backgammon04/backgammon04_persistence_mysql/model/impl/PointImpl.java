package backgammon04.backgammon04_persistence_mysql.model.impl;

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

import backgammon04.model.Board;
import backgammon04.model.Checker;
import backgammon04.model.Point;

@Entity(name = "point")
@Table(name = "point")
@NamedQueries({ @NamedQuery(name = "get.point.by.internid", query = "select distinct p from point p where p.internId=:internId and p.board=:board") })
public class PointImpl implements Point {

	@Id
	@GeneratedValue
	@Column(name = "point_id")
	private long id;

	@Column(name = "intern_id")
	private byte internId;

	@ManyToOne(targetEntity = BoardImpl.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "game_id", nullable = false, referencedColumnName = "game_id")
	private Board board;

	@OneToMany(targetEntity = CheckerImpl.class, mappedBy = "point", fetch = FetchType.EAGER)
	@OrderBy("id")
	private Set<Checker> checkerList;

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
	public Board getBoard() {
		return board;
	}

	@Override
	public void setBoard(Board board) {
		this.board = board;
	}

	@Override
	public Set<Checker> getCheckerList() {
		return checkerList;
	}

	@Override
	public void setCheckerList(Set<Checker> checkerList) {
		this.checkerList = checkerList;
	}

}
