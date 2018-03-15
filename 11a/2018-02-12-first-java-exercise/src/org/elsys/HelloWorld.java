package org.elsys;

import java.util.Scanner;

public class HelloWorld {

	private static String WORLD_TYPE = "Java";
	
	public static void main(String[] args) {
		System.out.printf("Hello, %s World!", WORLD_TYPE);
		int array[];
		array = new int[] {0, 1, 2, 3, 4};
		modify(array);
		System.out.println(array[0]);
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
		scanner.close();
	}
	
	private static int modify(int[] array) {
		array[0] = 10;
		// calculating...
		return 0;
	}
}