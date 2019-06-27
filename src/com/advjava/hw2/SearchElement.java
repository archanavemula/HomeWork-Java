package com.advjava.hw2;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * 
 * @author archana
 * 
 *         Use binary search for searching the key element.
 *
 */
public class SearchElement {

	public static void main(String[] args) {

		Integer[] intlist = new Integer[100];
		Random ran = new Random();
		
		System.out.println(" 19.7	 Search the key using generic binary search for Integer ,String and Employee Object.");
		// Create an array of a hundred random integers in the range of 0 to 99,
		// inclusive.
		for (int i = 0; i < 100; i++) {
			int num = ran.nextInt(100);
			intlist[i] = num;
		}
		// Sort and print the array
		Arrays.sort(intlist);
		System.out.println(Arrays.toString(intlist));

		// User enters the key for searching in our random list.
		System.out.print(" Enter the Key : ");
		Scanner in = new Scanner(System.in);
		
		//validate the input from user
		while (!in.hasNextInt()) {
	        System.out.println("Not a valid number!");
	        in.next(); 
	    }
				
		int key = in.nextInt();
		int output = binarySearch(intlist, key);
		System.out.println("Location in the array is : " + output + "\n");

		// Create an array of random strings, 1 to 10 characters in length.
		String[] strlist = new String[100];
		for (int i = 0; i < 100; i++) {
			String randomString = generateRandomString(10);
			strlist[i] = randomString;
		}

		// Sort and print the array
		Arrays.sort(strlist);
		System.out.println(Arrays.toString(strlist));

		// User enters the key for searching in our random list.
		System.out.print(" Enter the String Key : ");
				
		String strKey = in.next();
		output = binarySearch(strlist, strKey);
		System.out.println("Location in the array is : " + output + "\n");

		// Create an array of random Employee objects (use random strings for the first
		// name and
		// last name and random numbers for the salary).
		// creating 10 objects as it is not specified.
		Employee[] emplist = new Employee[100];
		for (int i = 0; i < 100; i++) {
			Employee emp = new Employee();
			emp.setFirstName(generateRandomString(5));
			emp.setLastName(generateRandomString(5));
			emp.setSalary(ran.nextInt(100));
			emplist[i] = emp;
		}

		Arrays.sort(emplist, Employee.NameComparator);
		for (int i = 0;i < emplist.length ; i++) {
			System.out.println(emplist[i] + "    ");
		}
		System.out.print("\n"+ "Enter the Employee Key : ");

		String firstKey = in.next();
		String secondKey = in.next();
		Employee emp = new Employee();
		emp.setFirstName(firstKey);
		emp.setLastName(secondKey);
		output = binarySearch(emplist, emp);
		System.out.println("Location in the array is : " + output );
		in.close();

	} //

	public static String generateRandomString(int len) {
		int RANDOM_STRING_LENGTH = len;
		StringBuffer randStr = new StringBuffer();
		for (int i = 0; i < RANDOM_STRING_LENGTH; i++) {
			char ranChar = (char) ('a' + Math.random() * ('z' - 'a' + 1));
			randStr.append(ranChar);
		}
		return randStr.toString();
	}

	public static <E extends Comparable<E>> int binarySearch(E[] list, E key) {

		int low = 0;
		int notFound = -1;
		int high = list.length - 1;

		while (high >= low) {
			int mid = (low + high) / 2;
			if (key.compareTo(list[mid]) < 0)
				high = mid - 1;
			else if (key.compareTo(list[mid]) == 0)
				return mid;
			else
				low = mid + 1;

		}

		return notFound; // Now high < low, key not found

	}

	public static <E extends Comparable<E>> int binarySearch1(E[] list, E key) {

		int min, max, notFound;
		min = 0;
		max = list.length - 1;
		notFound = -1;

		while (max >= min) {

			int mid = (max - min) / 2 + min;
			if (key.compareTo(list[mid]) == 0)
				return mid;

			if (key.compareTo(list[mid]) > 0)
				min = mid + 1;

			if (key.compareTo(list[mid]) < 0)
				max = mid - 1;
		}

		return notFound;

	}

}
