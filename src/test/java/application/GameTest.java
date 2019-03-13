package application;



import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import application.utils.TestHelper;

public class GameTest {
	String fileSeprator = "line.separator";

	@Test
	public void testStartGameWithoutSettingGenderCharacterFeatures() {
		Map<Integer, Game> games = new HashMap<>();
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		System.setOut(new PrintStream(baos));
		new Game().startGame(TestHelper.input("3 2 2 \nRutuja"), games);
		String whatWasPrinted = new String(baos.toByteArray());
		String[] linesOfOutput = whatWasPrinted.split(System.getProperty(fileSeprator));
		assertEquals(3, linesOfOutput.length);
		assertEquals("You cannot Play .Set Character features to Start Game.", linesOfOutput[2]);
	}

	@Test
	public void testStartGameWithoutSettingColourCharacterFeatures() {
		Map<Integer, Game> games = new HashMap<>();
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		System.setOut(new PrintStream(baos));
		new Game().startGame(TestHelper.input("1 3 2 \nRutuja"), games);
		String whatWasPrinted = new String(baos.toByteArray());
		String[] linesOfOutput = whatWasPrinted.split(System.getProperty(fileSeprator));
		assertEquals(4, linesOfOutput.length);
		assertEquals("You cannot Play .Set Character features to Start Game.", linesOfOutput[3]);
	}

	@Test
	public void testStartGameWithoutSettingHairCharacterFeatures() {
		Map<Integer, Game> games = new HashMap<>();
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		System.setOut(new PrintStream(baos));
		new Game().startGame(TestHelper.input("1 2 3 \nRutuja"), games);
		String whatWasPrinted = new String(baos.toByteArray());
		String[] linesOfOutput = whatWasPrinted.split(System.getProperty(fileSeprator));
		assertEquals(5, linesOfOutput.length);
		assertEquals("You cannot Play .Set Character features to Start Game.", linesOfOutput[4]);
	}

	@Test
	public void testStartGame() {
		Map<Integer, Game> games = new HashMap<>();
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		System.setOut(new PrintStream(baos));
		new Game().startGame(TestHelper.input("1 2 2 \nRutuja \n6"), games);
		String whatWasPrinted = new String(baos.toByteArray());
		String[] linesOfOutput = whatWasPrinted.split(System.getProperty(fileSeprator));
		String expectedString = "Character [gender=Male, colour=Red, hair=Short Hair, name=Rutuja , characterHealth=100]";
		assertEquals(expectedString, linesOfOutput[6]);
	}

	@Test
	public void testStartGameAndPerformPunchMove() {
		Map<Integer, Game> games = new HashMap<>();
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		System.setOut(new PrintStream(baos));
		Scanner scanner = TestHelper.input("1 2 2 \nRutuja \n1 \n6");
		Game game = new Game();
		game.startGame(scanner, games);
		assertEquals(Integer.valueOf(95), game.getDefaultCharacter().getCharacterHealth());
	}

	@Test
	public void testStartGameAndPerformSuperPunchMove() {
		Map<Integer, Game> games = new HashMap<>();
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		System.setOut(new PrintStream(baos));
		Game game = new Game();
		game.startGame(TestHelper.input("1 2 2 \nRutuja \n2 \n6"), games);
		assertEquals(Integer.valueOf(90), game.getDefaultCharacter().getCharacterHealth());
	}

	@Test
	public void testStartGameAndPerformKickMove() {
		Map<Integer, Game> games = new HashMap<>();
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		System.setOut(new PrintStream(baos));
		Game game = new Game();
		game.startGame(TestHelper.input("1 2 2 \nRutuja \n3 \n6"), games);
		assertEquals(Integer.valueOf(92), game.getDefaultCharacter().getCharacterHealth());
	}

	@Test
	public void testStartGameAndPerformSuperKickMove() {
		Map<Integer, Game> games = new HashMap<>();
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		System.setOut(new PrintStream(baos));
		Game game = new Game();
		game.startGame(TestHelper.input("1 2 2 \nRutuja \n4 \n6"), games);
		assertEquals(Integer.valueOf(85), game.getDefaultCharacter().getCharacterHealth());
	}

	@Test
	public void testStartGameWithInvalidMove() {
		Map<Integer, Game> games = new HashMap<>();
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		System.setOut(new PrintStream(baos));
		new Game().startGame(TestHelper.input("1 2 2 \nRutuja \n7 \n6"), games);
		String whatWasPrinted = new String(baos.toByteArray());
		String[] linesOfOutput = whatWasPrinted.split(System.getProperty(fileSeprator));
		assertEquals(11, linesOfOutput.length);
		assertEquals("Invalid Move Selection", linesOfOutput[9]);
	}

	@Test
	public void testStartGameAndPerformPunchAndSaveGame() {
		Map<Integer, Game> games = new HashMap<>();
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		System.setOut(new PrintStream(baos));
		new Game().startGame(TestHelper.input("1 2 2 \nRutuja \n1 \n5"), games);
		assertEquals(1, games.size());
	}

