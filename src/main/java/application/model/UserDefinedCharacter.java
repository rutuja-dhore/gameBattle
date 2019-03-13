package application.model;

import java.util.Scanner;

public class UserDefinedCharacter extends Character {

	public UserDefinedCharacter(Scanner input) {
		boolean setGender = false;
		do {
			System.out.println("Select Gender \n 1.Male \n 2.Female \n 3.Return To Main Menu");
			int selectedGender = input.nextInt(); // Read user input

			switch (selectedGender) {
			case 1:
				this.gender = "Male";
				setGender = true;
				break;
			case 2:
				this.gender = "Female";
				setGender = true;
				break;
			case 3:
				return;
			default:
				System.out.println("Invalid Gender Selection");
			}
		} while (!setGender);

		boolean setColour = false;
		do {
			System.out.println("Select Colour \n 1.Blue \n 2.Red \n 3.Return To Main Menu");
			int selectedColour = input.nextInt(); // Read user input

			switch (selectedColour) {
			case 1:
				this.colour = "Blue";
				setColour = true;
				break;
			case 2:
				this.colour = "Red";
				setColour = true;
				break;
			case 3:
				return;
			default:
				System.out.println("Invalid Colour Selection");
			}

		} while (!setColour);

		boolean setHair = false;
		do {
			System.out.println("Select hairs \n 1.Blonde Hair \n 2.Short Hair \n 3.Return To Main Menu");
			int selectedHair = input.nextInt(); // Read user input
			input.nextLine();

			switch (selectedHair) {
			case 1:
				this.hair = "Blonde Hair";
				setHair = true;
				break;
			case 2:
				this.hair = "Short Hair";
				setHair = true;
				break;
			case 3:
				return;
			default:
				System.out.println("Invalid Hair Selection");
			}
		} while (!setHair);

		System.out.println("Enter a Name for your Character :");
		String characterName = input.nextLine(); // Read user input
		this.name = characterName;
	}

}
