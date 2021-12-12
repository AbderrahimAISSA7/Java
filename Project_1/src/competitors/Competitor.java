package competitors;

/**
 * @author Abderrahim AISSA
 * 
 * A competitor is defined by his name, and his points
 */
public abstract class Competitor {

    /**
     * The name of this competitor
     */
    public String name;

    /**
     * The total points of this competitor
     */
    public int points;

    /**
     * The constructor of the competitor.
     * Construct a competitor with the given name, and 0 points
     */
    public Competitor(String name) {
    	this.name = name;
    	this.points = 0;
    }
    
    /**
     * @return The name of this competitor
     */
    public String getName() {
        return this.name;
    }

    /**
     * @return The points of this competitor
     */
    public int getPoints() {
        return this.points;
    }

    /**
     * Adds one points to the total points of this competitor
     */
    public void addOnePoint() {
        this.points++;
    }
}