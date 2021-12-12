package matches;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import competitors.MockCompetitor;

class MatchTest {

	@Test
	void testMatch() {
		MockMatch match = new MockMatch();
		MockCompetitor c1 = new MockCompetitor("test1");
		MockCompetitor c2 = new MockCompetitor("test2");
		assertEquals(c1,match.playMatch(c1, c2));
		
	}

}
