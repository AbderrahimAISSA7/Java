package game;

import java.util.ArrayList;

import characters.Character;
import characters.Worker;
import players.FarmingGamePlayer;
import players.Player;

/**
 * A Farming Game is defined by the land, number of rounds, and the players
 * @author Hamza Laghrissi
 *
 */
public class FarmingGame extends Game{
	
	/**
	 * The number of rounds in the game
	 */
	private static final int NB_ROUNDS = 6;
	
	/**
	 * Default constructor
	 * Creates a farming game by giving the choice of the land dimensions, and the number of players to the user
	 * 
	 */
	public FarmingGame () {
		super();
	}
	
	/**
	 * Constructor
	 * Creates a game by the given land dimensions, and list of players
	 * 
	 */
	public FarmingGame (int w, int l, String args[]) {
		super(w, l, args);
	}
	
	/**
	 * Lets the player choose his next move
	 * @return a number corresponding to the chosen move
	 * 
	 */
	public int chooseNextMove() {
		int move;
		do{
			System.out.println("1 : Deploy a worker on an available tile in order to acquire a territory ");
			System.out.println("2 : Exchange resources for gold ");
			System.out.println("3 : Wait ");
			move = sc.nextInt();
		}
		while(move<1 || move>3);
		return move;
	}
	
	/**
	 * Plays one round of the game with random choices
	 * @param p the player playing this turn
	 * 
	 */
	public void playOneRoundRandomly(Player p) {
		int move = (int)Math.floor(Math.random()*3 + 1);
		switch(move) {
			case 1 :
				int x,y;
				Character c = new Worker(p);
				do {
					x = (int)Math.floor(Math.random()*(this.land.getLength()));
					y = (int)Math.floor(Math.random()*(this.land.getWidth()));
				} while ( !c.deployCharacter(x, y, this.land, this.random) );
				p.addCharacter(c);
				break;
			case 2:
					p.ressourcesToGold();
				break;
			case 3:
				p.collectIdleGold();
			break;
		}
	}
	
	/**
	 * Plays one round of the game by giving choices to users
	 * @param p the player playing this turn
	 * 
	 */
	public void playOneRound(Player p) {
		System.out.println("Choose your next move ");
		int move = chooseNextMove();
		switch(move) {
			case 1 :
				int x,y;
				Character c = new Worker(p);
				do {
					System.out.println("Enter the coordinates of where you want to deploy the worker.");
					System.out.println("x = ");
					x = sc.nextInt();
					System.out.println("y = ");
					y = sc.nextInt();
				} while ( (x<0 || x>=this.land.getLength()) || (y<0 || y>=this.land.getWidth()) || (!c.deployCharacter(x, y, this.land, this.random)) );
				p.addCharacter(c);
				break;
			case 2:
					p.ressourcesToGold();
				break;
			case 3:
				p.collectIdleGold();
			break;
		}
	}
	
	/**
	 * Plays the game for NB_ROUNDS, gives information about who's turn is it, and updates on the different factors
	 * Finally announces the winner of the game
	 */
	public void play() {
		ArrayList<Character> toRemove = new ArrayList<Character>();
		int points;
		for(int i=0; i<FarmingGame.NB_ROUNDS; i++) {
			if(this.nbNotOccupiedTiles() == 0) {
				System.out.println("\nThere is no more tiles to conquer");
				break;
			}
			System.out.println("----------- ROUND " + (i+1) + " -----------");
			this.land.printLand();
			for (int j=0; j<this.players.size(); j++) {
				System.out.println(this.players.get(j).getName() + ":");
				System.out.println("     Gold         : " + this.players.get(j).getGold());
				System.out.println("     Workers      : " + this.players.get(j).getCharacters().size());
				System.out.print("     Ressources   : " );
				this.players.get(j).printRessources();
				if(this.nbNotOccupiedTiles() == 0)
					break;
				if(this.random)
					playOneRoundRandomly(this.players.get(j));
				else
					playOneRound(this.players.get(j));
				this.players.get(j).collectRessources();
				Character ch;
				for (Character c : this.players.get(j).getCharacters() ) {
					ch = c.pay();
					if(ch != null) {
						toRemove.add(ch);
						this.land.getTile(ch.getX(), ch.getY()).setOccupiedBy(null);
					}
				}
				this.players.get(j).getCharacters().removeAll(toRemove);
				points = 0;
				for(Character c : this.players.get(j).getCharacters()) {
					points += c.getGold();
				}
				this.players.get(j).setPoints(points);
			}
		}
		System.out.println("\n----------- THE GAME IS OVER -----------");
		for(int i=0; i<this.players.size(); i++) {
			System.out.println(this.players.get(i).getName() + " has " + this.players.get(i).getPoints() + " points");
		}
		System.out.println("\n" + this.getWinner().getName() + " is the winner");
	}
	
	/**
	 * Adds the given number of new players to the players list
	 * @param nb the number of new players
	 */
	public void addNewPlayers(int nb) {
		String name;
		for (int i=0; i<nb; i++) {
			System.out.println("Enter the name of player number " + (i+1));
			name = sc.next();
			this.players.add(new FarmingGamePlayer(name));
		}
	}
	
	/**
	 * Adds the given array of players to the players list
	 * @param players array of players
	 */
	public void addGivenPlayers(String players[]) {
		for (int i=0; i<players.length; i++) {
			this.players.add(new FarmingGamePlayer(players[i]));
		}
	}
	
	/**
	 * Gets the winner of the game
	 * @return the name of the winner
	 */
	public Player getWinner() {
		int max = 0, s;
		Player winner = null;
		for (int i=0; i<this.players.size(); i++) {
			s=0;
			for (Character c : this.players.get(i).getCharacters()) {
				s += c.getGold();
			}
			if(max < s) {
				max = s;
				winner = this.players.get(i);
			}
		}
		return winner;
	}
	
}
