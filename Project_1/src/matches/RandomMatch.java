package matches;

import java.util.Random;

import competitors.Competitor;

/**
 * @author Abderrahim AISSA
 * 
 * A random match is a type of matches where the winner is picked randomly
 */
public class RandomMatch extends Match {

    /**
     * Plays the match between the two competitors
     * @return The winner of the match
     */
	@Override
	public Competitor playMatch(Competitor cmp1, Competitor cmp2) {
		Random r = new Random();
		int tmp = r.nextInt(2);
		if (tmp == 0) {
			cmp1.addOnePoint();
			return cmp2;
		}
		cmp2.addOnePoint();
		return cmp1;
	}
}