package application.constants;

public enum CharacterMoves {

	PUNCH(1, 5), SUPER_PUNCH(2, 10), KICK(3, 8), SUPER_KICK(4, 15);

	private int moveNo;
	private int decreaseHealthBy;

	CharacterMoves(int moveNo, int decreaseHealthBy) {
		this.moveNo = moveNo;
		this.decreaseHealthBy = decreaseHealthBy;
	}

	public int getDecreaseHealthBy() {
		return decreaseHealthBy;
	}

	public double getMoveNo() {
		return moveNo;
	}

	public static CharacterMoves findByMoveNo(int moveNo) {
		for (CharacterMoves c : values()) {
			if (c.getMoveNo() == moveNo) {
				return c;
			}
		}
		return null;
	}
}
