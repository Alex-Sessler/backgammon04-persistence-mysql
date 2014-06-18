package backgammon04.backgammon04_persistence_mysql.model.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import backgammon04.backgammon04_persistence_mysql.model.impl.PointImpl;
import backgammon04.model.Board;
import backgammon04.model.Point;
import backgammon04.model.dao.PointDao;

@Repository
@Transactional
public class PointDaoImpl extends AbstractHibernateDao implements PointDao {

	@Override
	public void save(Point point) {
		getSession().saveOrUpdate(point);
	}

	@Override
	public Point get(long id) {
		return (Point) getSession().get(PointImpl.class, id);
	}

	@Override
	public void delete(Point point) {
		getSession().delete(point);
	}

	@Override
	public Point get(Board board, byte internId) {
		return (Point) getSession().getNamedQuery("get.point.by.internid")
				.setEntity("board", board).setByte("internId", internId)
				.uniqueResult();
	}

}
