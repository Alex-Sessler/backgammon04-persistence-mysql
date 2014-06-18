package backgammon04.backgammon04_persistence_mysql.model.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import backgammon04.backgammon04_persistence_mysql.model.impl.MovementImpl;
import backgammon04.model.Game;
import backgammon04.model.Movement;
import backgammon04.model.Player;
import backgammon04.model.dao.MovementDao;

@Repository
@Transactional
public class MovementDaoImpl extends AbstractHibernateDao implements
		MovementDao {

	@Override
	public void save(Movement movement) {
		getSession().saveOrUpdate(movement);
	}

	@Override
	public Movement get(long id) {
		return (Movement) getSession().get(MovementImpl.class, id);
	}

	@Override
	public void delete(Movement movement) {
		getSession().delete(movement);
	}

	@Override
	public Movement get(Game game, Player player) {
		return (Movement) getSession().getNamedQuery("get.movement")
				.setEntity("game", game).setEntity("player", player)
				.setMaxResults(1).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Movement> getLast(Game game, int lastSize) {
		return (List<Movement>) getSession()
				.getNamedQuery("get.last.movements").setEntity("game", game)
				.setMaxResults(lastSize).list();

	}

	@Override
	public Movement getLast(Game game) {
		return (Movement) getSession().getNamedQuery("get.last.movement")
				.setEntity("game", game).setMaxResults(1).uniqueResult();
	}

}
