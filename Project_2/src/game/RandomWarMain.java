package game;

/**
 * The main class for the war game
 * @author Hamza Laghrissi
 */
public class RandomWarMain {

	public static void main(String[] args) {
		System.out.println("/// War Game \\\\\\\n");
		System.out.println("usage : java -jar jar/guerre.jar name1 name2 (default : Vigneron Eleveur Maraicher)\n");
    	System.out.println("Game map key :\nA player named \"Vigneron\" owning a FOREST tile and has on it 3 soldiers will be represented as following :");
    	System.out.println("      Vi:3>FOREST");
    	System.out.println("And empty PLAIN tile will be represented as following :\n      --:0>PLAIN\n");
		if (args.length == 0 ) {
			String[] def = {"Vigneron", "Eleveur", "Maraicher"};
			WarGame warGame = new WarGame(10, 10, def);
			warGame.play();
		}
		else {
			WarGame warGame = new WarGame(10,10, args);
			warGame.play();
		}
	}

}
