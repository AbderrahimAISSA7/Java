package game;

import java.util.ArrayList;
import java.util.Scanner;

import land.Land;
import players.Player;

/**
 * A Game is defined by the land and the players
 * @author Hamza Laghrissi
 *
 */
public abstract class Game {
	/**
	 * The land
	 */
    protected Land land;
	
	/**
	 * The list of players involved in this game
	 */
    protected ArrayList <Player> players;
	
	/**
	 * True if playing randomly, else false
	 */
    protected boolean random;
	
	/**
	 * Default constructor
	 * Creates a farming game by giving the choice of the land dimensions, and the number of players to the user
	 * 
	 */
	public Game () {
		chooseLandDimensions();
		this.players = new ArrayList<Player>();
		chooseNumberOfPlayers();
		this.random = false;
	}
	
	/**
	 * Constructor
	 * Creates a game by the given land dimensions, and list of players
	 * 
	 */
	public Game (int w, int l, String args[]) {
		this.land = new Land(w,l);
		this.players = new ArrayList<Player>();
		addGivenPlayers(args);
		this.random = true;
	}

	
	/**
	 * Lets the player choose his next move
	 * @return a number corresponding to the chosen move
	 * 
	 */
	abstract public int chooseNextMove();
	
	/**
	 * Plays one round of the game with random choices
	 * @param p the player playing this turn
	 * 
	 */
	abstract public void playOneRoundRandomly(Player p);
	
	/**
	 * Plays one round of the game by giving choices to users
	 * @param p the player playing this turn
	 * 
	 */
	abstract public void playOneRound(Player p);
	
	/**
	 * Plays the game for NB_ROUNDS, gives information about who's turn is it, and updates on the different factors
	 * Finally announces the winner of the game
	 */
	abstract public void play();
	
	/**
	 * Adds the given number of new players to the players list
	 * @param nb the number of new players
	 */
	abstract public void addNewPlayers(int nb);
	
	/**
	 * Adds the given number of new players to the players list
	 * @param nb the number of new players
	 */
	abstract public void addGivenPlayers(String players[]);
	
	Scanner sc = new Scanner(System.in);
	
	/**
	 * Lets the user choose the land dimensions
	 */
	public void chooseLandDimensions() {
		int w, l;
		do {
			System.out.println("Choose the dimentions of the land:");
			System.out.println("The width > 1 : ");
			w = sc.nextInt();
			System.out.println("The length > 1 : ");
			l = sc.nextInt();
		} while(w<=1 || l<=1);
		this.land = new Land(w, l);
	}
	
	/**
	 * Lets the user choose the number of players participating in this game
	 */
	public void chooseNumberOfPlayers() {
		int nb ;
		do {
			System.out.println("How many players will be in this game:");
			nb = sc.nextInt();
		}
		while(nb<=0);
		addNewPlayers(nb);
	}
	
	/**
	 * Calculates the number of unoccupied tiles
	 * @return number of tiles that are not occupied
	 */
	public int nbNotOccupiedTiles() {
		int cpt = 0;
		for (int j=0; j<this.land.getWidth(); j++) {
    		for (int i=0; i<this.land.getLength(); i++) {
    			if(!this.land.getTile(i,j).isOccupied() && !this.land.getTile(i, j).isOcean()) {
    				cpt++;
    			}
    		}
    	}
		return cpt;
	}
	
	/**
	 * Gets the land
	 * @return the land
	 */
	public Land getLand() {
		return this.land;
	}
	
	/**
	 * Gets the list of players of this game
	 * @return the list of player of this.game
	 */
	public ArrayList <Player> getPlayers() {
		return this.players;
	}
	
}
