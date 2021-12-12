package land;

import org.junit.*;
import static org.junit.Assert.*;

import org.junit.Test;

import characters.Character;
import players.Player;

import land.Tiles;

/**
 * @author Valentin Naessens
 */

public class TilesTest {
	
	@Test
	public void testConstructor() {
		Tile t = new Tile(TilesTypes.MOUNTAIN);
		assertEquals(t.type, TilesTypes.MOUNTAIN);
		assertNull(t.occupiedBy);
	}

	@Test
	public void testIsOccupied() {
		Tile t = new Tile(TilesTypes.MOUNTAIN);
		assertFalse(t.isOccupied());
	}

	@Test
	public void testIsOcean() {
		Tile t1 = new Tile(TilesTypes.MOUNTAIN);
		assertFalse(t1.isOcean());

		Tile t2 = new Tile(TilesTypes.OCEAN);
		assertTrue(t2.isOcean());
	}

	@Test
	public void testGetOccupiedBy(){
		Tile t = new Tile(TilesTypes.MOUNTAIN);
		assertNull(t.getOccupiedBy());
	}

	@Test
	public void testGetType() {
		Tile t = new Tile(TilesTypes.MOUNTAIN);
		assertEquals(TilesTypes.MOUNTAIN, t.getType());
	}

	@Test
	public void testSetOccupiedBy() {
		Player p = new Player("joueur");
		Character c = new Character(p);
		Tile t = new Tile(TilesTypes.MOUNTAIN);

		t.setOccupiedBy(c);

		assertTrue(t.isOccupied());
		assertEquals(t.occupiedBy, c);
	}
}