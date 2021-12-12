package land;

import characters.Character;

/**
 * A tile is defined by its type and the character standing on it
 * @author Hamza Laghrissi
 * 
 */
public class Tiles {
	
    /**
     * The character standing on this tile
     */
    private Character occupiedBy;

    /**
     * The type of this tile
     */
    private TilesTypes type;
    
    /**
     * Constructor
     * Creates a tile with the given type, and a null character
     * @param type a tile type
     * 
     */
    public Tiles(TilesTypes type) {
    	this.occupiedBy = null;
    	this.type = type;
    }
    
    /**
     * Checks if this tile is occupied
     * @return true if this tile is occupied, else false
     * 
     */
    public boolean isOccupied() {
        if (this.occupiedBy == null)
        		return false;
        return true;
    }
    
    /**
     * Checks if this tile's type is ocean
     * @return true if this tile's is ocean, else false
     * 
     */
    public boolean isOcean() {
    	if (this.type == TilesTypes.OCEAN) 
    		return true;
    	return false;
    }
    
    /**
     * Changes the worker or the army occupying this tile
     * @param character a playable character (army or worker)
     */
    public void setOccupiedBy(Character character) {
        this.occupiedBy = character;
    }
    
    /**
     * Gets the type of this tile
     * @return the type of the tile
     * 
     */
    public TilesTypes getType() {
        return this.type;
    }

    /**
     * Gets the Worker standing on this tile
     * @return the character standing on the tile
     */
    public Character getOccupiedBy() {
    	return this.occupiedBy;
    }
}