	@Test
	public void testExploreAboutGame() {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		System.setOut(new PrintStream(baos));
		new Game().exploreGameInformation(TestHelper.input("1 4"));
		String whatWasPrinted = new String(baos.toByteArray());
		String[] linesOfOutput = whatWasPrinted.split(System.getProperty(fileSeprator));
		assertEquals(3, linesOfOutput.length);
		assertEquals(
				"Game is to fight between 2 charactes. The characters can fight by using their hands and leg. Each move has a powervalue.",
				linesOfOutput[1]);
	}

	@Test
	public void testExploreAboutCharacter() {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		System.setOut(new PrintStream(baos));
		new Game().exploreGameInformation(TestHelper.input("2 4"));
		String whatWasPrinted = new String(baos.toByteArray());
		String[] linesOfOutput = whatWasPrinted.split(System.getProperty(fileSeprator));
		assertEquals(3, linesOfOutput.length);
		assertEquals(
				"Game is to fight between 2 charactes. The characters can fight by using their hands and leg. Each move has a powervalue.",
				linesOfOutput[1]);
	}

	@Test
	public void testExploreAboutMove() {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		System.setOut(new PrintStream(baos));
		new Game().exploreGameInformation(TestHelper.input("3 4"));
		String whatWasPrinted = new String(baos.toByteArray());
		String[] linesOfOutput = whatWasPrinted.split(System.getProperty(fileSeprator));
		assertEquals(3, linesOfOutput.length);
		assertEquals(
				"There are 4 moves.Kick,Super kick, punch, Super punch. \n As you perform a move the character health reduces.",
				linesOfOutput[1]);
	}

	@Test
	public void testExploreAboutWithInvalidOption() {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		System.setOut(new PrintStream(baos));
		new Game().exploreGameInformation(TestHelper.input("8 4"));
		String whatWasPrinted = new String(baos.toByteArray());
		String[] linesOfOutput = whatWasPrinted.split(System.getProperty(fileSeprator));
		assertEquals(3, linesOfOutput.length);
		assertEquals("Invalid Explore Game Selection", linesOfOutput[1]);
	}

	@Test
	public void testResumeGame() {
		Map<Integer, Game> games = new HashMap<>();
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		System.setOut(new PrintStream(baos));
		Game gameOne = new Game();
		gameOne.setId(1);
		gameOne.startGame(TestHelper.input("1 2 2 \nRutuja \n1 \n5"), games);
		assertEquals(Integer.valueOf(95), gameOne.getDefaultCharacter().getCharacterHealth());
		Game gameTwo = new Game();
		gameOne.setId(2);
		gameTwo.startGame(TestHelper.input("1 2 2 \nRutuja \n2 \n5"), games);
		assertEquals(Integer.valueOf(90), gameTwo.getDefaultCharacter().getCharacterHealth());
		assertEquals(2, games.size());
		gameOne.resumeGame(TestHelper.input("1 1 5 6"), games);
		assertEquals(Integer.valueOf(90), gameOne.getDefaultCharacter().getCharacterHealth());
	}

	@Test
	public void testResumeGameWithInvalidGameOption() {
		Map<Integer, Game> games = new HashMap<>();
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		System.setOut(new PrintStream(baos));
		Game gameOne = new Game();
		gameOne.setId(1);
		gameOne.startGame(TestHelper.input("1 2 2 \nRutuja \n1 \n5"), games);
		assertEquals(Integer.valueOf(95), gameOne.getDefaultCharacter().getCharacterHealth());
		Game gameTwo = new Game();
		gameOne.setId(2);
		gameTwo.startGame(TestHelper.input("1 2 2 \nRutuja \n2 \n5"), games);
		assertEquals(Integer.valueOf(90), gameTwo.getDefaultCharacter().getCharacterHealth());
		assertEquals(2, games.size());
		gameOne.resumeGame(TestHelper.input("3 1 5 6"), games);
		String whatWasPrinted = new String(baos.toByteArray());
		String[] linesOfOutput = whatWasPrinted.split(System.getProperty(fileSeprator));
		assertEquals(33, linesOfOutput.length);
		assertEquals("Exception : Invalid Game to Resume", linesOfOutput[32]);
	}

	@Test
	public void testResumeGameWithoutSavedGames() {
		Map<Integer, Game> games = new HashMap<>();
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		System.setOut(new PrintStream(baos));
		Game gameOne = new Game();
		gameOne.setId(1);
		gameOne.startGame(TestHelper.input("1 2 2 \nRutuja \n1 \n6"), games);
		assertEquals(Integer.valueOf(95), gameOne.getDefaultCharacter().getCharacterHealth());
		Game gameTwo = new Game();
		gameOne.setId(2);
		gameTwo.startGame(TestHelper.input("1 2 2 \nRutuja \n2 \n6"), games);
		assertEquals(Integer.valueOf(90), gameTwo.getDefaultCharacter().getCharacterHealth());
		assertEquals(0, games.size());
		gameOne.resumeGame(TestHelper.input("1 1 5 6"), games);
		String whatWasPrinted = new String(baos.toByteArray());
		String[] linesOfOutput = whatWasPrinted.split(System.getProperty(fileSeprator));
		assertEquals(29, linesOfOutput.length);
		assertEquals("Exception : No Games to Resume.", linesOfOutput[28]);
	}
}
