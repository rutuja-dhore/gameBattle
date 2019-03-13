package application.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import application.utils.TestHelper;

public class UserDefinedCharacterTest {

	@Test
	public void testCreateCharacterWithMaleBlueBlondeHairFeatures() {
		UserDefinedCharacter character = new UserDefinedCharacter(TestHelper.input("1 1 1 \nRutuja"));
		assertEquals("Male", character.getGender());
		assertEquals("Blue", character.getColour());
		assertEquals("Blonde Hair", character.getHair());
		assertEquals("Rutuja", character.getName());
	}

	@Test
	public void testCreateCharacterWithMaleBlueBlondeHairFeaturesWithFristInvalidThenValidInput() {
		UserDefinedCharacter character = new UserDefinedCharacter(TestHelper.input("4 1 4 1 4 \n1 \nRutuja"));
		assertEquals("Male", character.getGender());
		assertEquals("Blue", character.getColour());
		assertEquals("Blonde Hair", character.getHair());
		assertEquals("Rutuja", character.getName());
	}

	@Test
	public void testCreateCharacterWithFeMaleRedShortHairFeaturesWithOnlyValidInput() {
		UserDefinedCharacter character = new UserDefinedCharacter(TestHelper.input("2 2 2 \nRutuja"));
		assertEquals("Female", character.getGender());
		assertEquals("Red", character.getColour());
		assertEquals("Short Hair", character.getHair());
		assertEquals("Rutuja", character.getName());
	}

	@Test
	public void testCreateCharacterWithFeMaleRedShortHairFeaturesWithFristInvalidThenValidInput() {
		UserDefinedCharacter character = new UserDefinedCharacter(TestHelper.input("4 2 4 2 4 \n2 \nRutuja"));
		assertEquals("Female", character.getGender());
		assertEquals("Red", character.getColour());
		assertEquals("Short Hair", character.getHair());
		assertEquals("Rutuja", character.getName());
	}

	@Test
	public void testExittoMainMenuFromCreateCharacterGenderFeatures() {
		UserDefinedCharacter character = new UserDefinedCharacter(TestHelper.input("3"));
		assertEquals(null, character.getGender());
		assertEquals(null, character.getColour());
		assertEquals(null, character.getHair());
		assertEquals(null, character.getName());
	}

	@Test
	public void testExittoMainMenuFromCreateCharacterColourFeatures() {
		UserDefinedCharacter character = new UserDefinedCharacter(TestHelper.input("1 3"));
		assertEquals("Male", character.getGender());
		assertEquals(null, character.getColour());
		assertEquals(null, character.getHair());
		assertEquals(null, character.getName());
	}

	@Test
	public void testExittoMainMenuFromCreateCharacterHairFeatures() {
		UserDefinedCharacter character = new UserDefinedCharacter(TestHelper.input("1 1 3 1"));
		assertEquals("Male", character.getGender());
		assertEquals("Blue", character.getColour());
		assertEquals(null, character.getHair());
		assertEquals(null, character.getName());
	}
}
