JC=javac
CDIR=./class
JDIR=.
JFLAGS= -g -Xlint
RM=rm -fr
JUNITTEST = org.junit.runner.JUnitCore
CLASSPATH = .:junit-4.10.jar


FILES=\
	Customer\
	Register\
	Queue\
	Store\
	Simulation\
	Simulator\

CLASSES=$(patsubst %,$(CDIR)/%.class,$(FILES))


$(CDIR)/%.class: $(JDIR)/%.java
	@echo "##\tMAKE\tCompiling " $*
	@$(JC) $(JFLAGS) -cp $(CLASSPATH) -d $(CDIR) $^

default: $(CLASSES) clean

test: 
	javac -Xlint -cp $(CLASSPATH) *.java
	java -cp $(CLASSPATH) $(JUNITTEST) TestAll
	rm -fr *.class

clean:
	@echo "##\tMAKE\tCleaning upp"
	@$(RM) *~ *# .#*

jar: default
	cd $(CDIR) && jar cfe InLupp4.jar Simulator *.class

run: jar
	java -jar $(CDIR)/InLupp4.jar
