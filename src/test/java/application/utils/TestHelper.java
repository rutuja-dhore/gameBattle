package application.utils;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

public class TestHelper {

	private TestHelper() {}
	
	public static Scanner input(String test) {
		ByteArrayInputStream ian = new ByteArrayInputStream(test.getBytes());
		System.setIn(ian);
		System.setIn(new ByteArrayInputStream(test.getBytes()));

		return new Scanner(System.in);
	}
}
