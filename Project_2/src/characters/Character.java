package characters;

import land.Land;
import land.TilesTypes;
import players.Player;


/**
 * Every character is defined by his owner, his gold, the tile type he stands on, and coordinates
 * @author Hamza Laghrissi
 *
 */
public abstract class Character {

	/**
	 * The owner
	 */
	protected Player owner;
	
    /**
     * The gold of the character
     */
    protected int gold;

    /**
     * The type of the tile the character stands on
     */
    protected TilesTypes standsOn;
    
    /**
     * Coordinates of the character
     */
    protected int x, y;

    /**
     * Creates a character with the given owner, with 0 gold, and standing on null
     * @param p the Player who has the character
     * 
     */
    public Character(Player p) {
    	this.owner = p;
    	this.gold = 0;
    	this.standsOn = null;
    	this.x = -1;
    	this.y = -1;
    }
    
    /*
     * Pays the character
     */
    public abstract Character pay();
    
	/**
	 * Deploys a character in the given indexes
	 * @param x index
	 * @param y index
	 * @param land the land
	 * @param random true if choices are random, else false
	 * @return True if the worker deployed successfully
	 */
    public boolean deployCharacter(int x, int y, Land land, boolean random) {
		if (!land.getTile(x, y).isOccupied()) {
			if (!land.getTile(x, y).isOcean()) {
				if(land.getTile(x, y).getType() == TilesTypes.MOUNTAIN || land.getTile(x, y).getType() == TilesTypes.DESERT) {
					if (this instanceof Army) {
						Army other = (Army) this;
						if(other.getSize() >3) {
							System.out.println("You can't deploy an army of more than 3 soldiers on a " + land.getTile(x, y).getType() + " tile");
							return false;
						}
					}
				}
				land.getTile(x, y).setOccupiedBy(this);
				this.setStandsOn(land.getTile(x, y).getType());
				this.setCoordinates(x, y);
				if (this instanceof Army) {
					Army other = (Army) this;
					System.out.println("--> " + this.getOwner().getName() + " has deployed an army of "+ other.getSize() + " soldier on x: " + x + " y: " + y);
				}
				else 
					System.out.println("--> " + this.getOwner().getName() + " has deployed a worker on x: " + x + " y: " + y);
				return true;
			}
			else {
				if(!random)
					System.out.println("You can't deploy a character on ocean");
				return false;
			}
			
		}
		else {
			if(!random)
				System.out.println("This tile is already occupied");
			return false;
		}
		
	}    
    
    /**
     * Changes the coordinates of this character
     * @param x the x coordinate
     * @param y the y coordinate
     * 
     */
    public void setCoordinates(int x, int y) {
    	this.x = x;
    	this.y = y;
    }
    
    /**
     * Changes the standing on type
     * @param standsOn
     */
    public void setStandsOn(TilesTypes standsOn) {
    	this.standsOn = standsOn;
    }
    
    /**
     * Gets the x coordinate
     * @return x coordinate
     */
    public int getX() {
    	return this.x;
    }
    
    /**
     * Gets the y coordinate
     * @return y coordinate
     */
    public int getY() {
    	return this.y;
    }
    
    /**
     * Gets the owner of the character
     * @return the owner of the character
     */
    public Player getOwner() {
    	return this.owner;
    }
    
    /**
     * Gets the gold of the character
     * @return the gold of the character
     */
    public int getGold() {
        return this.gold;
    }

    /**
     * Gets the standing on type
     * @return the standing on type
     */
    public TilesTypes getStandsOn() {
        return this.standsOn;
    }

}