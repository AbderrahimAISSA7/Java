package game;

import java.util.ArrayList;

import characters.Army;
import characters.Character;
import land.TilesTypes;
import players.Player;
import players.WarGamePlayer;

public class WarGame extends Game {
	
	private static final int NB_ROUNDS = 10;
	
	public WarGame() {
		super();
	}
	
	public WarGame(int w, int l, String[] args) {
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
			System.out.println("1 : Deploy an army on an available tile ");
			System.out.println("2 : Exchange resources for food ");
			System.out.println("3 : Wait ");
			move = sc.nextInt();
		}
		while(move<1 || move>3);
		return move;
	}
	
	
	
	public void deployingChecks(int x, int y, Player p, Army army) {
		if(x!=this.land.getLength()-1) {
			if(this.land.getTile(x+1, y).isOccupied()) {
				Army ar = ((Army) this.land.getTile(x+1, y).getOccupiedBy());
				if(this.land.getTile(x+1, y).getOccupiedBy().getOwner() != p) {
					if(ar.getSize() <= 1){
						ar.getOwner().getCharacters().remove(ar);
					//	army.getOwner().getCharacters().add(ar);
					}
					if(army.getStandsOn() != TilesTypes.MOUNTAIN) {
						if(ar.getSize() < army.getSize()) {
							ar.decreaseByHalf();
							System.out.println("--> Which affected the enemy army on x: " + (x+1) + " y: " + y + " by decreasing its size by half");
					 	}
					}
					else {
						if(ar.getSize() < army.getSize()+2) {
							ar.decreaseByHalf();
							System.out.println("--> Which affected the enemy army on x: " + (x+1) + " y: " + y + " by decreasing its size by half");
					 	}
					}
					army.addGold(2);
				}
				else {
					if(ar.getSize() < army.getSize()) {
						ar.addOneToSize();
						 System.out.println("--> Which affected the ally army on x: " + (x+1) + " y: " + y + " by adding 1 soldier to its size (if possible)");
						army.addGold(1);	
					}
				}
			}
		}
		if(x!=0) {
			if(this.land.getTile(x-1, y).isOccupied()) {
				Army ar = ((Army) this.land.getTile(x-1, y).getOccupiedBy());
				if(this.land.getTile(x-1, y).getOccupiedBy().getOwner() != p) {
					if(ar.getSize() <= 1){
						ar.getOwner().getCharacters().remove(ar);
						//army.getOwner().getCharacters().add(ar);
					}
					if(army.getStandsOn() != TilesTypes.MOUNTAIN) {
						if(ar.getSize() < army.getSize()) {
							ar.decreaseByHalf();
							System.out.println("--> Which affected the enemy army on x: " + (x-1) + " y: " + y + " by decreasing its size by half");
					 	}
					}
					else {
						if(ar.getSize() < army.getSize()+2) {
							ar.decreaseByHalf();
							System.out.println("--> Which affected the enemy army on x: " + (x-1) + " y: " + y + " by decreasing its size by half");
					 	}
					}
					army.addGold(2);
				}
				else {
					if(ar.getSize() < army.getSize()) {
						ar.addOneToSize();
						 System.out.println("--> Which affected the ally army on x: " + (x-1) + " y: " + y + " by adding 1 soldier to its size (if possible)");
						army.addGold(1);	
					}
				}
			}
		}
		if(y!=this.land.getWidth()-1) {
			if(this.land.getTile(x, y+1).isOccupied()) {
				Army ar = ((Army) this.land.getTile(x, y+1).getOccupiedBy());
				if(this.land.getTile(x, y+1).getOccupiedBy().getOwner() != p) {
					if(ar.getSize() <= 1){
						ar.getOwner().getCharacters().remove(ar);
						//army.getOwner().getCharacters().add(ar);
					}
					if(army.getStandsOn() != TilesTypes.MOUNTAIN) {
						if(ar.getSize() < army.getSize()) {
							ar.decreaseByHalf();
							System.out.println("--> Which affected the enemy army on x: " + x + " y: " + (y+1) + " by decreasing its size by half");
					 	}
					}
					else {
						if(ar.getSize() < army.getSize()+2) {
							ar.decreaseByHalf();
							System.out.println("--> Which affected the enemy army on x: " + (x) + " y: " + (y+1) + " by decreasing its size by half");
					 	}
					}
					army.addGold(2);
				}
				else {
					if(ar.getSize() < army.getSize()) {
						ar.addOneToSize();
					 	System.out.println("--> Which affected the ally army on x: " + x + " y: " + (y+1) + " by adding 1 soldier to its size (if possible)");
					 army.addGold(1);	
					}
				}
			}
		}
		if(y!=0) {
			if(this.land.getTile(x, y-1).isOccupied()) {
				Army ar = ((Army) this.land.getTile(x, y-1).getOccupiedBy());
				if(this.land.getTile(x, y-1).getOccupiedBy().getOwner() != p) {
					if(ar.getSize() <= 1){
						ar.getOwner().getCharacters().remove(ar);
						//army.getOwner().getCharacters().add(ar);
					}
					if(army.getStandsOn() != TilesTypes.MOUNTAIN) {
						if(ar.getSize() < army.getSize()) {
							ar.decreaseByHalf();
							System.out.println("--> Which affected the enemy army on x: " + x + " y: " + (y-1) + " by decreasing its size by half");
					 	}
					}
					else {
						if(ar.getSize() < army.getSize()+2) {
							ar.decreaseByHalf();
							System.out.println("--> Which affected the enemy army on x: " + x + " y: " + (y-1) + " by decreasing its size by half");
					 	}
					}
					army.addGold(2);
				}
				else {
					if(ar.getSize() < army.getSize()) {
						ar.addOneToSize();
					 	System.out.println("--> Which affected the ally army on x: " + x + " y: " + (y-1) + " by adding 1 soldier to its size (if possible)");
					 army.addGold(1);	
					}
				}
			}
		}
	}
	
	/**
	 * Plays one round of the game with random choices
	 * @param p the player playing this turn
	 * 
	 */
	public void playOneRoundRandomly(Player p) {
		WarGamePlayer wp = (WarGamePlayer) p;
		int move = (int)Math.floor(Math.random()*3 + 1);
		switch(move) {
			case 1 :
				int x,y, size;
				do {
					x = (int)Math.floor(Math.random()*(this.land.getLength()));
					y = (int)Math.floor(Math.random()*(this.land.getWidth()));
				} while (this.land.getTile(x, y).isOccupied() || this.land.getTile(x, y).isOcean());
				
				if (wp.getSoldiers()!=0) {
					size = (int)Math.floor(Math.random()*5 + 1);
					if(this.land.getTile(x, y).getType() == TilesTypes.MOUNTAIN || this.land.getTile(x, y).getType() == TilesTypes.DESERT) {
							size = (int)Math.floor(Math.random()*3 + 1);;
					}
				}
				else {
					System.out.println("You don't have enough soldiers");
					break;
				}
				Army army = new Army(wp, size);
				army.deployCharacter(x, y, this.land, this.random);
				wp.decreaseSoldiers(size);
				wp.addCharacter(army);
				deployingChecks(x, y, wp, army);
				break;
			case 2:
				wp.ressourceToFood();;
				System.out.println(p.getName() + " Exchanged his ressources with food");
				break;
			case 3:
				System.out.println(p.getName() + " skipped this round");
				break;
		}
	}
	
	/**
	 * Plays one round of the game by giving choices to users
	 * @param p the player playing this turn
	 * 
	 */
	public void playOneRound(Player p) {
		WarGamePlayer wp = (WarGamePlayer) p;
		System.out.println("Choose your next move ");
		int move = chooseNextMove();
		switch(move) {
			case 1 :
				int x,y, size;
				do {
					System.out.println("Enter the coordinates of where you want to deploy the army.");
					System.out.println("x = ");
					x = sc.nextInt();
					System.out.println("y = ");
					y = sc.nextInt();
				} while (this.land.getTile(x, y).isOccupied() || this.land.getTile(x, y).isOcean());
				
				if (wp.getSoldiers()!=0) {
					do {
						System.out.println("Enter the size of the army you want to deploy");
						size = sc.nextInt();
						if(size>3 && (this.land.getTile(x, y).getType() == TilesTypes.MOUNTAIN || this.land.getTile(x, y).getType() == TilesTypes.DESERT)) {
							do {
								System.out.println("Enter an army size between 1-3, because you are deploying on a " + this.land.getTile(x, y).getType() + " tile");
								size = sc.nextInt();
							}while(size <=0 || size>3 || wp.getSoldiers()<size);
						}
					}
					while(wp.getSoldiers()<size || size <=0 || size > 5);
				}
				else {
					System.out.println("You don't have enough soldiers");
					break;
				}
				Army army = new Army(wp, size);
				army.deployCharacter(x, y, this.land, this.random);
				wp.decreaseSoldiers(size);
				wp.addCharacter(army);
				deployingChecks(x, y, wp, army);
				break;
			case 2:
				wp.ressourceToFood();
				System.out.println(p.getName() + " Exchanged his ressources with food");
				break;
			case 3:
				System.out.println(p.getName() + " skipped this round");
				break;
		}
	}
	
	public void play() {
		ArrayList<Character> toRemove = new ArrayList<Character>();
		int points, notFed=0, destroyed=0;
		for(int i=0; i<WarGame.NB_ROUNDS; i++) {
			if(this.nbNotOccupiedTiles() == 0) {
				System.out.println("\nThere is no more tiles to conquer");
				break;
			}
			System.out.println("----------- ROUND " + (i+1) + " -----------");
			this.land.printLand();
			for (int j=0; j<this.players.size(); j++) {
				System.out.println(this.players.get(j).getName() + ":");
				System.out.println("     Gold         : " + this.players.get(j).getGold());
				System.out.println("     Food      : " + ((WarGamePlayer) this.players.get(j)).getFood());
				System.out.println("     Soldiers      : " + ((WarGamePlayer) this.players.get(j)).getSoldiers());
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
					notFed=0; destroyed=0;
					ch = c.pay();
					if(ch != null) {
						toRemove.add(ch);
						this.land.getTile(ch.getX(), ch.getY()).setOccupiedBy(null);
						notFed++;
					}
					if(((Army)c).getSize()==0){
						this.land.getTile(c.getX(), c.getY()).setOccupiedBy(null);
						destroyed++;
					}
					if(notFed!=0)
						System.out.println("--> " + this.players.get(j).getName() + " lost " + notFed + " armies because he couldn't feed them");
					if(destroyed!=0)
						System.out.println("--> " + this.players.get(j).getName() + " destroyed " + destroyed + " of enemy armies");
				}
				if(toRemove.size()!=0) {
					this.players.get(j).getCharacters().removeAll(toRemove);
					this.players.get(j).addGold(toRemove.size());
					toRemove.clear();
				}
				points = 0;
				for(Character w : this.players.get(j).getCharacters()) {
					points += w.getGold();
				}
				this.players.get(j).setPoints(points);
			}
		}
		System.out.println("\n----------- THE GAME IS OVER -----------");
		System.out.println("\n// Results \\\\");
		this.land.printLand();
		Player winner = this.getWinner();
		for(Player p : this.players) {
			System.out.println(p.getName() + " has " + p.getPoints() + " points");
		}
		System.out.println("\n" + winner.getName() + " is the winner");
	}
	
	/**
	 * Gets the winner of the game
	 * @return the name of the winner
	 */
	public Player getWinner() {
		int max = 0, s, cpt;
		Player winner = null;
		for (Player p : this.getPlayers()) {
			s=0;
			s += p.getGold();
			cpt=0;
			for(Character a : p.getCharacters()) {
				cpt++;
				s += a.getGold();
				switch(a.getStandsOn()) {
					case PLAIN:
						s++;
						break;
					case FOREST:
						s+=2;
						break;
					case MOUNTAIN:
					case DESERT:
						s+=4;
						break;
					case OCEAN:
						break;
				}
			}
			if(cpt>=10)
				s+=5;
			p.setPoints(s);
			if(max < s) {
				max = s;
				winner = p;
			}
		}
		return winner;
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
			this.players.add(new WarGamePlayer(name));
		}
	}
	
	/**
	 * Adds the given number of new players to the players list
	 * @param nb the number of new players
	 */
	public void addGivenPlayers(String players[]) {
		for (int i=0; i<players.length; i++) {
			this.players.add(new WarGamePlayer(players[i]));
		}
	}
	
}
