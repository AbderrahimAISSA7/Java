package land;

import java.util.Random;

import characters.Army;
import characters.Worker;

/**
 * A land is defined by its length, width, and a 2D array representing it
 * @author Hamza Laghrissi, Valentin Naessens
 */
public class Land {

    /**
     * Length of land
     */
    private int length;

    /**
     * Width of land
     */
    private int width;

    /**
     * The land in a 2d array
     */
    private Tiles[][] land;
    
    /**
     * Default constructor
     * Creates a default Land : length = 6 ; width = 5
     */
    public Land() {
    	this.length = 6;
        this.width = 5;
        this.land = new Tiles[this.length][this.width];
        
        generateLand();
    }
    
    /**
     * Constructor
     * Creates a land with the given width and length
     * @param int l length of the land
     * @param int w width of the land
     */
    public Land(int w, int l) {
    	this.width = w;
        this.length = l;
        this.land = new Tiles[this.length][this.width];
        
        generateLand();
    }

 
    /**
     * Generates a land respecting the rules of board preparation
     */
    public void generateLand() {
    	//Set all land to OCEAN
		for (int i=0; i<this.length; i++) {
			for (int j=0; j<this.width; j++) {
				this.land[i][j] = new Tiles(TilesTypes.OCEAN);
			}
		}

		//Set <=1/3 of land to NOT OCEAN
		Random random= new Random();
		int cmp = 0;
		int randXIndex, randYIndex, n, m;
		int nbNotOcean = random.nextInt((this.length*this.width)/3) + 1;
		while(cmp!=nbNotOcean+1 && cmp!=nbNotOcean) { 
			randXIndex = random.nextInt(this.length); //Generate random x index
			randYIndex = random.nextInt(this.width); //Generate random y index
			this.land[randXIndex][randYIndex] = new Tiles(TilesTypes.values()[random.nextInt(4)]); //Set land to random tile
			cmp++;
			//if no adjacent tile
			if (bordersAreOcean(randXIndex,randYIndex)) {
				n=0; m=0;
				//Generating a random direction
				while((n==0 && m==0) || (n!=0 && m!=0)) {
					if(randXIndex==0) n = random.nextInt(2);
					else if(randXIndex==this.length-1) n = random.nextInt(2) - 1;
					else n = random.nextInt(3) - 1;
					if(randYIndex==0) m = random.nextInt(2);
					else if(randYIndex==this.width-1) m= random.nextInt(2) - 1;
					else m = random.nextInt(3) - 1;
				}
				//Setting 1 adjacent tile to random direction
				this.land[randXIndex+n][randYIndex+m] = new Tiles(TilesTypes.values()[random.nextInt(4)]);
				cmp++;
			}
		}
	}

    /**
     * Checks the borders of the tile with given index
     * @param int x length index
     * @param int y width index
     * @return true if tile has no adjacent tile, else false
     */
	public boolean bordersAreOcean(int x, int y) {
		if (x==0 && y==0)
			return this.land[x+1][y].getType()==TilesTypes.OCEAN && this.land[x][y+1].getType()==TilesTypes.OCEAN;
		else if (x==0 && y!=this.width-1)
			return this.land[x+1][y].getType()==TilesTypes.OCEAN && this.land[x][y+1].getType()==TilesTypes.OCEAN
				&& this.land[x][y-1].getType()==TilesTypes.OCEAN;
		else if(x!=this.length-1 && y==0)
			return this.land[x+1][y].getType()==TilesTypes.OCEAN && this.land[x-1][y].getType()==TilesTypes.OCEAN
				&& this.land[x][y+1].getType()==TilesTypes.OCEAN;
		else if (x==this.length-1 && y==this.width-1)
			return this.land[x-1][y].getType()==TilesTypes.OCEAN && this.land[x][y-1].getType()==TilesTypes.OCEAN;
		else if (x==this.length-1 && y!=0)
			return this.land[x-1][y].getType()==TilesTypes.OCEAN && this.land[x][y+1].getType()==TilesTypes.OCEAN
			&& this.land[x][y-1].getType()==TilesTypes.OCEAN;
		else if(x!=0 && y==this.width-1)
			return this.land[x+1][y].getType()==TilesTypes.OCEAN && this.land[x-1][y].getType()==TilesTypes.OCEAN
				&& this.land[x][y-1].getType()==TilesTypes.OCEAN;
		else if(x==0 && y==this.width-1)
			return this.land[x+1][y].getType()==TilesTypes.OCEAN && this.land[x][y-1].getType()==TilesTypes.OCEAN;
		else if(x==this.length-1 && y==0)
			return this.land[x-1][y].getType()==TilesTypes.OCEAN && this.land[x][y+1].getType()==TilesTypes.OCEAN;
		else
			return this.land[x+1][y].getType()==TilesTypes.OCEAN && this.land[x-1][y].getType()==TilesTypes.OCEAN
				&& this.land[x][y+1].getType()==TilesTypes.OCEAN && this.land[x][y-1].getType()==TilesTypes.OCEAN;
	}
	
	
	/**
	 * Checks is the tile is occupied
	 * @param x index
	 * @param y index
	 * @return True if the tile is occupied, else False
	 */
	public boolean isOccupied(int x, int y) {
		return this.land[x][y].isOccupied();
	}
	
	/**
	 * Deploys a worker in the given indexes
	 * @param x index
	 * @param y index
	 * @param worker the worker to deploy
	 * @return True if the worker has been deployed successfully
	 */
	public boolean deployWorker(int x, int y, Worker worker, boolean random) {
		if (!this.land[x][y].isOccupied()) {
			if (!this.land[x][y].isOcean()) {
				this.land[x][y].setOccupiedBy(worker);
				worker.setStandsOn(this.land[x][y].getType());
				worker.setCoordinates(x, y);
				System.out.println("--> " + worker.getOwner().getName() + " has deployed a worker on x: " + x + " y: " + y);
				return true;
			}
			else {
				if(!random)
					System.out.println("You can't deploy a worker on ocean");
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
	 * Gets tile with given index
     * @param int x length index
     * @param int y width index
     * @return tile with given index
     */
    public Tiles getTile(int x, int y) {
    	return this.land[x][y];
    }
    
    /**
     * Gets the length of land
     * @return length of land
     */
    public int getLength() {
        return this.length;
    }

    /**
     * Gets the width of land
     * @return width of land
     */
    public int getWidth() {
        return this.width;
    }
    
    /**
     * prints the land in a 2D form
     */
    public void printLand() {
    	String name;
    	int nb=0;
    	System.out.printf("%-6s ", "");
    	for (int i=0; i<this.length ; i++) {
			System.out.printf("%-13d ",i);
		}
    	System.out.println();
    	for (int j=0; j<this.width ; j++) {
    		System.out.print(j + " | ");
    		for (int i=0; i<this.length ; i++) {
    			if(this.land[i][j].getOccupiedBy()==null) {
    				name = "--";
    				nb=0;
    			}
    			else {
    				name = this.land[i][j].getOccupiedBy().getOwner().getName();
    				if (this.land[i][j].getOccupiedBy() instanceof Army) {
    					nb = ((Army)this.land[i][j].getOccupiedBy()).getSize();
    				}
    				else {
    					nb=1;
    				}
    			}
    			System.out.printf("%s:%d>%-8s ", name.substring(0, 2), nb, this.land[i][j].getType());
    		}
    		System.out.println();
    	}
    }
}