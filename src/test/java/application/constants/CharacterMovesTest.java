package application.constants;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

public class CharacterMovesTest {

	@Test
	public void testCharacterMovesPunch() {
		CharacterMoves characterMoves = CharacterMoves.findByMoveNo(1);
		assertEquals(CharacterMoves.PUNCH.getDecreaseHealthBy(), characterMoves.getDecreaseHealthBy());
	}

	@Test
	public void testCharacterMovesSuperPunch() {
		CharacterMoves characterMoves = CharacterMoves.findByMoveNo(2);
		assertEquals(CharacterMoves.SUPER_PUNCH.getDecreaseHealthBy(), characterMoves.getDecreaseHealthBy());
	}

	@Test
	public void testCharacterMovesKick() {
		CharacterMoves characterMoves = CharacterMoves.findByMoveNo(3);
		assertEquals(CharacterMoves.KICK.getDecreaseHealthBy(), characterMoves.getDecreaseHealthBy());
	}

	@Test
	public void testCharacterMovesSuperKick() {
		CharacterMoves characterMoves = CharacterMoves.findByMoveNo(4);
		assertEquals(CharacterMoves.SUPER_KICK.getDecreaseHealthBy(), characterMoves.getDecreaseHealthBy());
	}

	@Test
	public void testCharacterMovesNull() {
		CharacterMoves characterMoves = CharacterMoves.findByMoveNo(-1);
		assertNull(characterMoves);
	}
}
