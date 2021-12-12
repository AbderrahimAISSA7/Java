package characters;

import static org.junit.Assert.*;

import org.junit.Test;

import land.TilesTypes;
import players.FarmingGamePlayer;

/**
 * @author Hamza Laghrissi
 */
public class WorkerTest {

	@Test
	public void testWorkerConstructor() {
		FarmingGamePlayer p = new FarmingGamePlayer("test");
		Worker w = new Worker(p);
		assertNotNull(w);
	}
	
	@Test
	public void testPay() {
		FarmingGamePlayer p = new FarmingGamePlayer("test");
		Worker w = new Worker(p), test;

		assertEquals(w.getGold(), 0);
		p.addGold(-(p.getGold()));
		assertEquals(p.getGold(), 0);
		//If the player doesn't have enough gold
		w.setStandsOn(TilesTypes.MOUNTAIN);
		test = w.pay();
		assertEquals(w.getGold(), 0);
		assertEquals(test, w);
		//If standing on a mountain tile
		p.addGold(12);
		assertEquals(p.getGold(), 12);
		test = w.pay();
		assertEquals(w.getGold(), 5);
		assertEquals(p.getGold(), 7);
		assertNull(test);
		//on a desert tile
		w.setStandsOn(TilesTypes.DESERT);
		test = w.pay();
		assertEquals(w.getGold(), 8);
		assertEquals(p.getGold(), 4);
		//on a plain tile
		w.setStandsOn(TilesTypes.PLAIN);
		test = w.pay();
		assertEquals(w.getGold(), 9);
		assertEquals(p.getGold(), 3);
		//on a forest tile
		w.setStandsOn(TilesTypes.FOREST);
		test = w.pay();
		assertEquals(w.getGold(), 10);
		assertEquals(p.getGold(), 2);
	}

}
