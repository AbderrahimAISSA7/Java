package competitions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import competitors.Competitor;
import matches.Match;
import media.CompetitionObserver;
import util.MapUtil;

/**
 * @author Abderrahim AISSA
 * 
 * A competition is defined its match, and competitors list
 */
public abstract class Competition {
	
	protected HashSet <CompetitionObserver> observers = new HashSet<CompetitionObserver>();
	/**
     * 
     */
    protected Match match;

    /**
     * 
     */
    protected final List <Competitor> competitors;

    /**
     * @param competitors
     */
    public Competition(List<Competitor> competitors ) {
		this.competitors = competitors;
    }

    public void follow(CompetitionObserver observer) {
    	this.observers.add(observer);
    }
    
    public void unfollow(CompetitionObserver observer) {
    	this.observers.remove(observer);
    }
    
    /**
     * 
     */
    public void play() {
        this.play(this.competitors);
    }

    /**
     * @param competitors
     */
    public abstract void play(List<Competitor> competitors);

    /**
     * @param c1 
     * @param c2
     * @return The loser
     */
	public Competitor playMatch(Competitor c1, Competitor c2) {
		Competitor winner, loser;
		loser = this.match.playMatch(c1, c2);
		winner = (loser == c1) ? c2 : c1;
		this.diffuseMatches(loser, winner);
		return loser;
	}
    
	private void diffuseMatches(Competitor loser, Competitor winner) {
		for(CompetitionObserver observer: observers) {
			observer.updateMatchesResults(loser, winner);
		}
	}

	protected void diffuseFinalResults(Map<Competitor, Integer> leaderboard) {
		for(CompetitionObserver observer: observers) {
			observer.updateCompetitionEnded(leaderboard,this);
		}
	}
	
    /**
     * @return
     */
    public Map<Competitor, Integer> ranking() {
    	Map<Competitor, Integer> ranking = new HashMap<Competitor, Integer>();
    	this.competitors.forEach(c -> ranking.put(c, c.getPoints()));
        return MapUtil.sortByDescendingValue(ranking);
    }

	public List <Competitor> getCompetitors() {
		return competitors;
	}

	public Match getMatch() {
		return match;
	}

	public void setMatch(Match match) {
		this.match = match;
	}
	
	public HashSet<CompetitionObserver> getObservers() {
		return this.observers;
	}

}