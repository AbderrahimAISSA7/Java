package competitors;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
/**
 * @author Abderrahim AISSA
 */ 
class CompetitorTest {



	@Test
	void testGetName() {
		Competitor c = new MockCompetitor("test");
		assertEquals(c.getName(),c.name);
	}

	@Test
	void testGetPoints() {
		Competitor c = new MockCompetitor("test");
		assertEquals(c.getPoints(), c.points);
		
	}

	@Test
	void testAddOnePoint() {
		Competitor c = new MockCompetitor("test");
		assertEquals(c.getPoints(), 0);
		c.addOnePoint();
		assertEquals(c.getPoints(), 1);
		
	}

}
