package CS231_Project;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Hi, welcome to Colossal Cave Adventure. Enter your name: ");
		String name = sc.nextLine();
		
		User user = new User(name);		
		
		System.out.format("Okay, %s. You are currently at the front-door of a house. It looks run-down and mysterious. If you dare, type 'get in' to start the adventure!\n", user.getName());
		
		String userChoice = sc.nextLine();
		
		while (true){
			user.move(userChoice.toLowerCase());
			user.print();
			userChoice = sc.nextLine();
			System.out.println("\n========================================\n");

		}

	}

}