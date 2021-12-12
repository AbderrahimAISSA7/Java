package game;

import java.util.Scanner;

/**
 * The main class for the two games
 * @author Hamza Laghrissi
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int choice;
		do {
		System.out.print("Choose the game : \n 1 : Farming Game \n 2 : War Game\n");
		choice = sc.nextInt();
		} while(choice<1 || choice >2);
		if (choice==1) {
			FarmingGame farmingGame = new FarmingGame();
			farmingGame.play();
		}
		else {
			WarGame warGame = new WarGame();
			warGame.play();
		}
		sc.close();
	}

}
