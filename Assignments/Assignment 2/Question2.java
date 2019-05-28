// ------------------------------------------------------- 
// Assignment 2
// Written by: Spyros Orfanos - 40032280
// For COMP 248 Section EC – Summer 2019
// --------------------------------------------------------

/* This program describes a user's Uno card. 
 * Uno cards have a value and a colour, 
 *  
 *  
 *  */


import java.util.Scanner;

public class Question2 {

	public static void main(String[] args) {

		// Declaring variables
		Scanner keyIn = new Scanner(System.in);   // Create Scanner object
		String userInput, ubbiDubbi = "", words[];
		char letters[];
		int nbWords, i, j;

		// Welcome banner 
		System.out.println("Welcome to my Ubbi Dubbi program!" + '\n');

		
		// User prompt 
		System.out.println("Please enter the English sentence you want translated into Ubbi Dubbi");
		System.out.println("(Be sure to have 1 space between words and to not have any spaces at the fron and end of the sentence):");
		
		// Reading user's input
		userInput = keyIn.nextLine();
		words = userInput.split(" "); 
		nbWords = words.length;
		
		// Main algorithm 
		for (i = 0; i < nbWords; i++) {
			
			if (words[i].length() == 1)
				words[i] = "ub" + words[i];
			else if (words[i].length() == 2)
				words[i] = "ub" + words[i].substring(0,1) + "ub" + words[i].substring(1);
			else {
				// letters of the i-th word
				letters = words[i].toCharArray();
				
				// If 'e' is the last letter of a word, treat it as a constant 
				if (letters[letters.length -1] == 'e')
					letters[letters.length -1] = '0';
				
				// Finding the indices of the vowels for i-th word
				for (j = 0; j < letters.length; j++) {
					switch(letters[j]) {
						case 'a': case 'e': case 'i': case 'o': case 'u':
							letters[j] = '1';
							break;
						default: 
							letters[j] = '0';
					}
					
					// If there are 2+ consecutive vowels, treat the second as a special consonant
					if (j > 0 && letters[j] == '1' && (letters[j-1] == '1' || letters[j-1] == '2'))
						letters[j] = '2';
					//System.out.println(letters[j]); // TO DELETE 
				}
				
				// Starting from the end of the word and moving left, add 'ub' to indices with '1'
				for (j = letters.length -1 ; j >= 0; j--) {
					if (letters[j] == '1')
						words[i] = words[i].substring(0,j).concat("ub") + words[i].substring(j);
				}
				
			}
			
			
			// Regrouping the translated Ubbi Dubbi words back into a sentence 
			if (i == 0)
				ubbiDubbi = words[i];
			else 
				ubbiDubbi = ubbiDubbi + " " + words[i];

		}
		
		// Displaying output
		System.out.println("Translated sentence:");
		System.out.println(ubbiDubbi);
		System.out.println("Have fun speaking it!!!");


		// Closing scanner 
		keyIn.close();
		
	}
}
