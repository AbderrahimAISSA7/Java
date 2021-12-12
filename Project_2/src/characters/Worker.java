package characters;

import land.TilesTypes;
import players.Player;

/**
 * A worker is defined by his owner, his gold, the type of the tile he stands on and coordinates
 * @author Hamza Laghrissi
 */
public class Worker extends Character{
    
    /**
     * Creates a worker with 0 gold and stands on null
     * @param owner the owner of the character
     */
    public Worker(Player owner) {
    	super(owner);
    }

    /**
     * Pays the worker : adds gold to this worker, and removes it from the owner
     * @return null if Worker deployed successfully, else this Worker
     */
    public Worker pay() {
    	Worker w = null;
    	if (this.standsOn == TilesTypes.MOUNTAIN) {
    		if (this.owner.getGold() >= 5) {
    			this.gold += 5;
    			this.owner.removeGold(5);
    		}
    		else {
    			w = this;
    		}
    	}
    	if (this.standsOn == TilesTypes.DESERT) {
    		if (this.owner.getGold() >= 3) {
    			this.gold += 3;
    			this.owner.removeGold(3);
    		}
    		else {
    			w = this;
    		}
    	}
    	if (this.standsOn == TilesTypes.PLAIN || this.standsOn == TilesTypes.FOREST) {
    		if(this.owner.getGold() >= 1) {
    			this.gold += 1;
    			this.owner.removeGold(1);
    		}
    		else {
    			w = this;
    		}
    	}
    	return w;
    }
    
}