package media;

import java.util.Map;

import competitions.Competition;
import competitors.Competitor;

public interface CompetitionObserver {

	void updateMatchesResults(Competitor loser, Competitor winner);

	void updateCompetitionEnded(Map<Competitor, Integer> leaderboard, Competition competition);

}
