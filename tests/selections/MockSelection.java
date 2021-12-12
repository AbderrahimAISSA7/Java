package selections;

import java.util.List;

import competitors.Competitor;

public class MockSelection extends Selection{

	public MockSelection(int nbCompetitors, int nbGroups) {
		super(nbCompetitors, nbGroups);
	}

	@Override
	public List<Competitor> select(List<List<Competitor>> orderedGroups) {
		
		return null;
	}

}
