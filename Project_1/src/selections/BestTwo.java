package selections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import competitions.League;
import competitors.Competitor;

public class BestTwo extends Selection{
	public BestTwo() {
		super(24, 3);
	}

	@Override
	public List<Competitor> select(List<List<Competitor>> orderedGroups) {
		List<Competitor> qualified = new ArrayList<Competitor>();
		List<Competitor> thirds = new ArrayList<Competitor>(); 
		for (List<Competitor> g : orderedGroups) {
			qualified.add(g.get(0));
			qualified.add(g.get(1));
			thirds.add(g.get(2));
		}
		Iterator <Competitor> iterator = new League(thirds).ranking().keySet().iterator();
		qualified.add(iterator.next());
		qualified.add(iterator.next());
		return qualified;
	}
}
