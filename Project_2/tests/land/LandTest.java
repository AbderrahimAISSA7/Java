package land;

import org.junit.*;
import static org.junit.Assert.*;

import org.junit.Test;

import java.util.Random;

import characters.Army;
import characters.Worker;

import land.Land;

/**
 * @author Valentin Naessens
 */

public class LandTest {

	@Test
	public void testDefaultConstructor() {
		Land l = new Land();
		assertEquals(l.length,6);
		assertEquals(l.width,5);
	}

	@Test
	public void testParamaterizedConstructor() {
		Land l = new Land(12,9);
		assertEquals(l.getWidth(),9);
		assertEquals(l.getLength(),12);
	}

	@Test
	public void testGenerateLand() {
		//vérification qu'au moins 2/3 des cases sont des TilesTypes.OCEAN
		Land l = new Land(5,3);
		int nbCaseOcean = 0;
		for (int u=0; u<l.length; u++) {
			for (int v=0; v<l.width; v++) {
				if (l[u][v] == TilesTypes.OCEAN) {
					nbCaseOcean++;	
				}
			}			
		}
		assertTrue(nbCaseOcean > ((5*3)*(2/3)));

	}

	@Test
	public void testIsOccupied() {
		Land l = new Land();
		assertFalse(l.isOccupied(1,1));
	}

	/**
	@Test
	public void testDeployWorker() {
		Player p = new Player("joueur");
		Worker w = new Worker(p);
		//trouver une case qui n'est pas OCEAN et faire un assertTrue de DeployWorker avec cette case

	}
	*/

	@Test
	public void testGetLength() {
		Land l = new Land();
		assertEquals(l.getLength(), 6);
	}

	@Test
	public void testGetWidth() {
		Land l = new Land();
		assertEquals(l.getWidth(), 5);
	}

	@Test
	public void testGetTile() {
		Land l = new Land();
		assertEquals(l[2][3], l.getTile(2,3));
	}
}