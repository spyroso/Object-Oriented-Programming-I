// -----------------------------------------------------
// Assignment #1 - 
// File name: Military Time.java
// Written by: Nancy Acemian
// Edited by:
// Comp 248 - Summer 2019
// -----------------------------------------------------
import java.util.Scanner;
public class MilitaryTime {
public static void main(String[] args) {
Scanner keyIn = new Scanner(System.in);
final int const1 = 60;
final int const2 = 100;
int num1, num2, num3;
int num4, num5, num6, num7, num8, num9;
System.out.print("Enter num1 and num2: ");
num1 = keyIn.nextInt();
num2 = keyIn.nextInt();
num4 = num1/const2;
num5 = num2/const2;
num6 = num1%const2;
num7 = num2%const2;
num1 = num4*const1+num6;
num2 = num5*const1+num7;
num3 = num2-num1;
num8 = num3/const1;
num9 = num3%const1;
System.out.println( "Results "+ num8+ '\t' + num9);		
keyIn.close();
}
}