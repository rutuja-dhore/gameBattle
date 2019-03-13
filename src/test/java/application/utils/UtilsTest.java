package application.utils;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import application.constants.CharacterMoves;
import application.model.DefaultCharacter;
import application.model.UserDefinedCharacter;

public class UtilsTest {
	private static final String FORMATTER_SCORE_BOARD_PREFIX = "\n---------------------------------------SCORE BOARD---------------------------------------------------";

	private static final String FORMATTER_SCORE_BOARD_RESULT_PREFIX = "---------------------------------------SCORE BOARD RESULT---------------------------------------------";

	private static final String FORMATTER_SCORE_POSTFIX = "\n----------------------------------------------------------------------------------------------------";

	private static final String LINE_SEPERATOR ="line.separator";
	@Test
	public void testlogGameScore() {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		System.setOut(new PrintStream(baos));
		UserDefinedCharacter character = new UserDefinedCharacter(input("1 1 1 \nRutuja"));
		DefaultCharacter defaultCharacter = new DefaultCharacter();
		CharacterMoves characterMove = new DefaultCharacter().generateDefaultCharacterMove();
		CharacterMoves characterMoves = CharacterMoves.findByMoveNo(2);
		Utils.logGameScore(character, defaultCharacter, characterMoves, characterMove);
		String whatWasPrinted = new String(baos.toByteArray());
		String[] linesOfOutput = whatWasPrinted.split(System.getProperty(LINE_SEPERATOR));
		assertEquals(FORMATTER_SCORE_BOARD_PREFIX + " ", linesOfOutput[4]);
		assertEquals("\t Player Rutuja attacked Player Cammy with " + characterMoves + " ", linesOfOutput[5]);
		assertEquals("\t In Return Player Cammy  attacked Player Rutuja with " + characterMove + " ", linesOfOutput[6]);
		assertEquals("\t Cammy  : 100  \t Rutuja : 100 " + FORMATTER_SCORE_POSTFIX, linesOfOutput[7]);
	}

	@Test
	public void testlogGameResultTie() {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		System.setOut(new PrintStream(baos));
		UserDefinedCharacter character = new UserDefinedCharacter(input("1 1 1 \nRutuja"));
		DefaultCharacter defaultCharacter = new DefaultCharacter();
		Utils.logGameResult(character, defaultCharacter);
		String whatWasPrinted = new String(baos.toByteArray());
		String[] linesOfOutput = whatWasPrinted.split(System.getProperty(LINE_SEPERATOR));
		assertEquals(FORMATTER_SCORE_BOARD_RESULT_PREFIX, linesOfOutput[4]);
		assertEquals("Game is Tie." + FORMATTER_SCORE_POSTFIX, linesOfOutput[5]);
	}

	@Test
	public void testlogGameResultUserWin() {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		System.setOut(new PrintStream(baos));
		UserDefinedCharacter character = new UserDefinedCharacter(input("1 1 1 \nRutuja"));
		character.setCharacterHealth(100);
		DefaultCharacter defaultCharacter = new DefaultCharacter();
		defaultCharacter.setCharacterHealth(0);
		Utils.logGameResult(character, defaultCharacter);
		String whatWasPrinted = new String(baos.toByteArray());
		String[] linesOfOutput = whatWasPrinted.split(System.getProperty(LINE_SEPERATOR));
		assertEquals(FORMATTER_SCORE_BOARD_RESULT_PREFIX, linesOfOutput[4]);
		assertEquals(character.getName() + " won the game." + FORMATTER_SCORE_POSTFIX, linesOfOutput[5]);
	}

	@Test
	public void testlogGameResultRobotUserWin() {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		System.setOut(new PrintStream(baos));
		UserDefinedCharacter character = new UserDefinedCharacter(input("1 1 1 \nRutuja"));
		character.setCharacterHealth(0);
		DefaultCharacter defaultCharacter = new DefaultCharacter();
		defaultCharacter.setCharacterHealth(100);
		Utils.logGameResult(character, defaultCharacter);
		String whatWasPrinted = new String(baos.toByteArray());
		String[] linesOfOutput = whatWasPrinted.split(System.getProperty(LINE_SEPERATOR));
		assertEquals(FORMATTER_SCORE_BOARD_RESULT_PREFIX, linesOfOutput[4]);
		assertEquals(defaultCharacter.getName() + " won the game." + FORMATTER_SCORE_POSTFIX, linesOfOutput[5]);
	}

	@Test
	public void testlogGameScoreNullPointerException() {
		UserDefinedCharacter character = null;
		DefaultCharacter defaultCharacter = null;
		CharacterMoves characterMove = null;
		CharacterMoves characterMoves = null;
		Assertions.assertThrows(NullPointerException.class, () -> Utils.logGameScore(character, defaultCharacter, characterMoves, characterMove));
	}

	@Test
	public void testlogGameResultNullPointerException() {
		UserDefinedCharacter character = null;
		DefaultCharacter defaultCharacter = null;
		Assertions.assertThrows(NullPointerException.class, () -> Utils.logGameResult(character, defaultCharacter));

	}

	public Scanner input(String test) {
		ByteArrayInputStream ian = new ByteArrayInputStream(test.getBytes());
		System.setIn(ian);
		System.setIn(new ByteArrayInputStream(test.getBytes()));
		return new Scanner(System.in);
	}
}