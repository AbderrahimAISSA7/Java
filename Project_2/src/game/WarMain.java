package game;

/**
 * The main class for the war game
 * @author Hamza Laghrissi
 */
public class WarMain {

	public static void main(String[] args) {
		System.out.println("/// War Game \\\\\\\n");
    	System.out.println("Game map key :\nA player named \"Vigneron\" owning a FOREST tile and has on it 3 soldiers will be represented as following :");
    	System.out.println("      Vi:3>FOREST");
    	System.out.println("And empty PLAIN tile will be represented as following :\n      --:0>PLAIN\n");
		WarGame warGame = new WarGame();
		warGame.play();
	}

}
