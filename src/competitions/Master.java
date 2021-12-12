package competitions;

import java.util.ArrayList;
import java.util.List;

import competitors.Competitor;
import matches.RandomMatch;
import media.CompetitionObserver;
import selections.Selection;

/**
 * @author  Abderrahim AISSA
 * 
 * A Master is a type of competition where competitors play in two phases, the groups phase and the final phase
 */
public class Master extends Competition{
	
	private Selection selection;

	public Master(List<Competitor> competitors, Selection selection) {
		super(competitors);
		this.selection = selection;
	}

	@Override
	public void play(List<Competitor> competitors) {
		List<Competitor> qualified = this.playPhaseOne(competitors);
		this.playPhasetwo(qualified);
	}

	private List<Competitor> playPhaseOne(List<Competitor> competitors) {
		List<List<Competitor>> orderedGroups = new ArrayList<List<Competitor>>();
		List<List <Competitor>> groups = null;
		List<Competitor> qualified;
		int i=0;
		try {
			groups = this.selection.createGroups(competitors);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		for (List<Competitor> g : groups) {
			League l = new League(g);
			l.setMatch(new RandomMatch());
			
			for(CompetitionObserver observer : this.getObservers()) {
				l.follow(observer);
			}
			
			l.play();
			orderedGroups.add(new ArrayList<Competitor>());
			for (Competitor c : l.ranking().keySet())
				orderedGroups.get(i).add(c);
			i++;
		}
		qualified = this.selection.select(orderedGroups);
		return qualified;
	}
	
	private Competitor playPhasetwo(List<Competitor> qualified) {
		Competitor winner = null;
		try {
			Tournament t = new Tournament(qualified);
			t.setMatch(new RandomMatch());
			
			for(CompetitionObserver observer : this.getObservers()) {
				t.follow(observer);
			}
			
			t.play();
			winner = t.ranking().keySet().iterator().next();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return winner;
	}
	
}
