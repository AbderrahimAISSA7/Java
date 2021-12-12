package characters;

import static org.junit.Assert.*;

import org.junit.Test;

import land.TilesTypes;
import players.WarGamePlayer;

/**
 * @author Hamza Laghrissi
 */
public class ArmyTest {

	@Test
	public void testPay() {
		WarGamePlayer p = new WarGamePlayer("test");
		Army a = new Army(p, 3), test;
		assertEquals(p.getFood(), 10);
		a.setStandsOn(TilesTypes.DESERT);
		//Stands on DESERT
		test = (Army) a.pay();
		assertEquals(p.getFood(), 4);
		assertNull(test);
		//Don't stand on DESERT
		a.setStandsOn(TilesTypes.FOREST);
		test = (Army) a.pay();
		assertEquals(p.getFood(), 1);
		assertNull(test);
		//Player doesn't have enough food to pay his army
		int old = p.getFood();
		assertTrue(p.getFood() < a.getSize());
		test = (Army) a.pay();
		assertEquals(p.getFood(), old);
		assertEquals(test, a);
	}
	
	@Test
	public void testDecreaseByHalf() {
		WarGamePlayer p = new WarGamePlayer("test");
		Army a = new Army(p, 4);
		assertEquals(a.getSize(), 4);
		a.decreaseByHalf();
		assertEquals(a.getSize(), 2);
	}

	@Test
	public void testAddOneToSize() {
		WarGamePlayer p = new WarGamePlayer("test");
		Army a = new Army(p, 3);
		assertEquals(a.getSize(), 3);
		a.addOneToSize();
		assertEquals(a.getSize(), 4);
	}

	@Test
	public void testAddGold() {
		WarGamePlayer p = new WarGamePlayer("test");
		Army a = new Army(p, 3);
		assertEquals(a.getGold(), 0);
		a.addGold(7);;
		assertEquals(a.getGold(), 7);
	}

	@Test
	public void testGetSize() {
		WarGamePlayer p = new WarGamePlayer("test");
		Army a = new Army(p, 3);
		assertEquals(a.getSize(), 3);
	}

}
