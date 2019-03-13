package application.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import application.constants.CharacterMoves;

public class DefaultCharacterTest {

	@Test
	public void testCreateDefaultCharacter() {
		DefaultCharacter defaultCharacter = new DefaultCharacter();
		assertEquals("Female", defaultCharacter.getGender());
		assertEquals("Red", defaultCharacter.getColour());
		assertEquals("Cammy", defaultCharacter.getName());
		assertEquals("Blonde Hair", defaultCharacter.getHair());
	}

	@Test
	public void testWithMatchers() {
		CharacterMoves characterMove = new DefaultCharacter().generateDefaultCharacterMove();
		assertTrue(Arrays.stream(CharacterMoves.values()).map(CharacterMoves::getMoveNo)
				.anyMatch(move -> move == characterMove.getMoveNo()));
	}
}
