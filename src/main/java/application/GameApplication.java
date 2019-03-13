package application;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GameApplication {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int gameCount = 0;
		Map<Integer, Game> games = new HashMap<>();
		int selectedGameOption = 0;

		System.out.println("Welcome to Battleship! Are you ready to play... Press (enter) to see the options");
		scanner.nextLine();// enter
		do {
			System.out.println("1.About Game \n2.Start New Game \n3.Resume Game \n4.Exit \nSelect a option : ");

			selectedGameOption = scanner.nextInt(); // Read user input

			switch (selectedGameOption) {
			case 1:
				new Game().exploreGameInformation(scanner);
				break;
			case 2:
				gameCount++;
				Game newGame = new Game();
				newGame.setId(gameCount);
				newGame.startGame(scanner, games);
				break;
			case 3:
				new Game().resumeGame(scanner, games);
				break;
			case 4:
				System.out.println("Exiting from Game. I hope you had fun.");
				break;
			default:
				System.out.println("Exception : You selected incorrect game option.Try again");
			}
		} while (selectedGameOption != 4);
		scanner.close();
	}
}