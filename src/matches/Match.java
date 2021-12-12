package matches;

import competitors.Competitor;

/**
 * @author Abderrahim AISSA
 * 
 * A match is defined by the two competitors playing the match
 */
public abstract class Match {

    /**
     * Plays the match between the given competitors
     * @return the winner of the match
     */
    public abstract Competitor playMatch(Competitor cmp1, Competitor cmp2);

}