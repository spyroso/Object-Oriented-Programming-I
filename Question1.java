// ------------------------------------------------------- 
// Assignment 2
// Written by: Spyros Orfanos - 40032280
// For COMP 248 Section EC – Summer 2019
// --------------------------------------------------------

/* Program Description: 
 * 
 * This program describes a user's Uno card. 
 * Uno cards have a value and a colour, except for wild cards, which do not have a colour. 
 *  
 *  
*/



/*
   * Algorithm Description:
   * 
   * (1) We first check if the user's card is a wild card. 
   * If it is, we assign it a colour of "NB". Otherwise, we proceed by extracting the card value and color from the user's input.
   *
   * (2) Next, we use a switch statement to determine the value of the card. Valid values cases are: 0,1,...,9, D, S, V, W, and W4.
   * If the value is not any of these, we say the card is not a valid card (also potentially incorrectly formatted card).
   * 
   * (3) Next, we use a switch statement to determine the colour of the card. Valid colour cases are: R, B, G, Y, and NC. 
   * If the colour is not any of these, we say the card is not a valid card (also potentially incorrectly formatted card).
   * 
   * (4) Next, we check if the length of the user's input exceeds 2 characters. 
   * If it is, we say the user's input is not in the valid format. Otherwise, we do nothing. 
   *
   * Note: at this point we have already checked all criteria for invalid card and invalid formats. 
   * Due to step (1), inputs such as WY are deemed invalid cards, as desired.
   * Due to step (3) & (4), user inputs of length 1 character (except for "W") are deemed invalid cards. 
   *
   * (5) Finally, we display the following result: 
   * 	If the card is not in the correct format, we say so. 
   * 	Otherwise, if the card is not valid, we say so. 
   * 	Otherwise, we give the description of the card. 
 */

import java.util.Scanner;

public class Question1 {

	public static void main(String[] args) {

		// Declaring variables
		Scanner keyIn = new Scanner(System.in);   // Create Scanner object
		String userInput, card;					  // userInput: user's card (input), card: contains colour & value of user's card
		String value, colour;					  // value: value of card, colour: colour of card


		// Welcome banner 
		System.out.println("------------------------------------------------");
		System.out.println("   Welcome to my Uno card describer program!    ");
		System.out.println("------------------------------------------------" + '\n');


		// Information for the user 
		System.out.println("Enter your playing card using the following notation:");
		System.out.println("First character should be 0 to 9, W (for Wild), D (for Draw 2), S (for Skip), or V (for Reverse)");
		System.out.println("Second character should be R for red, G for green, B for blue, or Y for yellow ");
		System.out.println("");
		
		// User prompt 
		System.out.println("What is your card?");

		// Reading user's inputs and converting to upper case (i.e., inputs are NOT case sensitive)
		userInput = keyIn.nextLine();
		card = userInput.toUpperCase();

        // Is the user's input a wild card?
        if (card.substring(0,1).equals("W")){
        	// If a wild card, we temporarily assign it "NC" (No Coulor) 
            value = card;
            colour = "NC"; 
        } else {
        	// Otherwise, value is 1st character, colour is 2nd character (and any additional 
            value = card.substring(0, 1);
    		colour = card.substring(1);
        }

        // Switch statement to determine value of the card
		switch (value) {
			case "0":
				value = "Zero";
				break;
			case "1":
				value = "One";
				break;
			case "2":
				value = "Two";
				break;
			case "3":
				value = "Three";
				break;
			case "4":
				value = "Four";
				break;
			case "5":
				value = "Five";
				break;
			case "6":
				value = "Six";
				break;
			case "7":
				value = "Seven";
				break;
			case "8":
				value = "Eight";
				break;
			case "9":
				value = "Nine";
				break;
			case "S":
				value = "Skip";
				break;
			case "D":
				value = "Draw 2";
				break;
			case "V":
				value = "Reverse";
				break;
			case "W":
				value = "Wild";
				break;
			case "W4":
				value = "Wild Draw 4";
				break;
			default:
				value = "IC"; 			// Otherwise, invalid card 
		}
		
		// Switch statement to determine color of the card 
		switch(colour) {
			case "G":
				colour = "Green";
				break;
			case "R":
				colour = "Red";
				break;
			case "Y":
				colour = "Yellow";
				break;
			case "B":
				colour = "Blue";
				break;
			case "NC":
				colour = "";
				break;
			default:
				colour = "IC"; 			// Otherwise, invalid card 	
		}
		
		// Checking for incorrect format 
		if (userInput.length() > 2) 
			value = "IF";
	
		// Displaying desired output 
		System.out.println("");

		if (value.equals("IF"))
			// If card is of incorrect format...
			System.out.println("You entered " + userInput +" which is not entered in the required format");
		else if (value.equals("IC") || colour.equals("IC"))
			// If card is invalid... 
			System.out.println("You entered " + userInput + " which is not a valid Uno card");
		else
			// If card is valid...
			System.out.println("You entered " + userInput + " which is " + value + " " + colour);
		
		// Displaying a closing message 
		System.out.println('\n' + "All done!");
	
		keyIn.close();  // Closing the scanner
	}
}
