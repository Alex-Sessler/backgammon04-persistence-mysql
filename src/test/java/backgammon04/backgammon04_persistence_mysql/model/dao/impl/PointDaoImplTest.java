package backgammon04.backgammon04_persistence_mysql.model.dao.impl;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import backgammon04.backgammon04_persistence_mysql.model.impl.BoardImpl;
import backgammon04.backgammon04_persistence_mysql.model.impl.GameImpl;
import backgammon04.backgammon04_persistence_mysql.model.impl.PointImpl;
import backgammon04.model.Board;
import backgammon04.model.Game;
import backgammon04.model.Point;
import backgammon04.model.dao.BoardDao;
import backgammon04.model.dao.GameDao;
import backgammon04.model.dao.PointDao;

@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/application-context.xml" })
public class PointDaoImplTest {

	@Autowired
	GameDao gameDao;

	@Autowired
	BoardDao boardDao;

	@Autowired
	PointDao pointDao;

	@Test
	public void test() {

		Game game = new GameImpl();
		gameDao.save(game);

		Board board = new BoardImpl();

		game.setBoard(board);

		board.setGame(game);
		boardDao.save(board);

		Point point = new PointImpl();
		point.setBoard(board);

		pointDao.save(point);

		Point result = pointDao.get(point.getId());
		Assert.assertEquals(board.getGame().getId(), result.getBoard()
				.getGame().getId());

		gameDao.delete(game);
		boardDao.delete(board);
		pointDao.delete(point);
	}
}
