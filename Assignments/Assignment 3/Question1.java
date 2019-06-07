import java.util.Scanner;

public class Question1 {

	public static void main(String[] args) {
		
		
		// Declaring variables
		Scanner keyIn = new Scanner(System.in);   	// Create Scanner object
		int userN;									// userN: the in
		int nbRow, nbCol;
		int sumDiagTL=0, sumDiagTR=0, sumTot=0; 
		int sumTR=0, sumBR=0, sumFC=0, sumLC=0;
		
		// Welcome banner 
		System.out.println(" ---------------------------------------- ");
		System.out.println("  Let's Practise manipulating a 2D Array  ");
		System.out.println(" ---------------------------------------- " + '\n');
		
		// User prompt (keep prompting user until an integer >= 3 is entered) 
		do {
			System.out.print("What size square do you want? (must be >= 3) ");
			userN = keyIn.nextInt();
		}
		while (userN < 3);
	
		// 
		System.out.println('\n' + "The array looks like the following:");

		// Main algorithm 
		int[][] theArray = new int[userN][userN];
		
		
		for (nbRow = 0; nbRow < userN; nbRow++) {
			for (nbCol = 0; nbCol < userN; nbCol++) {
				if (nbRow == nbCol)
					theArray[nbRow][nbCol] = 0;
				else if ((nbRow + nbCol) % 2 == 0)
					theArray[nbRow][nbCol] = (nbRow + nbCol);
				else
					theArray[nbRow][nbCol] = (2*nbRow - nbCol);
				// Printing the contents of theArray for row nbRow
				System.out.print(theArray[nbRow][nbCol] + "\t");
				sumTot += theArray[nbRow][nbCol];
			}
			System.out.println();
		}

		

		System.out.println('\n' + "Sum of all the elements of the " + userN + "x" + userN+ " array is " + sumTot + '\n');

		// Printing diagonal TL and calculating sum 
		System.out.println("Diagonal from top left to bottom right contains:");
		for (nbCol = 0; nbCol < userN; nbCol++) {
			System.out.print(0 + "\t");
		}
		System.out.print("Sum is " + 0 + '\n');
			
		// Printing diagonal TR and calculating sum 
		System.out.println('\n' + "Diagonal from top right to bottom left contains:");
		for (nbCol = 0; nbCol < userN; nbCol++) {
			System.out.print(theArray[nbCol][(userN - 1 - nbCol)]+ "\t");
			sumDiagTR += theArray[nbCol][(userN - 1 - nbCol)];
		}
		System.out.print("Sum is " + sumDiagTR + '\n');
		
		
		// Top row 
		System.out.println('\n' + "Top row contains:");
		for (nbCol = 0; nbCol < userN; nbCol++) {
			System.out.print(theArray[0][nbCol]+ "\t");
			sumTR += theArray[0][nbCol];
		}
		System.out.print("Sum is " + sumTR + '\n');
		
		 
		// bottom row 
		System.out.println('\n' + "Bottom row contains:");
		for (nbCol = 0; nbCol < userN; nbCol++) {
			System.out.print(theArray[userN-1][nbCol]+ "\t");
			sumBR += theArray[userN-1][nbCol];
		}
		System.out.print("Sum is " + sumBR + '\n');
		
	
		// first column 
		System.out.println('\n' + "First column contains:");
		for (nbRow = 0; nbRow < userN; nbRow++) {
			System.out.print(theArray[nbRow][0]+ "\t");
			sumFC += theArray[nbRow][0];
		}
		System.out.print("Sum is " + sumFC + '\n');
		
		
		// last column 
		System.out.println('\n' + "Last column contains:");
		for (nbRow = 0; nbRow < userN; nbRow++) {
			System.out.print(theArray[nbRow][userN-1]+ "\t");
			sumLC += theArray[nbRow][userN-1];
		}
		System.out.print("Sum is " + sumLC + '\n');
		
		// Display closing message 
		System.out.println('\n' + "That was a good exercise in manipulating a 2D-Array!"); 
		System.out.println('\n' + "All done!");

		// Closing scanner 
		keyIn.close(); 
	}
}

