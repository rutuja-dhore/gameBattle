package application.utils;

import application.constants.CharacterMoves;
import application.model.Character;

public final class Utils {

	private static final String FORMATTER_SCORE_BOARD_PREFIX = "\n---------------------------------------SCORE BOARD---------------------------------------------------";

	private static final String FORMATTER_SCORE_BOARD_RESULT_PREFIX = "---------------------------------------SCORE BOARD RESULT---------------------------------------------";

	private static final String FORMATTER_SCORE_POSTFIX = "\n----------------------------------------------------------------------------------------------------";

	private Utils() {
	}

	public static void logGameScore(Character userDefinedCharacter, Character defaultCharacter, CharacterMoves move,
			CharacterMoves generatedMove) {

		System.out.println(String.format(
				"%s %n\t Player %s attacked Player %s with %s %n\t In Return Player %s  attacked Player %s with %s %n\t %s  : %s  \t %s : %s %s",
				FORMATTER_SCORE_BOARD_PREFIX, userDefinedCharacter.getName(), defaultCharacter.getName(),
				move.toString(), defaultCharacter.getName(), userDefinedCharacter.getName(), generatedMove.toString(),
				defaultCharacter.getName(), defaultCharacter.getCharacterHealth(), userDefinedCharacter.getName(),
				userDefinedCharacter.getCharacterHealth(), FORMATTER_SCORE_POSTFIX));

	}

	public static void logGameResult(Character userDefinedCharacter, Character defaultCharacter) {
		System.out.println(FORMATTER_SCORE_BOARD_RESULT_PREFIX);
		if (defaultCharacter.getCharacterHealth() > userDefinedCharacter.getCharacterHealth())
			System.out
					.println(String.format("%s won the game.%s", defaultCharacter.getName(), FORMATTER_SCORE_POSTFIX));
		else if (defaultCharacter.getCharacterHealth() < userDefinedCharacter.getCharacterHealth())
			System.out.println(
					String.format("%s won the game.%s", userDefinedCharacter.getName(), FORMATTER_SCORE_POSTFIX));
		else
			System.out.println("Game is Tie." + FORMATTER_SCORE_POSTFIX);
	}

}
