package selections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import competitors.Competitor;

public abstract class Selection {
	protected int nbCompetitors;
	protected int nbGroups;
	
	public Selection(int nbCompetitors, int nbGroups) {
		this.nbCompetitors = nbCompetitors;
		this.nbGroups = nbGroups;
	}
	
	public abstract List<Competitor> select(List<List<Competitor>> orderedGroups);
	
	public List<List<Competitor>> createGroups(List<Competitor> competitors) {
		List<List<Competitor>> groups = new ArrayList<List<Competitor>>();
		Iterator<Competitor> iterator = competitors.iterator();
		int i=0, g=-1;
		int nbCompInGroup = this.nbCompetitors/nbGroups;
		do{
			if(i%nbCompInGroup==0) {
				groups.add(new ArrayList<Competitor>());
				g++;
			}
			groups.get(g).add(iterator.next());
			i++;
		}
		while(iterator.hasNext());
		return groups;
	}
	
	public int getNbCompetitors() {
		return this.nbCompetitors;
	}
	
	public int getNbGroups() {
		return this.nbGroups;
	}
}
