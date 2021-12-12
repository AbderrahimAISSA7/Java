package players;

import static org.junit.Assert.*;
import org.junit.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import characters.Character;
import land.TilesTypes;
import players.Player;

public class PlayerTest {
	@Test
	public void testCollectRessources(){
		FarmingGamePlayer p1 = new Player("joueur1");
		WarGamePlayer p2 = new Player("joueur2");
		Character c = new Worker(p1);
		Character c1 = new Army(p2, 3);
		c.setStandsOn(TilesTypes.MOUNTAIN);
		c1.setStandsOn(TilesTypes.FOREST);
		c.collectRessources();
		c1.collectRessources();
		assertEquals(c.resources.get("Rocks"), 1);
		assertEquals(c1.resources.get("Wood"), 1);

	}

	@Test
	public void testRessourcesToGold() {
		FarmingGamePlayer p1 = new Player("joueur1");
		Character c = new Worker(p1);
		c.setStandsOn(TilesTypes.MOUNTAIN);
		c.collectRessources();
		c.ressourcesToGold();
		assertEquals(p1.gold, p1.gold + 8);

	}

	@Test
	public void testCollectIdleGold(){
		FarmingGamePlayer p1 = new Player("joueur1");
		Character c = new Worker(p1);
		Character c1 = new Worker(p1);
		c.setStandsOn(TilesTypes.DESERT);
		c1.setStandsOn(TilesTypes.PLAIN);
		c.collectIdleGold();
		c1.collectIdleGold();
		assertEquals(p1.gold, p1.gold + 2 + 1 )
	}

	@Test
	public void testRemoveGold(){
		Player p1 = new Player("joueur1");
		p1.removeGold(1)
		assertEquals(p1.gold, p1.gold - 1);
	}

	@Test
	public void testAddGold(){
		Player p1 = new Player("joueur1");
		p1.addGold(1)
		assertEquals(p1.gold, p1.gold + 1);
	}

	@Test
	public void testAddCharacter(){
		Player p1 = new Player("joueur1");
		Character c = new Worker(p1);
		addCharacter(c);
		assertEquals(p1.characters.size(),1);
	}

	@Test
	public void testGetCharacter(){
		Player p1 = new Player("joueur1");
		Character c = new Worker(p1);
		addCharacter(c);
		assertEquals(p1.getCharacters(), p1.characters);
	}

	@Test
	public void testGetGold(){
		Player p1 = new Player("joueur1");
		assertEquals(p1.getGold(), p1.gold);
	}

	@Test
	public void testGetPoints(){
		Player p1 = new Player("joueur1");
		assertEquals(p1.getPoints(), p1.points);
	}

	@Test
	public void testGetName(){
		Player p1 = new Player("joueur1");
		assertEquals(p1.getName(), p1.name);
	}

	@Test
	public void testSetPoints(){
		Player p1 = new Player("joueur1");
		setPoints(15);
		assertEquals(p1.getPoints(), 15);
	}
}
