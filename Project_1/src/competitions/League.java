package competitions;

import java.util.List;

import competitors.Competitor;

/**
 * @author  Abderrahim AISSA
 * 
 * A League is a type of competition where the each competitor plays two matches with each of the other competitors (Two legged matches).
 */
public class League extends Competition {

    /**
     * Construct a league using the given list of competitors
     */
    public League(List<Competitor> competitors) {
    	super(competitors);	
    }

	@Override
	public void play(List<Competitor> competitors) {
		for (Competitor c : competitors) {
			competitors.forEach(x -> {
										if (x!=c) 
											this.playMatch(c, x);
										});
		}
		this.diffuseFinalResults(this.ranking());
	}

}