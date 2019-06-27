package com.advjava.hw2;
import java.util.ArrayList;

/**
 * This file contain a generic method for removing duplicates from the list.
 * 
 * @author archana
 *
 */
public class RemoveDuplicates {

	public static void main(String[] args) {

		ArrayList<Integer> intlist = new ArrayList<>();
		// Random ran = new Random();

		System.out.println("Exercise 19.3 - Distinct elements in Integer ArrayList testing:" + "\n" + "List contains :: ");
		// random integer are added to the list and printed
		for (int i = 0; i < 100; i++) {
			// int num = ran.nextInt(10);
			int num = (int) (Math.random() * (9 + 1));
			intlist.add(num);
			System.out.print(num + " ");
		}
		// with generics we are passing integer list as input here
		ArrayList<Integer> newIntlist = removeDuplicates(intlist);

		// List after removing duplicates
		System.out.println("\n" + "Distinct Elements are :: " + newIntlist);

		System.out.println("\n");
		System.out.println("Exercise 19.3 - Distinct elements in character ArrayList testing:"+ "\n" + "List contains :: ");
		// random char of small letter are added and printed
		ArrayList<Character> charList = new ArrayList<Character>();
		for (int i = 0; i < 100; i++) {
			// char ranChar = (char) (ran.nextInt(26) + 'a');
			char ranChar = (char) ('a' + Math.random() * ('z' - 'a' + 1));
			charList.add(ranChar);
			System.out.print(ranChar + " ");
		}
		// with generics we are passing char list as input here
		ArrayList<Character> newCharList = removeDuplicates(charList);

		// List after removing duplicates
		System.out.println("\n" + "Distinct Elements are :: "+ newCharList);
	}

	// Method for removing duplicate values.
	public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
		ArrayList<E> newList = new ArrayList<>();
		for (int i = 0; i < list.size(); ++i) {
			if (!newList.contains(list.get(i))) {
				newList.add(list.get(i));
			}
		}
		return newList;
	}
}
