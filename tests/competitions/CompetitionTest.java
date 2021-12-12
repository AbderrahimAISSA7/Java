package competitions;


import static org.junit.jupiter.api.Assertions.*;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import competitors.Competitor;
import competitors.MockCompetitor;
import matches.Match;
import matches.MockMatch;
import matches.RandomMatch;
/**
 * @author Abderrahim AISSA
 */ 
class CompetitionTest {
	
	@Test
	void testPlay() {
		List <Competitor> cmps= new ArrayList <Competitor>();
		MockCompetition cp = new MockCompetition(cmps);
		assertEquals(0, cp.playCalled);
		cp.play();
		assertEquals(1, cp.playCalled);
	}
	@Test
	void testPlayMatch() {
		Competitor c1 = new MockCompetitor("test1");
		Competitor c2 = new MockCompetitor("test2");
		MockMatch match = new MockMatch();
		assertEquals(0, match.playMatchCalled);
		match.playMatch(c1, c2);
		assertEquals(1, match.playMatchCalled);
	}
	
	@Test
	void testRanking() {
		List <Competitor> cmps= new ArrayList <Competitor>();
		for (int i=0; i<16; i++) {
			cmps.add(new MockCompetitor("Comp" + (i+1)));
		}
		MockCompetition mc = new MockCompetition(cmps);
		Map<Competitor, Integer> leaderboard = mc.ranking();
		Iterator<Competitor> ite = leaderboard.keySet().iterator();
		while(ite.hasNext()) {
			assertTrue(leaderboard.get(ite.next()) >= leaderboard.get(ite.next()));
		}
	}

	@Test
	void testGetCompetitors() {
		List <Competitor> cmps= new ArrayList <Competitor>();
		cmps.add(new MockCompetitor("test1"));
		Competition cp = new League(cmps);
		assertEquals(cp.getCompetitors(),cmps);
	}

	@Test
	void testGetMatch() {
		List <Competitor> cmps= new ArrayList <Competitor>();
		Competition cp = new League(cmps);
		Match m = new RandomMatch();
		cp.setMatch(m);
		assertEquals(cp.getMatch(), m);
		
	}
	
	@Test
	void testSetMatch() {
		List <Competitor> cmps= new ArrayList <Competitor>();
		Competition cp = new League(cmps);
		Match m = new RandomMatch();
		cp.setMatch(m);
		assertEquals(cp.getMatch(),m);
	}
	
	
}
