package players;


public class WarGamePlayer extends Player {

	private int food;
	private int soldiers;
	
	public WarGamePlayer(String name) {
		super(name);
		this.gold = 0;
		this.food = 10;
		this.soldiers = 35;
	}
	
	public void ressourceToFood() {
		if (this.resources.get("Wheat")>0) {
			this.food += this.resources.get("Wheat")*5;
			this.resources.put("Wheat", 0);
		}
		else if (this.resources.get("Wood")>0) {
			this.food += this.resources.get("Wood");
			this.resources.put("Wood", 0);
		}
	}
	
	public void decreaseSoldiers(int n) {
		this.soldiers -= n;
	}
	
	public void decreaseFood(int n) {
		this.food -= n;
	}
	
	public int getFood() {
		return this.food;
	}
	
	public int getSoldiers() {
		return this.soldiers;
	}
	
}
