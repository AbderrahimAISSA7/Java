package game;

import players.Player;

import characters.Worker;
import land.TilesTypes;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

/**
 * A FarmingGame test file's functions
 * @author AISSA Abderrahim
 *
 */

public class FarmingGameTest {

	@Test
	public void testChooseNextMove() {
		
		String playerNames[] = {"test1", "test2"};
		FarmingGame t1 = new FarmingGame(6,7, playerNames);
		int temp= t1.chooseNextMove();
		assertTrue(temp<=3 && temp>=1);	
	}

	@Test
	public void testAddNewPlayers() {
		
		String playerNames[] = {"test1", "test2"};
		FarmingGame t1 = new FarmingGame(6,7, playerNames);
		assertEquals(t1.getPlayers().size(),2);
		t1.addNewPlayers(2);
		assertEquals(t1.getPlayers().size(),4);	
	}
	
	@Test
	public void testAddGivenPlayers() {
		String playerNames[] = {};
		FarmingGame t1 = new FarmingGame(6,7, playerNames);
		assertEquals(t1.getPlayers().size(),0);
		String playerNames2[] = {"test1", "test2"};
		t1.addGivenPlayers(playerNames2);
		assertEquals(t1.getPlayers().size(),2);
			
	}
	
	@Test
	public void testGetWinner() {
		String pn[] = {"test1", "test2"};
		FarmingGame t1 = new FarmingGame(6,7, pn);
		ArrayList<Player> ps = t1.getPlayers();
		Worker w1 = new Worker(ps.get(0));
		Worker w2 = new Worker(ps.get(1));
		w1.setStandsOn(TilesTypes.MOUNTAIN);
		w2.setStandsOn(TilesTypes.PLAIN);
		ps.get(0).addCharacter(w1);
		ps.get(1).addCharacter(w2);
		ps.get(0).getCharacters().get(0).pay();
		ps.get(1).getCharacters().get(0).pay();
		assertEquals(t1.getWinner(), ps.get(0));
	}
	

}
