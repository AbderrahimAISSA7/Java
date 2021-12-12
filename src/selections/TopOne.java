package selections;

import java.util.ArrayList;
import java.util.List;

import competitors.Competitor;

public class TopOne extends Selection{
	public TopOne() {
		super(16, 4);
	}

	@Override
	public List<Competitor> select(List<List<Competitor>> orderedGroups) {
		List<Competitor> qualified = new ArrayList<Competitor>();
		for (List<Competitor> g : orderedGroups) {
			qualified.add(g.get(0));
		}
		return qualified;
	}
}
