package backgammon04.backgammon04_persistence_mysql.model.dao.impl;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import backgammon04.backgammon04_persistence_interface.model.Board;
import backgammon04.backgammon04_persistence_interface.model.Checker;
import backgammon04.backgammon04_persistence_interface.model.Game;
import backgammon04.backgammon04_persistence_interface.model.Point;
import backgammon04.backgammon04_persistence_interface.model.dao.BoardDao;
import backgammon04.backgammon04_persistence_interface.model.dao.CheckerDao;
import backgammon04.backgammon04_persistence_interface.model.dao.GameDao;
import backgammon04.backgammon04_persistence_interface.model.dao.PlayerDao;
import backgammon04.backgammon04_persistence_interface.model.dao.PointDao;
import backgammon04.backgammon04_persistence_mysql.model.impl.BoardImpl;
import backgammon04.backgammon04_persistence_mysql.model.impl.CheckerImpl;
import backgammon04.backgammon04_persistence_mysql.model.impl.GameImpl;
import backgammon04.backgammon04_persistence_mysql.model.impl.PointImpl;

@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/application-context.xml" })
public class BoardDaoTest {

	@Autowired
	BoardDao boardDao;
	@Autowired
	GameDao gameDao;
	@Autowired
	PointDao pointDao;
	@Autowired
	CheckerDao checkerDao;
	@Autowired
	PlayerDao playerDao;

	@Test
	public void test() {

		Game game = new GameImpl();
		gameDao.save(game);

		Board board = new BoardImpl();
		boardDao.save(board);

		Point point = new PointImpl();
		pointDao.save(point);

		Checker checker = new CheckerImpl();
		checkerDao.save(checker);

		checker.setPoint(point);

		game.setBoard(board);

		board.setGame(game);

		point.setBoard(board);

	}
}
