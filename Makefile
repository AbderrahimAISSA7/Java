JC=javac
J=java
JFLAGS = -g

classes :
	cd src; \
	$(JC) $(JFLAGS) main/*.java -d ../classes

%.jar: manifest-% classes  
	cd classes ; \
	jar cvfm ../$@ ../$< competitions competitors main matches selections util

run_league : classes
	cd classes; \
	$(J) main.LeagueMain
	
run_tournament : classes
	cd classes; \
	$(J) main.TournamentMain
	
run_master : classes
	cd classes; \
	$(J) main.MasterMain
	
run_jar_% : %.jar
	$(J) -jar $<
	
all : league.jar tournament.jar master.jar

clean:
	rm -f -r classes *.jar

.PHONY: all clean run_league run_tournament run_master