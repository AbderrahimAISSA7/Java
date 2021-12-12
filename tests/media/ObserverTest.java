package media;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import competitions.MockCompetition;
import competitors.Competitor;
import competitors.MockCompetitor;
import matches.RandomMatch;

class ObserverTest {
	
	@Test
	void testUpdateMatchesResults() {
		List <Competitor> cmps= new ArrayList <Competitor>();
		cmps.add(new MockCompetitor("test1"));
		cmps.add(new MockCompetitor("test2"));
		MockCompetition competition = new MockCompetition(cmps);
		competition.setMatch(new RandomMatch());
		MockObserver observer = new MockObserver();
		assertEquals(observer.matchResultsUpdated, 0);
		competition.follow(observer);
		competition.play();
		assertEquals(observer.matchResultsUpdated, 1);
	}

	@Test
	void testUpdateCompetitionEnded() {
		List <Competitor> cmps= new ArrayList <Competitor>();
		cmps.add(new MockCompetitor("test1"));
		cmps.add(new MockCompetitor("test2"));
		MockCompetition competition = new MockCompetition(cmps);
		competition.setMatch(new RandomMatch());
		MockObserver observer = new MockObserver();
		assertEquals(observer.CompetitionEndedUpdated, 0);
		competition.follow(observer);
		competition.play();
		assertEquals(observer.CompetitionEndedUpdated, 1);
	}

}
