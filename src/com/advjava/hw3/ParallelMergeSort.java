package com.advjava.hw3;

import java.util.concurrent.RecursiveAction;
import java.util.concurrent.ForkJoinPool;

/**
 * 
 * @author archana
 * 
 * This class does the parallel merge sort.Usually mergesort divides the array and sorts
 * the subarrays sequentially.In parallel mergesort, it sorts the array parallely which
 * reduces the time. This class can sort any kind of object like integer,string or any generic 
 * object also.
 *
 */
public class ParallelMergeSort {
	
  public static void main(String[] args) {
    //final int SIZE = 7000000;
    final int SIZE = 10;
    Integer[] list1 = new Integer[SIZE];
    String[] list2 = new String[SIZE];

    for (int i = 0; i < list1.length; i++)
      list1[i] = (int)(Math.random() * 10000000);

    parallelMergeSort(list1); // Invoke parallel merge sort
    
    for (int i = 0; i < list2.length; i++)
      list2[i] = generateRandomString(5);

    parallelMergeSort(list2); // Invoke parallel merge sort
    
    for (int i = 0; i < list1.length; i++) {
    	System.out.print(list1[i] + " ");
    }
    
    System.out.println();
    
    for (int i = 0; i < list2.length; i++) {
    	System.out.print(list2[i] + " ");
    }     
  }
  
/**
 * 
 * @param list
 */
  public static <E	extends	Comparable<E>> void parallelMergeSort(E[] list) {
	    RecursiveAction mainTask = new SortTask(list);
	    ForkJoinPool pool = new ForkJoinPool();
	    pool.invoke(mainTask);
	  }
  
  /**
   * 
   * @param len
   * @return
   */
  public static String generateRandomString(int len) {
		int RANDOM_STRING_LENGTH = len;
		StringBuffer randStr = new StringBuffer();
		for (int i = 0; i < RANDOM_STRING_LENGTH; i++) {
			char ranChar = (char) ('a' + Math.random() * ('z' - 'a' + 1));
			randStr.append(ranChar);
		}
		return randStr.toString();
	}

  /** Merge two sorted lists */
  public static <E extends Comparable<E>> void merge(E[] list1, E[] list2, E[] temp) {
    int current1 = 0; // Current index in list1
    int current2 = 0; // Current index in list2
    int current3 = 0; // Current index in temp

    while (current1 < list1.length && current2 < list2.length) {
      if (list1[current1].compareTo(list2[current2]) < 0)
        temp[current3++] = list1[current1++];
      else
        temp[current3++] = list2[current2++];
    }

    while (current1 < list1.length)
      temp[current3++] = list1[current1++];

    while (current2 < list2.length)
      temp[current3++] = list2[current2++];
  }
  
  /**
   * 
   * @author archana
   *
   * @param <E>
   */
  private static class SortTask<E extends Comparable<E>> extends RecursiveAction {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final int THRESHOLD = 500;
    private E[] list;

    SortTask(E[] list) {
      this.list = list;
    }

    @Override
    protected void compute() {
      if (list.length < THRESHOLD)
        java.util.Arrays.sort(list);
      else {
    	  
       // Obtain the first half
    	E[] firstHalf = (E[])(new Comparable[list.length / 2]);
    	System.arraycopy(list, 0, firstHalf, 0, list.length / 2);

    	 // Obtain the second half
        int secondHalfLength = list.length - list.length / 2;
        E[] secondHalf = (E[])(new Comparable[secondHalfLength]);
        System.arraycopy(list, list.length / 2, secondHalf, 0, secondHalfLength);

      
        // Recursively sort the two halves
        invokeAll(new SortTask<E>(firstHalf), 
          new SortTask<E>(secondHalf));

        // Merge firstHalf with secondHalf into list
        merge(firstHalf, secondHalf, list);
      }
    }
  }
}