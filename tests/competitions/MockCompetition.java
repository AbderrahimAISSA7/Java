package competitions;

import java.util.List;

import competitors.Competitor;

public class MockCompetition extends Competition{

	public int playCalled = 0;
	
	public MockCompetition(List<Competitor> competitors) {
		super(competitors);
	}

	@Override
	public void play(List<Competitor> competitors) {
		this.playCalled++;
		this.playMatch(this.competitors.get(0), this.competitors.get(1));
        this.diffuseFinalResults(this.ranking());
	}
	
}
