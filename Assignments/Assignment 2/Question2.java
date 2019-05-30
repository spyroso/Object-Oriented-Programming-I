// ------------------------------------------------------- 
// Assignment 2
// Written by: Spyros Orfanos - 40032280
// For COMP 248 Section EC – Summer 2019
// --------------------------------------------------------


// This program translates a phrase from English to Ubbi Dubbi. 




import java.util.Scanner;

public class Question2 {

	public static void main(String[] args) {

		// Declaring variables
		Scanner keyIn = new Scanner(System.in);   	// Create Scanner object
		String userInput, ubbiDubbi;				// userInput: user's input, ubbiDubbi: the translated sentence
		String words[], addUb = "";					/* words: each word of the sentence, addUb: where to add the "ub"s,  
														note: these two variables are updated throughout the code) */ 
		int i, j; 									// i: number of words, j: number of characters of user's input

		// Welcome banner 
		System.out.println("Welcome to my Ubbi Dubbi program!" + '\n');
		
		// User prompt 
		System.out.println("Please enter the English sentence you want translated into Ubbi Dubbi");
		System.out.println("(Be sure to have 1 space between words and to not have any spaces at the front and end of the sentence):");
		
		// Reading user's input
		userInput = keyIn.nextLine();
        words = userInput.split(" ");
        
        
        
        // Preliminary check: for finding where to add "ub" (for now, just looking for vowels )
        for (i = 0; i < words.length; i++) {
        	
            // For each word, replace all vowels (except for "e"s at end of word) with "V"  
		    words[i] = words[i] + " ";					// Add space to check if last letter is "e"
		    words[i] = words[i].replace("e ", "C ");	// If last letter is "e", treat as consonant
		    words[i] = words[i].replace("a", "V");
		    words[i] = words[i].replace("e", "V");
		    words[i] = words[i].replace("i", "V");
		    words[i] = words[i].replace("o", "V");
		    words[i] = words[i].replace("u", "V");
		    words[i] = words[i].substring(0, words[i].length() -1);  // Removing space that was added
			
			// Regrouping the modified 'words' back into one string (i.e. a sentence)
			if (i == 0)
				addUb = words[i];
			else 
				addUb = addUb + " " + words[i];
		}

	    
	    // If there are 2+ consecutive vowels, treat the trailing vowel(s) as consonant(s)
		for (j = 1; j < addUb.length() - 1; j++) {
			if (addUb.charAt(j) == 'V' && (addUb.charAt(j-1) == 'V' || addUb.charAt(j-1) == 'C'))
				addUb = addUb.substring(0,j) + "C" + addUb.substring(j+1);
		}
	
		
		// Finalizing where to add "ub" for all words 
		words = addUb.split(" ");
        for (i = 0; i < words.length; i++) {
    		// Considering special cases for words of length 1 or 2
        	if (words[i].length() == 1) 
        		// If word is 1 character, add one "ub" 
        		words[i] = "V";
        	else if (words[i].length() == 2) 
        		// If word is 2 characters, add two "ub"'s
        		words[i] = "VV";
        	else 
        		// Otherwise, proceed as usual 
        		words[i] = words[i];
        	
        	// Regrouping the modified 'words' back into one string (i.e. a sentence)
			if (i == 0)
				addUb = words[i];
			else 
				addUb = addUb + " " + words[i];
        }
        
        // Adding "ub" where necessary. We move from right to left to keep indices in right place
        ubbiDubbi = userInput;
		for (j = addUb.length() - 1; j >= 0; j--) {
			if (addUb.charAt(j) == 'V')
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
