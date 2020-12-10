package com.atmecs.jsonfile.operation;

import java.io.IOException;
import java.util.Scanner;

import org.json.simple.parser.ParseException;

public class EmployeeMainClass {
	static int choice;
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) throws IOException, ParseException {
		do {
			System.out.println("Enter your Choice");
			System.out.println("1.Create Record in File\n2. Read data from file\n3.Exit");
			
			choice = scan.nextInt();

			switch (choice) {
			case 1:
				WriteClass write = new WriteClass();
				write.writeData();
				break;
			case 2:
				ReadJsonFile read = new ReadJsonFile();
				read.readFile();
				break;
			case 3:
				System.out.println("You have pressed 3..The Program has been Ended..!!");
				break;


			default:
				System.out.println("Wrong Choice..!");
				break;
			}
		} while (choice != 3);
	}
}
