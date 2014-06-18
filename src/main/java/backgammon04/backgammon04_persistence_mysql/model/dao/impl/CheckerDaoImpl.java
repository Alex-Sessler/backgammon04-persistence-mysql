package backgammon04.backgammon04_persistence_mysql.model.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import backgammon04.backgammon04_persistence_mysql.model.impl.CheckerImpl;
import backgammon04.model.Checker;
import backgammon04.model.dao.CheckerDao;

@Repository
@Transactional
public class CheckerDaoImpl extends AbstractHibernateDao implements CheckerDao {

	@Override
	public void save(Checker checker) {
		getSession().saveOrUpdate(checker);
	}

	@Override
	public Checker get(long id) {
		return (Checker) getSession().get(CheckerImpl.class, id);

	}

	@Override
	public void delete(Checker checker) {
		getSession().delete(checker);
	}

}
