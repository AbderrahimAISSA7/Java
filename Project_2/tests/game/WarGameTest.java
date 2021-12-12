package game;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;
import characters.Army;
import land.TilesTypes;
import players.Player;
import players.WarGamePlayer;

/**
 * A WarGame test file's functions
 * @author AISSA Abderrahim
 *
 */

public class WarGameTest {

	@Test
	public void testChooseNextMove() {
		String playerNames[] = {"test1", "test2"};
		WarGame t1 = new WarGame(5,5, playerNames);
		int temp= t1.chooseNextMove();
		assertTrue(temp<=2 && temp>=1);
	}
	@Test
	public void testAddNewPlayers() {
		String playerNames[] = {"test1"};
		WarGame t1 = new WarGame(5,5, playerNames);
		assertEquals(t1.getPlayers().size(),1);
		t1.addNewPlayers(3);
		assertEquals(t1.getPlayers().size(),4);	
	}
	@Test
	public void testAddGivenPlayers() {
		String playerNames[] = {};
		WarGame t1 = new WarGame(5,5, playerNames);
		assertEquals(t1.getPlayers().size(),0);
		String playerNames2[] = {"test1", "test2","test3"};
		t1.addGivenPlayers(playerNames2);
		assertEquals(t1.getPlayers().size(),3);
	}
	
	@Test
	public void testDeployingChecks() {
		String pn[] = {"Dam", "Sam"};
		WarGame w1 = new WarGame(7,7,pn);
		ArrayList<Player> ps = w1.getPlayers();
		Army a1 = new Army((WarGamePlayer)ps.get(0),3);
		Army a2 = new Army((WarGamePlayer)ps.get(1),2);
		for (int i = 0; i < 7; i++) {
			boolean mustEnd = false;
			for(int j = 0; j < 7; j++) {
				if(!w1.getLand().getTile(i,j).isOcean()) {
					a1.deployCharacter(i,j, w1.getLand(), false);
					w1.deployingChecks(i,j ,ps.get(0) , a1);
					if(j+1<7 && !w1.getLand().getTile(i,j+1).isOcean() && mustEnd == false) {	
						a2.deployCharacter(i,j+1, w1.getLand(), false);
						
						mustEnd = true ; 
						break;
						}
					if(j-1>=0 && !w1.getLand().getTile(i,j-1).isOcean() && mustEnd == false) {	
						a2.deployCharacter(i,j-1, w1.getLand(), false);
						
						mustEnd = true ;
						break;
						}
					if(i+1>=0 && !w1.getLand().getTile(i+1,j).isOcean() && mustEnd == false) {	
						a2.deployCharacter(i+1,j, w1.getLand(), false);
						
						mustEnd = true ;
						break;
						}
					if(i-1<7 && !w1.getLand().getTile(i-1,j).isOcean() && mustEnd == false) {	
						a2.deployCharacter(i-1,j, w1.getLand(), false);
						
						mustEnd = true ; 
						break;
						}
				}
				w1.deployingChecks(i,j+1 ,ps.get(1) , a2);
			}
			if(mustEnd == true) break;
		}
		//assertEquals(a2.getSize(),1);
		
	}
	
	@Test
	public void testGetWinner() {
		String pn[] = {"test1", "test2"};
		WarGame t1 = new WarGame(6,7, pn);
		ArrayList<Player> ps = t1.getPlayers();
		Army a1 = new Army((WarGamePlayer)ps.get(0),4);
		Army a2 = new Army((WarGamePlayer)ps.get(1),3); 
		a1.setStandsOn(TilesTypes.DESERT);
		a2.setStandsOn(TilesTypes.PLAIN);
		ps.get(0).addCharacter(a1);
		ps.get(1).addCharacter(a2);
		assertEquals(t1.getWinner(), ps.get(0));
		
	}
	

}
