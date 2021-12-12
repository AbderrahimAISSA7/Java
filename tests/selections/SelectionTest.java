package selections;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import competitors.Competitor;
import competitors.MockCompetitor;

class SelectionTest {
	
	static final int NB_GROUPS = 4;
	static final int NB_COMPETITORS = 16;

	@Test
	void testCreateGroups() {
		MockSelection ms = new MockSelection(SelectionTest.NB_COMPETITORS, SelectionTest.NB_GROUPS);
		List<Competitor> competitors = new ArrayList<Competitor>();
		for (int i=0; i<ms.getNbCompetitors(); i++) {
			competitors.add(new MockCompetitor("Comp" + (i+1)));
		}
		
		List<List<Competitor>> orderedGroups = ms.createGroups(competitors);
		
		assertTrue(orderedGroups.size() == SelectionTest.NB_GROUPS);
		for (List<Competitor> g : orderedGroups) {
			assertTrue(g.size() == SelectionTest.NB_GROUPS);
		}
		
	}

	@Test
	void testGetNbCompetitors() {
		MockSelection ms = new MockSelection(SelectionTest.NB_COMPETITORS, SelectionTest.NB_GROUPS);
		assertEquals(ms.getNbCompetitors(), SelectionTest.NB_COMPETITORS);
	}

	@Test
	void testGetNbGroups() {
		MockSelection ms = new MockSelection(SelectionTest.NB_COMPETITORS, SelectionTest.NB_GROUPS);
		assertEquals(ms.getNbGroups(), SelectionTest.NB_GROUPS);
	}
	
}
