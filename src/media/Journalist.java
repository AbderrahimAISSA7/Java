package media;

import java.util.Map;

import competitions.Competition;
import competitions.League;
import competitors.Competitor;

public class Journalist implements CompetitionObserver{

	@Override
	public void updateMatchesResults(Competitor loser, Competitor winner) {
		System.out.println("Journalist : " + loser.getName() + " VS " + winner.getName() + "-> Winner : " + winner.getName() );
	}

	@Override
	public void updateCompetitionEnded(Map<Competitor, Integer> leaderboard, Competition comp) {
		if (comp instanceof League) 
			this.reportLeague(leaderboard);
		else
			this.reportTournament(leaderboard);
	}
	
	private void reportLeague(Map<Competitor, Integer> leaderboard) {
		System.out.println("\nJournalist : \n====== LEAGUE LEADERBOARD ======");
		leaderboard.forEach((k,v) -> System.out.println(k.getName() + " -> " + v));
		System.out.println();
	}
	
	private void reportTournament(Map<Competitor, Integer> leaderboard) {
		System.out.println("\nJournalist : \n====== TOURNAMENT LEADERBOARD ======");
		for (Map.Entry<Competitor, Integer> m : leaderboard.entrySet()) {
			System.out.println(m.getKey().getName() + " -> " + m.getValue());
		}
		System.out.println("\nJournalist : \n====== WINNER ======\n");
		System.out.println(leaderboard.keySet().iterator().next().getName());
	}
}
