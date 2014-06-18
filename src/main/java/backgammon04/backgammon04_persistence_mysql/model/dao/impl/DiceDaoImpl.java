package backgammon04.backgammon04_persistence_mysql.model.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import backgammon04.backgammon04_persistence_mysql.model.impl.DiceImpl;
import backgammon04.model.Dice;
import backgammon04.model.dao.DiceDao;

@Repository
@Transactional
public class DiceDaoImpl extends AbstractHibernateDao implements DiceDao {

	@Override
	public void save(Dice dice) {
		getSession().saveOrUpdate(dice);
	}

	@Override
	public Dice get(long id) {
		return (Dice) getSession().get(DiceImpl.class, id);
	}

	@Override
	public void delete(Dice dice) {
		getSession().delete(dice);
	}

}
