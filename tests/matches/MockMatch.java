package matches;

import competitors.Competitor;

public class MockMatch extends Match {
	
	public int playMatchCalled = 0;
	
	@Override
	public Competitor playMatch(Competitor cmp1, Competitor cmp2) {
		playMatchCalled++;
		return cmp1;
	}

}
