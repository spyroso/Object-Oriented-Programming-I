// ------------------------------------------------------- 
// Assignment 1
// Written by: Spyros Orfanos - 40032280
// For COMP 248 Section EC – Summer 2019
// --------------------------------------------------------
	

/* This program calculates the time elapsed between two military times.
   In order to subtract the times, the program first converts the times into the corresponding minutes of the day (eg: 0105 -> 65).
   It then takes the difference, and finally converts this number back into hours and minutes. 
   It also gives the time of day (eg: morning) that the activity started and ended. 

	Note: This program still works if the activity lasts overnight.
*/ 
		
import java.util.Scanner;

public class Question3b 
{
    public static void main(String[] args) 
    {
    	// Declaring variables and constants 
		Scanner keyIn = new Scanner(System.in);   // Create Scanner object
		final int MINS_PER_HR = 60;				  // 60 minutes in 1 hour
		final int HUNDRED_HRS = 100;			  // Hundred Hours, eg: 1100 is said "eleven hundred hours"
		int startTime, endTime, totalMinsElapsed;
		int startHour, endHour, startMinute, endMinute, hoursElapsed, minutesElapsed;
		String startTOD, endTOD;
		
		/* some notes about the variables: 
		 startTime & endTime: activity start/end time (given in military time)
		 totalMinsElapsed: total number of minutes elapsed between start and end time 
		 startHour & endHour: the hour of the start/end time 
		 startMinute & endMinute: the minute of the start/end time
		 hoursElapsed: number of full hours elapsed between start/end time
		 minutesElapsed: number of minutes (in remaining hour) between start/end time
		 startTOD & endTOD: the time during the day when the activity started/ended (eg: 'in the morning') 
		  */	
		 
		// Welcome banner 
		System.out.println( "\\--- Tic --- Toc --- Tic --- Toc --- Tic --- Toc --- \\" );
		System.out.println( "\\                                                    \\" ); 
		System.out.println( "\\       Elapsed Time Calculator -  Version 2         \\" );
		System.out.println( "\\                                                    \\" ); 
		System.out.println( "\\--- Tic --- Toc --- Tic --- Toc --- Tic --- Toc --- \\" + '\n');
		
		// User prompt
		System.out.print("Enter starting and ending time in military notation: " );
		
		// Reading the user's inputs 
		startTime = keyIn.nextInt(); 	// User's Start Time
		endTime = keyIn.nextInt();   	// User's End Time 
		
		// Starting Time Of Day (eg: morning)
		if(startTime < 600 ) {
			startTOD = "in middle of the night";  			// if 0 <= startTime < 600,
		} else if (startTime < 1200){
			startTOD = "in the morning";					// if 600 <= startTime < 1200 
		} else if (startTime < 1800) {							
			startTOD = "during the day";					// if 1200 <= startTime < 1800 
		} else {
			startTOD = "in the evening";					// if 1800 <= startTime
		}
		
		// Ending Time Of Day (same logic as above) 
		if(endTime < 600 ) {
			endTOD = "in middle of the night";
		} else if (endTime < 1200){
			endTOD = "in the morning";
		} else if (endTime < 1800) {
			endTOD = "during the day";
		} else {
			endTOD = "in the evening";
		}
		
		// Converting starting time and ending time into minutes 
		startHour = startTime / HUNDRED_HRS;      					// Hour of Start Time (eg: 1532 --> 15) 
		endHour = endTime / HUNDRED_HRS;          					// Hour of End Time
		startMinute = startTime % HUNDRED_HRS;						// Minute of Start Time (eg: 1532 --> 32)
		endMinute = endTime % HUNDRED_HRS; 							// Minute of End Time
		startTime = startHour * MINS_PER_HR + startMinute;			// Start Time given in minutes (relative to 0000)
		endTime = endHour * MINS_PER_HR + endMinute;				// End Time given in minutes (relative to 0000)
		
		// Calculating the time elapsed (in minutes) between start and end of activity 
		if(endTime < startTime) {
			 // if the activity lasts overnight, then time until midnight + time on day2 
	         totalMinsElapsed = (24 * MINS_PER_HR - startTime) + (endTime);
	      } else {
	    	 // else, the activity is in one day, so simply take difference 
	         totalMinsElapsed = endTime-startTime;
	    }

		// Converting total minutes elapsed into Hour and Minute format 
		hoursElapsed = totalMinsElapsed / MINS_PER_HR;
		minutesElapsed = totalMinsElapsed % MINS_PER_HR;
		
		// Displaying desired output 
		System.out.println('\n' + "Your activity started " + startTOD + " and ended " + endTOD + " and took " 
							+ hoursElapsed+ " hrs and " + minutesElapsed + " minutes" + '\n'  + '\n');	
		System.out.println("All done!");
		
		keyIn.close(); // Closing scanner 
    }
}
