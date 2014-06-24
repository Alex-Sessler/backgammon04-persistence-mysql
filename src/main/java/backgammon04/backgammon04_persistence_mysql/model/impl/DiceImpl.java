package backgammon04.backgammon04_persistence_mysql.model.impl;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import backgammon04.backgammon04_persistence_interface.model.Dice;
import backgammon04.backgammon04_persistence_interface.model.Movement;

@Entity(name = "dice")
@Table(name = "dice")
public class DiceImpl implements Dice {

	@Id
	@GeneratedValue
	private long id;

	private byte value;

	@ManyToOne(targetEntity = MovementImpl.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "movement_id", nullable = false, referencedColumnName = "movement_id")
	private Movement movement;

	private boolean played;

	private Date playTime;

	@Override
	public long getId() {
		return id;
	}

	@Override
	public void setId(long id) {
		this.id = id;
	}

	@Override
	public byte getValue() {
		return value;
	}

	@Override
	public void setValue(byte value) {
		this.value = value;
	}

	@Override
	public Movement getMovement() {
		return movement;
	}

	@Override
	public void setMovement(Movement movement) {
		this.movement = movement;
	}

	@Override
	public boolean isPlayed() {
		return played;
	}

	@Override
	public void setPlayed(boolean played) {
		this.played = played;
	}

	@Override
	public Date getPlayTime() {
		return playTime;
	}

	@Override
	public void setPlayTime(Date playTime) {
		this.playTime = playTime;
	}
}
