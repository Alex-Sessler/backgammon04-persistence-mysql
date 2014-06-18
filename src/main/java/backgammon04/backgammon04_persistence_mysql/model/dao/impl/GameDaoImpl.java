package backgammon04.backgammon04_persistence_mysql.model.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import backgammon04.backgammon04_persistence_mysql.model.impl.GameImpl;
import backgammon04.model.Game;
import backgammon04.model.User;
import backgammon04.model.dao.GameDao;

@Repository
@Transactional
public class GameDaoImpl extends AbstractHibernateDao implements GameDao {

	@Override
	public void save(Game game) {
		getSession().saveOrUpdate(game);
	}

	@Override
	public Game get(long id) {
		return (Game) getSession().get(GameImpl.class, id);

	}

	@Override
	public void delete(Game game) {
		getSession().delete(game);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Game> getOpenGames() {
		return (List<Game>) getSession().getNamedQuery("get.open.games").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Game> getOpenGames(User user) {
		return (List<Game>) getSession().getNamedQuery("get.started.games")
				.setEntity("user", user).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Game> getMyGames(User user) {
		return (List<Game>) getSession().getNamedQuery("get.my.games")
				.setEntity("user", user).list();
	}

}
