package players;

import java.util.ArrayList;
import java.util.HashMap;

import characters.Character;
import land.TilesTypes;


/**
 * A Player is defined by his gold, points, resources, and list of workers
 * @author Hamza Laghrissi
 *
 */
public abstract class Player {
	
	/**
	 * The name of the player
	 */
	protected String name;
	
	/**
	 * The gold of the player
	 */
	protected int gold;
	
	/**
	 * The resources of the player
	 */
	protected HashMap<String, Integer> resources;
	
	/**
	 * The list of characters owned by the player
	 */
	protected ArrayList<Character> characters;
	
	/**
	 * The points of the player
	 */
	protected int points;
	
	/**
	 * Creates a player with 0 points, 0 resources, 0 characters, and 15 gold
	 */
	public Player (String name) {
		this.name = name;
		this.gold = 15;
		this.points = 0;
		this.resources = new HashMap<String, Integer>();
		this.resources.put("Rocks", 0);
		this.resources.put("Sand", 0);
		this.resources.put("Wheat", 0);
		this.resources.put("Wood", 0);
		this.characters = new ArrayList<Character>();
	}
	
	/**
	 * Collects resources from owned tiles of this player
	 */
	public void collectRessources() {
		String type = null;
		for(Character w : this.characters) {
			TilesTypes t = w.getStandsOn();
			switch(t) {
				case MOUNTAIN:
					type = "Rocks";
					break;
				case DESERT:
					type = "Sand";
					break;
				case FOREST:
					type = "Wood";
					break;
				case PLAIN:
					type = "Wheat";
					break;
				case OCEAN:
					break;
			};
			this.resources.put(type, this.resources.get(type)+1);
		}
	}
	
	/**
	 * Converts this player's resources to gold
	 */
	public void ressourcesToGold() {
		if (this.resources.get("Rocks")>0) {
			this.gold += this.resources.get("Rocks")*8;
			this.resources.put("Rocks", 0);
		}
		if(this.resources.get("Sand")>0) {
			this.gold += this.resources.get("Sand")*5;
			this.resources.put("Sand", 0);
		}
		if(this.resources.get("Wheat")>0) {
			this.gold += this.resources.get("Wheat")*2;
			this.resources.put("Wheat", 0);
		}
		if(this.resources.get("Wood")>0) {
			this.gold += this.resources.get("Wood")*2;
			this.resources.put("Wood", 0);
		}
		System.out.println("--> " + this.name + " has converted his ressources to gold");
	}
	
	/**
	 * Collects the gold from owned tiles of this player
	 */
	public void collectIdleGold() {
		Character w;
		for(int i=0; i<this.characters.size(); i++) {
			w = this.characters.get(i);
			if (w.getStandsOn() == TilesTypes.FOREST || w.getStandsOn() == TilesTypes.PLAIN) {
	        	this.gold++;
	        }
	        if (w.getStandsOn() == TilesTypes.DESERT) {
	        	this.gold += 2;
	        }
		}
		System.out.println("--> " + this.name + " skipped this round, so he gets gold correspendig to the tiles he owns");
	}
	
	/**
	 * Removes the given amount of gold from this player
	 * @param i the amount to remove
	 */
	public void removeGold(int i) {
		this.gold = this.gold - i;
	}
	
	/**
	 * Adds the given amount of gold to this player
	 * @param i the amount to remove
	 */
	public void addGold(int i) {
		this.gold += i;
	}
	
	/**
	 * Adds the character to the list of characters of this player
	 * @param character the character to add
	 */
	public void addCharacter(Character character) {
		this.characters.add(character);
	}
	
	/**
	 * Gets the list of characters of this player
	 * @return list of characters
	 */
	public ArrayList<Character> getCharacters(){
		return this.characters;
	}
	
	/**
	 * Gets the gold of this player
	 * @return the gold of the player
	 */
	public int getGold() {
		return this.gold;
	}
	
	/**
	 * Gets the points of this player
	 * @return the point of the player
	 */
	public int getPoints() {
		return this.points;
	}
	
	/**
	 * Gets the name of the player
	 * @return the name of the player
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Changes the points for this player to the given value
	 */
	public void setPoints(int points) {
		this.points = points;
	}
	
	/**
	 * Prints the resources of this player 
	 */
	public void printRessources() {
		for (String i : this.resources.keySet()) {
			  System.out.print(i + " : " + this.resources.get(i) + " | ");
		}
		System.out.println();
	}
}
