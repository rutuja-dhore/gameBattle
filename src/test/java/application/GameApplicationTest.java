package application;




import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

import application.utils.TestHelper;

public class GameApplicationTest {

	String fileSeprator = "line.separator";

	@Test
	public void testGameApplicationToExploreGame() {

		String[] linesOfOutput = initGameWithScannerInput("\n1 1 4 4");

		assertEquals(8, linesOfOutput.length);

		assertEquals(
				"Game is to fight between 2 charactes. The characters can fight by using their hands and leg. Each move has a powervalue.",
				linesOfOutput[3]);
	}

	@Test
	public void testGameApplicationToStartGame() {

		String[] linesOfOutput = initGameWithScannerInput("\n2 1 2 2 \nRutuja \n6 4");

		String expectedString = "Character [gender=Male, colour=Red, hair=Short Hair, name=Rutuja , characterHealth=100]";

		assertEquals(13, linesOfOutput.length);

		assertEquals(expectedString, linesOfOutput[8]);
	}

	@Test
	public void testGameApplicationToResumeGame() {

		String[] linesOfOutput = initGameWithScannerInput("\n3 4");

		assertEquals(5, linesOfOutput.length);

		assertEquals("Exception : No Games to Resume.", linesOfOutput[2]);
	}

	@Test
	public void testGameApplicationToExitGame() {

		String[] linesOfOutput = initGameWithScannerInput("\n4");

		assertEquals(3, linesOfOutput.length);
		assertEquals("Exiting from Game. I hope you had fun.", linesOfOutput[2]);
	}

	@Test
	public void testGameApplicationWithInvalidOption() {

		String[] linesOfOutput = initGameWithScannerInput("\n5 1 1 4 4");

		assertEquals(10, linesOfOutput.length);

		assertEquals("Exception : You selected incorrect game option.Try again", linesOfOutput[2]);
	}

	private String[] initGameWithScannerInput(String scannerInput) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		System.setOut(new PrintStream(baos));

		TestHelper.input(scannerInput);
		GameApplication.main(new String[] {});

		String whatWasPrinted = new String(baos.toByteArray());
		return whatWasPrinted.split(System.getProperty(fileSeprator));
	}
}
