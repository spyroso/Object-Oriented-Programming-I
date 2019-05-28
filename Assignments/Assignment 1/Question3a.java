// ------------------------------------------------------- 
// Assignment 1
// Written by: Nancy Acemian 
// Edited by: Spyros Orfanos - 40032280
// For COMP 248 Section EC – Summer 2019
// --------------------------------------------------------

// This program calculates the time elapsed between two military times (with Starting Time < Ending Time).
// In order to subtract the times, the program first converts the times into the corresponding minutes of the day (e.g.: 0105 -> 65).
// It then takes the difference, and finally converts this number back into hours and minutes. 

import java.util.Scanner;

public class Question3a
{
    public static void main(String[] args) 
    {
    	// Declaring variables and constants  
		Scanner keyIn = new Scanner(System.in);		// Create Scanner object
		final int MINS_PER_HR = 60;					// 60 minutes in 1 hour
		final int HUNDRED_HRS = 100;   				// Hundred Hours, eg: 1100 is said "eleven hundred hours"
		int startTime, endTime, totalMinsElapsed;
		int startHour, endHour, startMinute, endMinute, hoursElapsed, minutesElapsed;
		
		/* some notes about the variables: 
		 startTime & endTime: activity start/end time (given in military time)
		 totalMinsElapsed: total number of minutes elapsed between start and end time 
		 startHour & endHour: the hour of the start/end time 
		 startMinute & endMinute: the minute of the start/end time
		 hoursElapsed: number of full hours elapsed between start/end time
		 minutesElapsed: number of minutes (in remaining hour) between start/end time 
		  */	
		 
		// User prompt
		System.out.print( "Enter starting time and ending time: " );
		
		// Reading the user's inputs 
		startTime = keyIn.nextInt(); // User's Start Time
		endTime = keyIn.nextInt();   // User's End Time 
		
		// Main algorithm to calculate elapsed time 
		startHour = startTime / HUNDRED_HRS;      					// Hour of Start Time (eg: 1532 --> 15) 
		endHour = endTime / HUNDRED_HRS;          					// Hour of End Time
		startMinute = startTime % HUNDRED_HRS;						// Minute of Start Time (eg: 1532 --> 32)
		endMinute = endTime % HUNDRED_HRS; 							// Minute of End Time
		startTime = startHour * MINS_PER_HR + startMinute;			// Start Time given in minutes (relative to 0000)
		endTime = endHour * MINS_PER_HR + endMinute;				// End Time given in minutes (relative to 0000)
		totalMinsElapsed = endTime - startTime; 					// calculates the total number of minutes elapsed 
		hoursElapsed = totalMinsElapsed / MINS_PER_HR;				// number of full hours elapsed 
		minutesElapsed = totalMinsElapsed % MINS_PER_HR;			// number of minutes elapsed in remaining hour
		
		// Printing desired output
		System.out.println("Results " + hoursElapsed + '\t' + minutesElapsed);
		
		// close scanner
		keyIn.close();
	}
}
