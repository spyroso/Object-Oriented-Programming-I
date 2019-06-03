// ------------------------------------------------------- 
// Assignment 2
// Written by: Spyros Orfanos - 40032280
// For COMP 248 Section EC – Summer 2019
// --------------------------------------------------------

// Program description: This program 


import java.util.Scanner;

public class Question2 {

	public static void main(String[] args) {

		// Declaring variables
		Scanner keyIn = new Scanner(System.in);   	// Create Scanner object
		String userInput, ubbiDubbi;
		String words;
		int j;

		// Welcome banner 
		System.out.println("Welcome to my Ubbi Dubbi program!" + '\n');
		
		// User prompt 
		System.out.println("Please enter the English sentence you want translated into Ubbi Dubbi");
		System.out.println("(Be sure to have 1 space between words and to not have any spaces at the front and end of the sentence):");
		
		// Reading user's input
		userInput = keyIn.nextLine();
        words = " " + userInput + " ";   // Adding spaces to start/end to 1st and last words easily

		// Finding words of length 1 or 2 so we can apply special rules
        for (j = 1; j <= userInput.length(); j++) {
        	
            // If a word is 1 character long, replace it by "U" 
            if (words.charAt(j-1) == ' ' && words.charAt(j+1) == ' ')
				words = words.substring(0,j).concat("U") + words.substring(j+1);
            
            // If a word is 2 characters long, replace it by "UU"
            else if (words.charAt(j-1) == ' ' && words.charAt(j+2) == ' ')
            	words = words.substring(0,j).concat("UU") + words.substring(j+2);
        }
        
        // Replacing all vowels (except for "e"s at end of words) with "V"  
	    words = words.replace("e ", "C ");	// If last letter of a word is "e", replace it with "C"
	    words = words.replace("a", "V");
	    words = words.replace("e", "V");
	    words = words.replace("i", "V");
	    words = words.replace("o", "V");
	    words = words.replace("u", "V");
    
	    // If there are 2+ consecutive "V"s, treat only the first as "V"
		for (j = 1; j < words.length() - 1; j++) {
			if (words.substring(j, j+1).equals("V") && ( words.substring(j-1, j).equals("V") || words.substring(j-1, j).equals("C"))) {
				words = words.substring(0,j) + "C" + words.substring(j+1);
			}
		}
		
	    // Removing spaces that was added to beginning and end of sentence (line 33)
        words = words.trim();

		// Adding "ub" where necessary (determined by "V" anf 
        ubbiDubbi = userInput;
		for (j = words.length() - 1; j >= 0; j--) {
			if (words.charAt(j) == 'V' || words.charAt(j) == 'U')
				ubbiDubbi = ubbiDubbi.substring(0,j).concat("ub") + ubbiDubbi.substring(j);
		}
		
		// Displaying output
		System.out.println("Translated sentence:");
		System.out.println(ubbiDubbi);
		System.out.println("Have fun speaking it!!!");
		
		// Closing scanner 
		keyIn.close();
	}
}
