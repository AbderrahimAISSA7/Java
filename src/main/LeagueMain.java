package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import competitions.Competition;
import competitions.League;
import competitors.Competitor;
import competitors.NormalCompetitor;
import matches.Match;
import matches.RandomMatch;
import media.*;

public class LeagueMain {

	public static void main(String[] args) {
		System.out.println("====== Starting League ======");
		Scanner sc = new Scanner(System.in);
		Match match = new RandomMatch();
		List<Competitor> competitors = new ArrayList<Competitor>();
		int nbCompetitors;
		
		do {
			System.out.println("Enter the number of competitors");
			nbCompetitors = sc.nextInt();
		} while (nbCompetitors<=0);
		sc.close();
		
		for (int i=0; i<nbCompetitors; i++) {
			competitors.add(new NormalCompetitor("Comp" + (i+1)));
		}
		
		
		Competition league = new League(competitors);
		league.setMatch(match);
		//league.follow(new Bookmaker(10));
		league.follow(new Journalist());
		league.play();
	}

}
