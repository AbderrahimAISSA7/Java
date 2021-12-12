package characters;

import land.TilesTypes;
import players.WarGamePlayer;

/**
 * An Army is defined by its owner, its gold, the tile type it stands on, its size, and coordinates
 * @author Hamza Laghrissi, Valentin Naessens
 */
public class Army extends Character {
	
    /**
     * The size of the army
     */
    private int size;
    
    /**
     * Constructor
     * Creates an army with the given size
     * @param size the size of the army
     * @throws Exception 
     */
    public Army(WarGamePlayer owner, int size) {
    	super(owner);
    	this.size = size;
    }

    /**
     * Pays the army : by feeding every soldier
     * @return null if Army deployed successfully, else this army
     */
    public Character pay() {
    	if(this.getStandsOn() == TilesTypes.DESERT) {
    		if (((WarGamePlayer) this.owner).getFood()>=this.size*2) {
    			((WarGamePlayer) this.owner).decreaseFood(this.size*2);
        		return null;
    		}
        	else
        		return this;
    	}
    	if (((WarGamePlayer) this.owner).getFood()>=this.size) {
    		((WarGamePlayer) this.owner).decreaseFood(this.size);
    		return null;
    	}
    	else
    		return this;
    }
    
    /**
     * Decreases the army size by half
     * And deletes the army if its size is 0
     */
    public void decreaseByHalf() {
        this.size /= 2;
    }

    /**
     * Adds one to the army size
     */
    public void addOneToSize() {
    	if(this.size<5)
    		this.size += 1;
    }

    /**
     * Adds the given amount to this army's gold
     * @param n amount of gold to add
     */
    public void addGold(int n) {
        this.gold += n;
    }
    
    /**
     * Gets the army size
     * @return the size of the army
     */
    public int getSize() {
        return this.size;
    }
}