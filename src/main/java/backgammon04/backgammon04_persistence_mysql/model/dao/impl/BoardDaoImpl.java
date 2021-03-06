package backgammon04.backgammon04_persistence_mysql.model.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import backgammon04.backgammon04_persistence_interface.model.Board;
import backgammon04.backgammon04_persistence_interface.model.dao.BoardDao;
import backgammon04.backgammon04_persistence_mysql.model.impl.BoardImpl;

@Repository
@Transactional
public class BoardDaoImpl extends AbstractHibernateDao implements BoardDao {

	@Override
	public void save(Board board) {
		getSession().saveOrUpdate(board);
	}

	@Override
	public Board get(long id) {
		return (Board) getSession().get(BoardImpl.class, id);
	}

	@Override
	public void delete(Board board) {
		getSession().delete(board);
	}

}
