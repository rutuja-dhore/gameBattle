package application.model;

import java.util.Random;

import application.constants.CharacterMoves;

public class DefaultCharacter extends Character {

	public DefaultCharacter() {
		this.colour = "Red";
		this.gender = "Female";
		this.hair = "Blonde Hair";
		this.name = "Cammy";
	}

	public CharacterMoves generateDefaultCharacterMove() {
		int n = 4;
		while (true) {
			int defaultCharacterMove = new Random().nextInt(n);
			if (defaultCharacterMove != 0) {
				return CharacterMoves.findByMoveNo(defaultCharacterMove);
			}
		}
	}

}
