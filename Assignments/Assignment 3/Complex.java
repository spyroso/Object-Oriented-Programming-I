// ------------------------------------------------------- 
// Assignment 3 - Question 2a
// Written by: Spyros Orfanos - 40032280
// For COMP 248 Section EC – Summer 2019
// --------------------------------------------------------



public class Complex {
	
	// Declaring instance variables 
	private double real;
	private double imag;
	
	// Default constructor
	public Complex() {
		real = 0.0;
		imag = 0.0;
	}
	
	// Two-argument constructor 
	public Complex(double a, double b) {
		real = a;
		imag = b;
	}
	
	// Copy constructor
	Complex(Complex number2){
		real = number2.real;
		imag = number2.imag;
	}
	
	// Accessor method for real part
	public double getReal() {
		return real;
	}
	
	// Accessor method for imaginary part
	public double getImag() {
		return imag;
	}
		
	// Mutator method for real part
	public void setReal(double a) {
		real = a;
	}
	
	// Mutator method for imaginary part
	public void setImag(double b) {
		imag = b;
	}
	
	// Addition method 
	public Complex addition(Complex number2) {
		// Calculating real and complex part for the sum of two complex numbers
		double addReal = real + number2.getReal();
		double addImag = imag + number2.getImag();
		// Returning the sum, which is also a complex number 
		return new Complex(addReal, addImag);
	}
		
	// Multiplication method 
	public static Complex multiply(Complex number1, Complex number2) {	
		// Calculating real and complex part for the product of two complex numbers
		double prodReal = number1.getReal() * number2.getReal() - number1.getImag() * number2.getImag();
		double prodImag = number1.getReal() * number2.getImag() + number1.getImag()* number2.getReal();
		// Returning the product, which is also a complex number 
		return new Complex(prodReal, prodImag);
		
	}
	
	// toString method 
	public String toString() {
		// Keeping exactly two decimals for real and imaginary parts 
		String realPart = String.format("%.02f", real);
		String imagPart = String.format("%.02f", imag);
		// returning a string of the form "a + b*i" 
		return (realPart + " + " + imagPart + "*i");
	}
	
	// equals method 
	public boolean equals(Complex number2) {
		// Checks if real part and imaginary part is equal 
		return (real == number2.real && imag == number2.imag);
	}
	
}
