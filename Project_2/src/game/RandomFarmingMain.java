package game;

/**
 * The main class for the farming game
 * @author Hamza Laghrissi
 */
public class RandomFarmingMain {
	
	public static void main(String[] args) throws Exception {
		System.out.println("/// Farming Game \\\\\\\n");
		System.out.println("usage : java -jar jar/agricole.jar name1 name2 (default : Vigneron Eleveur Maraicher)");
    	System.out.println("Game map key :\nA player named \"Vigneron\" owning a FOREST tile will be represented as following :");
    	System.out.println("      Vi:1>FOREST");
    	System.out.println("And empty PLAIN tile will be represented as following :\n      --:0>PLAIN\n");
		if (args.length == 0 ) {
			String[] def = {"Vigneron", "Eleveur", "Maraicher"};
			FarmingGame farmingGame = new FarmingGame(10,10, def);
			farmingGame.play();
		}
		else {
			FarmingGame farmingGame = new FarmingGame(10,10, args);
			farmingGame.play();
		}
	}
	
}
