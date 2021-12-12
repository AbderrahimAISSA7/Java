package competitions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import competitors.*;

/**
 * @author Abderrahim AISSA
 * 
 * A Tournament is a type of competition where losing a match eliminates the competitor
 */
public class Tournament extends Competition {

    /**
     * Construct a tournament using the given list of competitors
     */
    public Tournament(List<Competitor> competitors) throws Exception{
    	super(competitors);
    	int size = competitors.size();
    	if ((size & size-1) != 0 || size == 0)
    		throw new Exception("The number of competitors must be a power of 2");
    }

	@Override
	public void play(List<Competitor> competitors) {
		List<Competitor> winners = new ArrayList<Competitor>(competitors);
		List<Competitor> toRemove = new ArrayList<Competitor>();
		Competitor loser;
		Iterator<Competitor> iterator;
		while(winners.size()!=1) {
			iterator = winners.iterator();
			while(iterator.hasNext()) {
				loser = this.match.playMatch(iterator.next(), iterator.next());
				toRemove.add(loser);
			}
			winners.removeAll(toRemove);
		}
		this.diffuseFinalResults(this.ranking());
	}

}