// ------------------------------------------------------- 
// Assignment 3 - Question 2b
// Written by: Spyros Orfanos - 40032280
// For COMP 248 Section EC – Summer 2019
// --------------------------------------------------------



import java.util.Scanner;

public class DriverQ2 {
	public static void main(String[] args) {
		
		// Declaring variables 
		Scanner keyIn = new Scanner(System.in);
		double real2, imag2;
		double addNb; 		
		Complex nb1 = new Complex();  // Creating first complex number 
			
		// Welcome banner 
		System.out.println("--------------------------------------");
		System.out.println("   Let's play with complex numbers!   ");
		System.out.println("--------------------------------------");
		
		// Displaying the first complex number
		System.out.println("Complex number created with default constructor is: " + nb1);
		
		// User prompt for real part of second complex number 
		System.out.print('\n' + "Enter the real part of the 2nd complex number: ");
		real2 = keyIn.nextDouble();
		
		// User prompt for imaginary part of second complex number 
		System.out.print("Enter the imaginary part of the 2nd complex number: ");
		imag2 = keyIn.nextDouble();

		// Creating second complex number, then displaying it 
		Complex nb2 = new Complex(real2, imag2);
		System.out.println("Entered Complex Number is: " + nb2);
		
		
		// Display message regarding equality of the two numbers 
		System.out.println();
		if (nb1.equals(nb2))
			System.out.println("The complex numbers " + nb1 + " and " + nb2 + " are equal.");
		else 
			System.out.println("The complex numbers " + nb1 + " and " + nb2 + " are not equal.");
		System.out.println();

		// Swapping real and imaginary part of second number
		System.out.print("Swapping real and imaginary part of " + nb2 + " results in " );
		double swapReal = nb2.getImag();
		double swapImag = nb2.getReal();
		nb2.setReal(swapReal);
		nb2.setImag(swapImag);
		System.out.print(nb2);
		
		
		// Changing first complex number to second one 
		nb1 = new Complex(nb2);
		
		// Display message regarding equality of the two numbers 
		System.out.println();
		if (nb1.equals(nb2))
			System.out.println(nb1 + " is equal to " + nb2 + " is now true");
		else 
			System.out.println(nb1 + " is equal to " + nb2 + " is now false");

		
		// User prompt for number to add 
		System.out.println();
		System.out.print("Enter a number please: " );
		addNb = keyIn.nextDouble();
		
		
		// Changing first number 
		System.out.print(nb1 + " has been changed to " );
		nb1.setReal(nb1.getReal() + addNb);
		nb1.setImag(nb1.getImag() + addNb);
		System.out.print(nb1);
		

		// Display message regarding equality of the two numbers 
		System.out.println();
		if (nb1.equals(nb2))
			System.out.println("The complex numbers " + nb1 + " and " + nb2 + " are equal.");
		else 
			System.out.println("The complex numbers " + nb1 + " and " + nb2 + " are not equal.");		
		
		// Adding the two numbers 
		System.out.println();
		System.out.print("Adding " + nb1 + " to " + nb2 + " results in the complex number ");
		nb1 = nb1.addition(nb2);
		System.out.print(nb1);
		
		// Multiplying the two numbers 
		System.out.println();
		System.out.print("Multiplying " + nb1 + " by " + nb2 + " results in the complex number ");
		nb2 = Complex.multiply(nb1, nb2);
		System.out.println(nb2);

		// Displaying the final numbers 
		System.out.println();
		System.out.println("So after all this manipulation the original complex number have morphed into");
		System.out.println(nb1 + " and " + nb2);
		
		// Closing messages 
		System.out.println();
		System.out.println("You should now be comfortable with defining a class and manipulating objects, right?");
		System.out.println("On to bigger and better things...");
		System.out.println();
		System.out.println("All done!");

		// Closing the scanner 
		keyIn.close();
	}

}
