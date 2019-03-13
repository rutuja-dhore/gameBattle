## Battleship Game
A Java command line based role playing game.

Here are the stories:

1.About Game
2.Start New Game
3.Resume Game
4.Exit

About Game explores more about the game, its character and moves.

Start a new Game needs to create a character .

You have to set character features that includes setting Gender,Colour,Hair,Name.

The game is to played between 2 characters - DefaultCharacter(Application created) and a UserDefinedCharacter(You created above).

As the game starts the character can perform Punch,Kick,Super Punch,Super Kick and maintain its Health to win the game.

The character with Maximum health wins the game.

If the health is same then there is a Tie between 2 players.

You can save the current game and create another character and start a new game.

The saved games can be resumed again, and you can play from there again.


#### Technology used
- Java 8 : programming language 
- Junit 5: Unit Testing
- Sonarqube : Code analysis
- Maven : Build tool
 
#### Steps to run the project

> Prerequisite
- Java 8
- Junit 5
- Sonarqube

To build the application

   >mvn install

Start the application

Through following command run the jar file:

   >java -jar target\comapanygame-0.0.1-SNAPSHOT-jar-with-dependencies.jar    
    
To analyse the code by sonarqube

   >mvn sonar:sonar
You can see the sonar analysis on sonar url default localhost:9000
    
To check the result of the test, please throw following command in the terminal:
    
   >mvn test
    
#### Architectural points and Terminologies used in the project

> Modularise

For the time being I have modularise the project on package level.
Later we can also modularise in maven modules.    
    
> Developer should take ownership of code, hence testing is IMPORTANT!
  
> Comments in code 

Entire code styling is influenced by Clean Code principle - Robert Martin
Which says
'Truth can only be found in one place: the code’.
So you may not found any comments anywhere in the project.
Keeping in mind that git can be used to versioning of file and method, class names should be kept as self explanatory.

However, if you need comments on each file. I can do that too.

> Design principles used in Project :

- SOLID (single responsibility, open-closed, Liskov subsitution, interface segragation, dependency inversion) principle
- Composition over inheritance
- DRY(Don’t repeat yourself)
- KISS(Keep it simple, stupid)