// ------------------------------------------------------- 
// Assignment 1
// Written by: Spyros Orfanos - 40032280
// For COMP 248 Section EC – Summer 2019
// --------------------------------------------------------

/* This program takes 3 words from a user input, and then displays these 3 words in 
   reverse order, with the 1st letter capitalized and the rest in lower case. */

import java.util.Scanner;

public class Question2 
{
	public static void main(String[] args) 
	{
		// Declaring variables 
		Scanner keyIn = new Scanner(System.in);  	// Create a Scanner object to read user's input
		String userWords, outputWords;				// userWords: user's input as one string, outputWords: program's output as one string
		String word1, word2, word3;					// extract the user's inputs into 3 words 
		int space1, space2; 						// index of the 1st and 2nd space in user input 

		// Welcome banner   
		System.out.println("\\\\---------------------------------");
		System.out.println("\\\\ String Splitter Program");
		System.out.println("\\\\---------------------------------" + '\n');
	
		// User prompt
		System.out.println("Enter 3 words separated by a blank:");
		
		// Reading user input as a string 
		userWords = keyIn.nextLine(); 												

		// Index of the two spaces in the user's input 
		space1 = userWords.indexOf(' ');
		space2 = userWords.indexOf(' ', space1 +1);
				
		// Extracting the 3 words 
		word1 = userWords.substring(0, space1);				// word1 = characters until 1st space appears 
		word2 = userWords.substring(space1 + 1, space2); 	// word2 = characters between sapce1 and space2 
		word3 = userWords.substring(space2 + 1);			// word3 = characters after space2

		// Putting it all together 
		outputWords = word3 + " " + word2 + " " + word1;  	// Reversing order of the 3 words, adding space between words
		outputWords = outputWords.substring(0,1).toUpperCase() + outputWords.substring(1).toLowerCase();  // 1st letter upper case, rest lower case
				
		// Printing desired output 
		System.out.println('\n' + "Words in reverse order:");
		System.out.println(outputWords);
		System.out.println('\n' + "All done!!!");;
		
		keyIn.close(); // Closing scanner 
	}
}