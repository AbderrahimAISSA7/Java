package game;

/**
 * The main class for the farming game
 * @author Hamza Laghrissi
 */
public class FarmingMain {

	public static void main(String[] args) {
		System.out.println("/// Farming Game \\\\\\\n");
    	System.out.println("Game map key :\nA player named \"Vigneron\" owning a FOREST tile will be represented as following :");
    	System.out.println("      Vi:1>FOREST");
    	System.out.println("And empty PLAIN tile will be represented as following :\n      --:0>PLAIN\n");
		FarmingGame farmingGame = new FarmingGame();
		farmingGame.play();
	}

}
