package media;

import java.util.HashMap;
import java.util.Map;

import competitions.Competition;
import competitors.Competitor;

public class Bookmaker implements CompetitionObserver {
	
	private Map<Competitor, Integer> odds;
	private int coteInit;
	
	public Bookmaker(int coteInit) {
		this.odds = new HashMap<Competitor, Integer>();
		this.coteInit = coteInit;
	}
	
	@Override
	public void updateMatchesResults(Competitor loser, Competitor winner) {
		int winnerOdds, loserOdds;
		winnerOdds = (odds.get(winner) == null) ? coteInit-1 : (odds.get(winner)-1);
		loserOdds = (odds.get(loser) == null) ? coteInit+1 : (odds.get(loser)+1);
		odds.put(winner, winnerOdds);
		odds.put(loser, loserOdds);
		System.out.println("\nBookmaker : \n--> " + winner.getName() + " won a match against " + loser.getName() + ". Odds updated.");
		System.out.println(winner.getName() + " --> "+ winnerOdds + " & " + loser.getName() + " --> "+ loserOdds);
	}
	@Override
	public void updateCompetitionEnded(Map<Competitor, Integer> leaderboard, Competition comp) {
		System.out.println("\n--> Odds list for competitiors");
		leaderboard.forEach((c,p) -> System.out.println(c.getName() + " -> " + this.odds.get(c)));
	}
}
