package edu.deakin.sit333;

/**
 * Hello world!
 *	
 * @author Ahsan Habib
 */
public class Main {

	/*
	 * Main entry point of a Java program.
	 */
	public static void main(String[] args) {

		int choice = 3;

		switch (choice) {
		case 1:
			SeleniumOperations.openBrowserAndClose();
			break;
		case 2:
			SeleniumOperations.openBrowserMaximizeClose();
			break;
		case 3:
			SeleniumOperations.loadWebPageClose();
			break;
		case 4:
			SeleniumOperations.openBrowserLoadPageResizeClose();
			break;
		default:
			System.out.println("Invalid choice.");
			break;
		}
	}
}
