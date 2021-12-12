package media;

import java.util.Map;

import competitions.Competition;
import competitors.Competitor;

class MockObserver implements CompetitionObserver {
	
	public int matchResultsUpdated = 0;
	public int CompetitionEndedUpdated = 0;

	@Override
	public void updateMatchesResults(Competitor loser, Competitor winner) {
		matchResultsUpdated++;
	}

	@Override
	public void updateCompetitionEnded(Map<Competitor, Integer> leaderboard, Competition competition) {
		CompetitionEndedUpdated++;
	}

}
