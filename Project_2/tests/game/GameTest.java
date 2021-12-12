package game;

import static org.junit.Assert.*;

/**
 * A Game test file's functions
 * @author AISSA Abderrahim
 *
 */

import org.junit.Test;

public class GameTest {

	@Test
	public void testNbNotOccupiedTiles(){
		String s1[] = {}; 
		Game g1 = new FarmingGame(10,10,s1);
		int cpt = 0;
		for (int j=0; j<g1.land.getWidth(); j++) {
    		for (int i=0; i<g1.land.getLength(); i++) {
    			if(!g1.land.getTile(i,j).isOccupied() && !g1.land.getTile(i, j).isOcean()) {
    				cpt++;
    			}
    		}
    	}
		assertEquals(cpt, g1.nbNotOccupiedTiles());	
	}
	
	@Test
	public void testGetPlayers() {
		String s1[] = {"boot"}; 
		Game g1 = new FarmingGame(10,10,s1);
		assertEquals(g1.getPlayers().get(0).getName(),"boot");
	}
}
