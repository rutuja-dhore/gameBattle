package application;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Supplier;

import application.constants.CharacterMoves;
import application.model.DefaultCharacter;
import application.model.UserDefinedCharacter;
import application.utils.Utils;

public class Game {

	private Integer id;

	private UserDefinedCharacter userDefinedCharacter;

	private DefaultCharacter defaultCharacter;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public UserDefinedCharacter getUserDefinedCharacter() {
		return userDefinedCharacter;
	}

	public void setUserDefinedCharacter(UserDefinedCharacter userDefinedCharacter) {
		this.userDefinedCharacter = userDefinedCharacter;
	}

	public DefaultCharacter getDefaultCharacter() {
		return defaultCharacter;
	}

	public void setDefaultCharacter(DefaultCharacter defaultCharacter) {
		this.defaultCharacter = defaultCharacter;
	}

	public Game(Integer id, UserDefinedCharacter userDefinedCharacter, DefaultCharacter defaultCharacter) {
		super();
		this.id = id;
		this.userDefinedCharacter = userDefinedCharacter;
		this.defaultCharacter = defaultCharacter;
	}

	public Game() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((defaultCharacter == null) ? 0 : defaultCharacter.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((userDefinedCharacter == null) ? 0 : userDefinedCharacter.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Game other = (Game) obj;
		if (defaultCharacter == null) {
			if (other.defaultCharacter != null)
				return false;
		} else if (!defaultCharacter.equals(other.defaultCharacter)) {
			return false;
		}
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (userDefinedCharacter == null) {
			if (other.userDefinedCharacter != null)
				return false;
		} else if (!userDefinedCharacter.equals(other.userDefinedCharacter)) {
			return false;
		}
		return true;
	}

	public void startGame(Scanner input, Map<Integer, Game> games) {
		System.out.println("1.Create a Character.");
		this.defaultCharacter = new DefaultCharacter();
		this.userDefinedCharacter = new UserDefinedCharacter(input);
		if (this.userDefinedCharacter.getName() == null || this.userDefinedCharacter.getColour() == null
				|| this.userDefinedCharacter.getGender() == null || this.userDefinedCharacter.getHair() == null) {
			System.out.println("You cannot Play .Set Character features to Start Game.");
			return;
		}
		System.out.println(
				String.format("Your character is Successfully created!!.%n%s", this.userDefinedCharacter.toString()));
		playGame(input, games);
	}

	private void playGame(Scanner input, Map<Integer, Game> games) {
		System.out.println(String.format("Game is started between character %s and Default Character %s",
				userDefinedCharacter.getName(), defaultCharacter.getName()));

		int selectedMove = 0;
		do {
			System.out.println(
					"Select move for your character \n 1.Punch \n 2.Super Punch \n 3.Kick \n 4.Super Kick \n 5.Save/Pause Game \n 6.Quit Game");
			selectedMove = input.nextInt(); // Read user input
			switch (selectedMove) {
			case 1:
				performMove(CharacterMoves.PUNCH);
				break;
			case 2:
				performMove(CharacterMoves.SUPER_PUNCH);
				break;
			case 3:
				performMove(CharacterMoves.KICK);
				break;
			case 4:
				performMove(CharacterMoves.SUPER_KICK);
				break;
			case 5:
				Game currentGame = new Game(id, userDefinedCharacter, defaultCharacter);
				games.putIfAbsent(id, currentGame);
				break;
			case 6:
				continue;
			default:
				System.out.println("Invalid Move Selection");

			}
		} while (selectedMove != 6 && selectedMove != 5
				&& (defaultCharacter.getCharacterHealth() > 0 && userDefinedCharacter.getCharacterHealth() > 0));

		if (defaultCharacter.getCharacterHealth() <= 0 || userDefinedCharacter.getCharacterHealth() <= 0) {
			Utils.logGameResult(userDefinedCharacter, defaultCharacter);
			games.remove(id);
		}
	}

	public void resumeGame(Scanner input, Map<Integer, Game> games) {
		if (games.isEmpty()) {
			System.out.println("Exception : No Games to Resume.");
			return;
		}
		System.out.println("Select Game to Resume Playing : ");

		games.forEach((k, v) -> System.out
				.println(k + ". " + v.getUserDefinedCharacter().getName() + " - " + v.getDefaultCharacter().getName()));

		System.out.println("999.Return To Main Menu");

		int selectedGameToResume = input.nextInt();

		if (games.containsKey(selectedGameToResume)) {
			System.out.println(String.format("game you selected is : %s - %s",
					games.get(selectedGameToResume).getUserDefinedCharacter(),
					games.get(selectedGameToResume).getDefaultCharacter()));

			Game unResumedGame = games.get(selectedGameToResume);
			unResumedGame.playGame(input, games);
		} else {
			System.out.println("Exception : Invalid Game to Resume");
		}
	}

	public void exploreGameInformation(Scanner input) {
		int selectedExploreOption = 0;
		do {
			System.out.println(
					"\n 1.Details About Game \n 2.Details About Character \n 3.Details About Moves \n 4.Return To Main Menu");
			selectedExploreOption = input.nextInt(); // Read user input

			Map<Integer, Supplier<String>> aboutGameSwitch = new HashMap<>();
			aboutGameSwitch.put(1,
					() -> "Game is to fight between 2 charactes. The characters can fight by using their hands and leg. Each move has a powervalue.");
			aboutGameSwitch.put(2,
					() -> "Game is to fight between 2 charactes. The characters can fight by using their hands and leg. Each move has a powervalue.");
			aboutGameSwitch.put(3,
					() -> "There are 4 moves.Kick,Super kick, punch, Super punch. \n As you perform a move the character health reduces.");
			aboutGameSwitch.put(4, () -> "");

			if (aboutGameSwitch.get(selectedExploreOption) == null)
				System.out.println("Invalid Explore Game Selection");
			else {
				System.out.println(aboutGameSwitch.get(selectedExploreOption).get());
			}
		} while (selectedExploreOption != 4);
	}

	private void performMove(CharacterMoves move) {
		Integer opponentHealth = this.getDefaultCharacter().getCharacterHealth();
		Integer characterHealth = this.getUserDefinedCharacter().getCharacterHealth();

		this.getDefaultCharacter().setCharacterHealth(opponentHealth - move.getDecreaseHealthBy());

		CharacterMoves generatedMove = this.getDefaultCharacter().generateDefaultCharacterMove();

		this.getUserDefinedCharacter().setCharacterHealth(characterHealth - generatedMove.getDecreaseHealthBy());

		Utils.logGameScore(userDefinedCharacter, defaultCharacter, move, generatedMove);

	}

}
