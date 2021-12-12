# Project : Sports Competitions

## Project by

   - Aissa Abderrahim

## Project Introduction
  I am trying in this project to represent different sport competitions, where competitors can participate in them. These competitions can be played using different rules :  
   - The League :  
      Where each competitor plays two matches with everyone else, and the winner is the one with the most wins.  
   - The Tournament :  
      Where the winner is the one who won all the matches he played, and can be disqualified if he loses one match.    
   - The Master :  
      Where the  competition is divided into two stages :  
      - Starting with the group stage
         Where the competitors will be in groups, and the members of each group play a regular League, at the end of which certain competitors are qualified to compete in the final phase.
      - The final stage 
         Where the qualified competitors play a regular Tournament to determine the winner of the Master.
         
## Table of contents
- [How to](#how-to)
    - [Get the files](#get-the-files)
    - [Generate JavaDoc files](#generate-javadoc-files)
    - [Compile .java files](#compile-java-files)
    - [Generate the executable .jar files](#generate-the-executable-jar-files)
    - [Execute the program](#execute-the-program)

## How to

   - ### Get the files
      1. To compile and execute the files, you need to install [JDK Java SE](https://www.oracle.com/java/technologies/javase-downloads.html).
      2. Get the project with the following command
         ```bash
         git clone https://gitlab-etu.fil.univ-lille1.fr/laghrissi/coo-2021-g5-laghrissi-hamza.git
         ```
   - ### Generate JavaDoc files
      1. To generate the Javadoc execute the following command:  
         ```bash
         javadoc -d ../docs -subpackage image
         ```
         A new directory _docs_ will be created.  
      2.  To consult the JavaDoc: in the docs Directory, open the index.html file in a web browser.
   
   - ### Compile java files
      1. Go to the corresponding folder /src

      2. Compile all the .java file, and store them in the classes folder using the following command.
         ```bash
         javac main/*.java -d ../classes
         ```
      3. You will notice that the classes folder contains the structure of the packages containing the compiled files with a .class extension.
  
   - ### Generate the executable jar files
      1. Go to the /classes directory, and execute the following command :
         ```bash
         jar cvfm ../league.jar ../manifest-league main competitions competitors matches selections util
         ```
      2. You will notice that a league.jar file has been created.
   
   - ### Execute the program
      * Without using the .jar file

         1. Go to your /classes directory
         2. Use the following command to execute :  
            - The league 
               ```bash
               java main.LeagueMain
               ```

               The following will appear in your terminal :  

                  Enter the number of competitors
                  4

                  ====== Starting the League ======

                  Comp1 VS Comp2-> Winner : Comp1
                  Comp1 VS Comp3-> Winner : Comp3
                  Comp1 VS Comp4-> Winner : Comp1
                  Comp2 VS Comp1-> Winner : Comp2
                  Comp2 VS Comp3-> Winner : Comp2
                  Comp2 VS Comp4-> Winner : Comp4
                  Comp3 VS Comp1-> Winner : Comp1
                  Comp3 VS Comp2-> Winner : Comp2
                  Comp3 VS Comp4-> Winner : Comp3
                  Comp4 VS Comp1-> Winner : Comp4
                  Comp4 VS Comp2-> Winner : Comp2
                  Comp4 VS Comp3-> Winner : Comp4

                  ====== Final leaderboard ======

                  Comp2 -> 4
                  Comp1 -> 3
                  Comp4 -> 3
                  Comp3 -> 2

                  ====== WINNER OF THE LEAGUE ======

                  Comp2
                  
            - The tournament  
               ```bash
               java main.TournamentMain
               ```

               The following will appear in your terminal :  

                  NOTE : The number of competitors must be a power of 2
                  Enter the number of competitors
                  8
                  ------ ROUND 1 ------
                  Comp1 VS Comp2-> Winner : Comp1
                  Comp3 VS Comp4-> Winner : Comp3
                  Comp5 VS Comp6-> Winner : Comp5
                  Comp7 VS Comp8-> Winner : Comp7
                  ------ ROUND 2 ------
                  Comp1 VS Comp3-> Winner : Comp3
                  Comp5 VS Comp7-> Winner : Comp7
                  ------ ROUND 3 ------
                  Comp3 VS Comp7-> Winner : Comp3

                  ====== WINNER OF THE TOURNAMENT ======

                  Comp3

            - The master  
               ```bash
               java main.MasterMain
               ```

               The following will appear in your terminal :  

                  Choose the selection method :
                  1 : Top competitor in each group (16 competitor, 4 groups)
                  2 : Top two competitors in each group, and the best 2 third places (24 competitor, 3 groups)
                  1

                  ====== Starting Phase 1 of the Master ======

                  Comp1 VS Comp2-> Winner : Comp2
                  Comp1 VS Comp3-> Winner : Comp3
                  Comp1 VS Comp4-> Winner : Comp4
                  Comp2 VS Comp1-> Winner : Comp2
                  Comp2 VS Comp3-> Winner : Comp2
                  Comp2 VS Comp4-> Winner : Comp2
                  Comp3 VS Comp1-> Winner : Comp1
                  Comp3 VS Comp2-> Winner : Comp2
                  Comp3 VS Comp4-> Winner : Comp4
                  Comp4 VS Comp1-> Winner : Comp4
                  Comp4 VS Comp2-> Winner : Comp2
                  Comp4 VS Comp3-> Winner : Comp4
                  Comp5 VS Comp6-> Winner : Comp5
                  Comp5 VS Comp7-> Winner : Comp7
                  Comp5 VS Comp8-> Winner : Comp8
                  Comp6 VS Comp5-> Winner : Comp5
                  Comp6 VS Comp7-> Winner : Comp6
                  Comp6 VS Comp8-> Winner : Comp6
                  Comp7 VS Comp5-> Winner : Comp7
                  Comp7 VS Comp6-> Winner : Comp7
                  Comp7 VS Comp8-> Winner : Comp8
                  Comp8 VS Comp5-> Winner : Comp5
                  Comp8 VS Comp6-> Winner : Comp8
                  Comp8 VS Comp7-> Winner : Comp7
                  Comp9 VS Comp10-> Winner : Comp9
                  Comp9 VS Comp11-> Winner : Comp9
                  Comp9 VS Comp12-> Winner : Comp9
                  Comp10 VS Comp9-> Winner : Comp10
                  Comp10 VS Comp11-> Winner : Comp10
                  Comp10 VS Comp12-> Winner : Comp10
                  Comp11 VS Comp9-> Winner : Comp9
                  Comp11 VS Comp10-> Winner : Comp10
                  Comp11 VS Comp12-> Winner : Comp12
                  Comp12 VS Comp9-> Winner : Comp12
                  Comp12 VS Comp10-> Winner : Comp12
                  Comp12 VS Comp11-> Winner : Comp12
                  Comp13 VS Comp14-> Winner : Comp13
                  Comp13 VS Comp15-> Winner : Comp15
                  Comp13 VS Comp16-> Winner : Comp13
                  Comp14 VS Comp13-> Winner : Comp14
                  Comp14 VS Comp15-> Winner : Comp15
                  Comp14 VS Comp16-> Winner : Comp14
                  Comp15 VS Comp13-> Winner : Comp13
                  Comp15 VS Comp14-> Winner : Comp15
                  Comp15 VS Comp16-> Winner : Comp16
                  Comp16 VS Comp13-> Winner : Comp16
                  Comp16 VS Comp14-> Winner : Comp14
                  Comp16 VS Comp15-> Winner : Comp16

                  ---- Final Groups ----

                  -- / Group 1 \ --
                  Comp2 -> 6
                  Comp4 -> 4
                  Comp3 -> 1
                  Comp1 -> 1
                  -- / Group 2 \ --
                  Comp7 -> 4
                  Comp8 -> 3
                  Comp5 -> 3
                  Comp6 -> 2
                  -- / Group 3 \ --
                  Comp9 -> 4
                  Comp10 -> 4
                  Comp12 -> 4
                  Comp11 -> 0
                  -- / Group 4 \ --
                  Comp14 -> 3
                  Comp15 -> 3
                  Comp13 -> 3
                  Comp16 -> 3

                  ---- Qualified competitors from phase 1 ----

                  Comp2
                  Comp7
                  Comp9
                  Comp14

                  ======= Starting Phase 2 of the Master =======

                  ------ ROUND 1 ------
                  Comp2 VS Comp7-> Winner : Comp7
                  Comp9 VS Comp14-> Winner : Comp9
                  ------ ROUND 2 ------
                  Comp7 VS Comp9-> Winner : Comp9

                  ====== WINNER OF THE MASTER ======

                  Comp9

      * Using the .jar file  
         1. Use the following command to execute :
            - The league :
               ```bash
               java -jar league.jar
               ```
            - The tournament : 
               ```bash
               java -jar tournament.jar
               ```
            - The master : 
               ```bash
               java -jar master.jar
               ```
            You will get the same outputs as above.
