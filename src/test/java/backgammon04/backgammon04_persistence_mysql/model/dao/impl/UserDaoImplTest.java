package backgammon04.backgammon04_persistence_mysql.model.dao.impl;

import org.junit.After;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import backgammon04.backgammon04_persistence_interface.model.User;
import backgammon04.backgammon04_persistence_interface.model.dao.UserDao;
import backgammon04.backgammon04_persistence_mysql.model.impl.UserImpl;

@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/application-context.xml" })
public class UserDaoImplTest {

	public static final String TEST_USER_NAME = "test1";

	@Autowired
	private UserDao userDao;

	@After
	public void tearDown() {

		User us = userDao.getUser(TEST_USER_NAME);
		if (us != null) {
			userDao.delete(us);
		}
		Assert.assertNull(us);

	}

	@Test
	public void testSaveDeleteGetByUsername() {

		User user = new UserImpl();
		user.setUsername("test1");
		user.setEmail("mail1");
		user.setPassword("test1");
		userDao.save(user);

		User result = userDao.getUser(user.getUsername());

		Assert.assertEquals(user.getUsername(), result.getUsername());
		Assert.assertEquals(user.getEmail(), result.getEmail());
		Assert.assertEquals(user.getId(), result.getId());
		Assert.assertEquals(user.getPassword(), result.getPassword());

		// userDao.delete(result);
		Assert.assertNull(userDao.getUser(result.getUsername()));
	}

	@Test
	public void testSaveDeleteGetByEmail() {

		User user = new UserImpl();
		user.setUsername("test1");
		user.setEmail("mail1");
		user.setPassword("test1");
		userDao.save(user);

		User result = userDao.getByEmail(user.getEmail());
		Assert.assertEquals(user.getUsername(), result.getUsername());
		Assert.assertEquals(user.getEmail(), result.getEmail());
		Assert.assertEquals(user.getId(), result.getId());
		Assert.assertEquals(user.getPassword(), result.getPassword());

		userDao.delete(result);
		Assert.assertNull(userDao.getByEmail(result.getEmail()));
	}

	@Test
	public void testSaveDeleteGetById() {

		User user = new UserImpl();
		user.setUsername("test1");
		user.setEmail("mail1");
		user.setPassword("test1");
		userDao.save(user);

		User result = userDao.get(user.getId());
		Assert.assertEquals(user.getUsername(), result.getUsername());
		Assert.assertEquals(user.getEmail(), result.getEmail());
		Assert.assertEquals(user.getId(), result.getId());
		Assert.assertEquals(user.getPassword(), result.getPassword());

		userDao.delete(result);
		Assert.assertNull(userDao.get(result.getId()));
	}

}
