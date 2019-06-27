package com.advjava.hw2;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Random;

/**
 * This file contain a method for getting the max element from the array
 * 
 * @author archana
 *
 */
public class MaximumElement {

	public static void main(String[] args) {
		
		
		Integer[] intlist = new Integer[10000];
		Double[] doubleList = new Double[10000];
		Random ran = new Random();
		
		System.out.println("19.5 - Maximum element in an Integer array :: " + " \n" + " Array List is :: ");
		// random integer are added to the int array and printed (inclusive)
		for (int i = 0; i < 10000; i++) {
			// int num = ran.nextInt(10001);
			int num = (int) (Math.random() * (10000 + 1));
			intlist[i] = num;
			//System.out.print(intlist[i] + " ");
		}
		System.out.print(Arrays.toString(intlist));
		System.out.println("\n" + " Max Int element is :" + max(intlist) + "\n");

		System.out.println("19.5 - Maximum element in an Double array :: " + " \n" + " Array List is :: ");
		
		// create random doubles..nextDouble can be used to generate between 0.0 to
		// 1.0(exclusive)
		for (int i = 0; i < 10000; i++) {
			Double num = ran.nextDouble();		
			//doubleList[i] = num; // for checking for 16 digit uncomment this line n comment below line
			doubleList[i] = limitPrecision(num); //precision can be removed to see 16 digit double value
			System.out.print(doubleList[i] + " ");
		}
		System.out.println("\n" + " Max double element is :" + max(doubleList));

	}

	/**
	 * Find the max element
	 *
	 */
	public static <E extends Comparable<E>> E max(E[] list) {
		// take first element as max element from the list
		E mElem = list[0];
		for (int i = 1; i < list.length; i++) {
			E element = list[i];
			// compare all the elements to the other elements in the list
			if (element.compareTo(mElem) > 0) {
				// if you find any other element greater than that change the max element
				mElem = element;
			}
		}

		return mElem;
	}
	
	/**
	 * Limiting the double precision to 5 digits
	 * @param dblAs
	 * @param maxDigitsAfterDecimal
	 * @return
	 */
	public static double limitPrecision(Double dblAs) {
		Double d = Math.PI;
        d = Double.parseDouble(String.format("%.5f", dblAs));  // can be required precision
        //System.out.println(d);
        return d;
	}

}
