package com.advjava.hw1;
import java.util.Scanner;


public class CalculateVolume {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		double radius;
		double length;
		double area;
		double volume;
		// Enter both separated by space ex: 5.5 12
		System.out.print("Enter the radius and length of a cylinder: ");
		Scanner in = new Scanner(System.in);
		//validate the input
		while (!in.hasNextDouble()) {
	        System.out.println("Not a valid number!");
	        in.next(); 
	    }
		// Assign a radius
		 radius = in.nextDouble();
		// Assign a length
		 length = in.nextDouble();
		
		 //check the values
		System.out.println("Input radius : " +radius + " and length is : "+ length);
		// Compute area
		area = radius * radius * 3.14159;
		//compute volume
		volume = area * length;
		// Display results
		System.out.println("The area is " + area);
		System.out.println("The volume is " + volume);
		
		in.close();
	}

}
