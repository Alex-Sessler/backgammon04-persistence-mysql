package backgammon04.backgammon04_persistence_mysql.model.dao.impl;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import backgammon04.backgammon04_persistence_mysql.model.impl.PlayerImpl;
import backgammon04.model.Game;
import backgammon04.model.Player;
import backgammon04.model.User;
import backgammon04.model.dao.PlayerDao;
import backgammon04.util.Color;

@Repository
@Transactional
public class PlayerDaoImpl extends AbstractHibernateDao implements PlayerDao {

	@Override
	public void save(Player player) {
		getSession().saveOrUpdate(player);
	}

	@Override
	public Player get(long id) {
		return (Player) getSession().get(PlayerImpl.class, id);
	}

	@Override
	public void delete(Player player) {
		getSession().delete(player);
	}

	@Override
	public Player get(Game game, Color color) {
		Player player = (Player) getSession().createCriteria(PlayerImpl.class)
				.add(Restrictions.eq("color", color))
				.add(Restrictions.eq("game", game)).uniqueResult();
		return player;
	}

	@Override
	public Player get(Game game, User user) {
		Player player = (Player) getSession().createCriteria(PlayerImpl.class)
				.add(Restrictions.eq("user", user))
				.add(Restrictions.eq("game", game)).uniqueResult();
		return player;
	}

}
