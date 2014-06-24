package backgammon04.backgammon04_persistence_mysql.model.dao.impl;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import backgammon04.backgammon04_persistence_interface.model.User;
import backgammon04.backgammon04_persistence_interface.model.dao.UserDao;
import backgammon04.backgammon04_persistence_mysql.model.impl.UserImpl;

@Repository
@Transactional
public class UserDaoImpl extends AbstractHibernateDao implements UserDao {

	public void save(User user) {
		getSession().saveOrUpdate(user);
	}

	@Override
	public User get(long id) {
		return (User) getSession().get(UserImpl.class, id);
	}

	@Override
	public User getUser(String username) {
		User user = (User) getSession().createCriteria(UserImpl.class)
				.add(Restrictions.eq("username", username)).uniqueResult();
		return user;
	}

	@Override
	public void delete(User user) {
		getSession().delete(user);
	}

	@Override
	public User getByEmail(String email) {
		User user = (User) getSession().createCriteria(UserImpl.class)
				.add(Restrictions.eq("email", email)).uniqueResult();
		return user;
	}
}
