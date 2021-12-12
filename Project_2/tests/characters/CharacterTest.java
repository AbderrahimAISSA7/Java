package characters;

import static org.junit.Assert.*;

import org.junit.Test;

import land.Land;
import land.TilesTypes;
import players.FarmingGamePlayer;
import players.WarGamePlayer;

/**
 * @author Hamza Laghrissi
 */
public class CharacterTest {

	@Test
	public void testDeployCharacter() {
		Land land = new Land();
		FarmingGamePlayer fp = new FarmingGamePlayer("test1"); 
		WarGamePlayer wp = new WarGamePlayer("test2");
		Character w = new Worker(fp);
		Character a1 = new Army(wp, 2);
		Character a2 = new Army(wp, 5);
		boolean t1, t2, t3;
		t1 = t2 = t3 = false;
		
    	for (int j=0; j<land.getWidth() ; j++) {
    		for (int i=0; i<land.getLength() ; i++) {
    			//Testing deploying on an OCEAN tile type
    			if(land.getTile(i, j).getType() == TilesTypes.OCEAN) {
    				assertFalse(w.deployCharacter(i, j, land, false));
    				assertFalse(a1.deployCharacter(i, j, land, false));
    				t1 = true;
    			}
    			else {
    				//Testing deploying an army with size <=3 and another one of size >3 on a DESERT or MOUNTAIN tile type
    				if(!t2 && land.getTile(i, j).getType() == TilesTypes.MOUNTAIN || land.getTile(i, j).getType() == TilesTypes.DESERT) {
    					assertFalse(a2.deployCharacter(i, j, land, false));
    					assertTrue(a1.deployCharacter(i, j, land, false));
    					assertEquals(land.getTile(i, j).getOccupiedBy(), a1);
        				assertEquals(a1.getStandsOn(), land.getTile(i, j).getType());
        				assertEquals(a1.getX(), i);
        				assertEquals(a1.getY(), j);
        				t2=true;
    				}
    				//Testing deploying a character on a normal tile, and deploying another one on the same tile
    				if(!t3 && !land.getTile(i, j).isOccupied()) {
    					assertTrue(w.deployCharacter(i, j, land, false));
    					assertEquals(land.getTile(i, j).getOccupiedBy(), w);
    					assertEquals(w.getStandsOn(), land.getTile(i, j).getType());
    					assertEquals(w.getX(), i);
    					assertEquals(w.getY(), j);
    					assertFalse(a1.deployCharacter(i, j, land, false));
    					t3=true;
    				}
    			}
    			if (t1 && t2 && t3)
        			break;
    		}
    		if (t1 && t2 && t3)
    			break;
    	}
		
	}

	@Test
	public void testSetCoordinates() {
		FarmingGamePlayer p = new FarmingGamePlayer("test");
		Character c = new Worker(p);
		
		assertEquals(c.getX(), -1);
		assertEquals(c.getY(), -1);
		c.setCoordinates(6, 3);
		assertEquals(c.getX(), 6);
		assertEquals(c.getY(), 3);
	}

	@Test
	public void testSetStandsOn() {
		FarmingGamePlayer p = new FarmingGamePlayer("test");
		Character c = new Worker(p);
		
		assertNull(c.getStandsOn());
		c.setStandsOn(TilesTypes.MOUNTAIN);
		assertEquals(c.getStandsOn(), TilesTypes.MOUNTAIN);
	}

	@Test
	public void testGetX() {
		FarmingGamePlayer p = new FarmingGamePlayer("test");
		Character c = new Worker(p);
		
		assertEquals(c.getX(), -1);
	}

	@Test
	public void testGetY() {
		FarmingGamePlayer p = new FarmingGamePlayer("test");
		Character c = new Worker(p);
		
		assertEquals(c.getX(), -1);
	}

	@Test
	public void testGetOwner() {
		FarmingGamePlayer p = new FarmingGamePlayer("test");
		Character c = new Worker(p);
		
		assertEquals(c.getOwner(), p);
	}

	@Test
	public void testGetGold() {
		FarmingGamePlayer p = new FarmingGamePlayer("test");
		Character c = new Worker(p);
		
		assertEquals(c.getGold(), 0);
	}

	@Test
	public void testGetStandsOn() {
		FarmingGamePlayer p = new FarmingGamePlayer("test");
		Character c = new Worker(p);
		
		c.setStandsOn(TilesTypes.FOREST);
		assertEquals(c.getStandsOn(), TilesTypes.FOREST);
	}

}
