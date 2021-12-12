package players;
import static org.junit.Assert.*;
import org.junit.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import players.WarGamePlayer;


public class WarGamePlayerTest{
  @Test
  public void testRessourceToFood(){
    WarGamePlayer p1 = new WarGamePlayer("joueur1");
    Character c = new Army(p1, 2);
    c.setStandsOn(TilesTypes.PLAIN);
    c.collectRessources();
    c.ressourceToFood();
    assertEquals(p1.food, p1.food + 5);
  }

  @Test
  public void testDecreaseSoldiers(){
    WarGamePlayer p1 = new WarGamePlayer("joueur1");
    p1.decreaseSoldiers(10);
    assertEquals(p1.soldiers, p1.soldiers - 10);
  }

  @Test
  public void testDecreaseFood(){
    WarGamePlayer p1 = new WarGamePlayer("joueur1");
    p1.decreaseFood(5);
    assertEquals(p1.food, p1.food - 5);
  }

  @Test
  public void testGetFood(){
    WarGamePlayer p1 = new WarGamePlayer("joueur1");
    assertEquals(p1.getFood(), p1.food);
  }

  @Test
  public void testGetSoldiers(){
    WarGamePlayer p1 = new WarGamePlayer("joueur1");
    assertEquals(p1.getSoldiers(), p1.soldiers);
  }




}
