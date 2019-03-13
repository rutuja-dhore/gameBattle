package application.model;

public class Character {

	protected String gender;
	protected String colour;
	protected String hair;
	protected String name;
	protected Integer characterHealth = 100;

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public String getHair() {
		return hair;
	}

	public void setHair(String hair) {
		this.hair = hair;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCharacterHealth() {
		return this.characterHealth >= 0 ? characterHealth : 0;
	}

	public void setCharacterHealth(Integer characterHealth) {
		this.characterHealth = characterHealth;
	}

	@Override
	public String toString() {
		return "Character [gender=" + gender + ", colour=" + colour + ", hair=" + hair + ", name=" + name
				+ ", characterHealth=" + characterHealth + "]";
	}
}
