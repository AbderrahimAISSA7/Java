package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import competitions.Competition;
import competitions.Master;
import competitors.Competitor;
import competitors.NormalCompetitor;
import matches.Match;
import matches.RandomMatch;
import media.Journalist;
import selections.BestTwo;
import selections.Selection;
import selections.TopOne;

public class MasterMain {

	public static void main(String[] args) {
		
		System.out.println("====== Starting Master ======");
		Scanner sc = new Scanner(System.in);
		Match match = new RandomMatch();
		Selection selection;
		List<Competitor> competitors = new ArrayList<Competitor>();
		int choice;
		
		do {
			System.out.println("Choose the selection method :");
			System.out.println("1 : Top competitor in each group (16 competitor, 4 groups)");
			System.out.println("2 : Top two competitors in each group, and the best 2 third places (24 competitor, 3 groups)");
			choice = sc.nextInt();
		} while (choice<1 || choice >2 );
		sc.close();
		
		if (choice==1)
			selection = new TopOne();
		else
			selection = new BestTwo();
		
		for (int i=0; i<selection.getNbCompetitors(); i++) {
			competitors.add(new NormalCompetitor("Comp" + (i+1)));
		}
		Competition master = new Master(competitors, selection);
		master.setMatch(match);
		master.follow(new Journalist());
		master.play();
	}

}
