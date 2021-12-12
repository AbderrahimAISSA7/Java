package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import competitions.*;
import competitors.*;
import matches.*;
import media.Journalist;

public class TournamentMain {

	public static void main(String[] args) throws Exception {
		System.out.println("====== Starting Tournament ======");
		Scanner sc = new Scanner(System.in);
		Match match = new RandomMatch();
		List<Competitor> competitors = new ArrayList<Competitor>();
		int nbCompetitors;
		
		do {
			System.out.println("NOTE : The number of competitors must be a power of 2");
			System.out.println("Enter the number of competitors");
			nbCompetitors = sc.nextInt();
		} while (nbCompetitors<=0 || (nbCompetitors & nbCompetitors-1) != 0 || nbCompetitors == 0 );
		sc.close();
		
		for (int i=0; i<nbCompetitors; i++) {
			competitors.add(new NormalCompetitor("Comp" + (i+1)));
		}

		Competition tournament = new Tournament(competitors);
		tournament.setMatch(match);
		tournament.follow(new Journalist());
		tournament.play();
	}

}
