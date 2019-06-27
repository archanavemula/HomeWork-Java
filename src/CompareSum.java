

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.stream.DoubleStream;

/**
 * 
 * @author archana
 * This class compares the parallel sum and sequential sum
 * It performs parallel sum by having a recursive task
 *
 */

public class CompareSum {

	public static void main(String[] args) {
		
		double[] dbl = new double[9000000];
		for (int i = 0; i < dbl.length; i++) {
			dbl[i] = Math.random();
		}
		
		long startTime = System.currentTimeMillis();
		System.out.print(parallelSum(dbl));
		long endTime = System.currentTimeMillis();
		System.out.println("\nParallel time taken for sum is " + (endTime - startTime) + " milliseconds");

		startTime = System.currentTimeMillis();  
		System.out.print(sequentialSum(dbl));
		endTime = System.currentTimeMillis();
		System.out.print("\nSequential time taken for sum is " + (endTime - startTime) + " milliseconds");

	}
	
	/**
	 * This methods sums sequentially in java 1.8
	 * We can also have for loop adding up each element.
	 * @param dbl
	 * @return
	 */
	private static double sequentialSum(double[] dbl) {
		// TODO Auto-generated method stub (1.7)
		//jdk 1.8 for seq sum
		return (DoubleStream.of(dbl).sum());
	}

	/**
	 * this methods does parallel processing , divides array and parallely sums up total
	 * @param list
	 * @return
	 */
	public	static	double	parallelSum(double[]	list) {
		// TODO Auto-generated method stub
		RecursiveTask<Double> task = new SumTask(list, 0, list.length);
		ForkJoinPool pool = new ForkJoinPool();
		return pool.invoke(task);
	}
	
	private static class SumTask extends RecursiveTask<Double> {
		private static final long serialVersionUID = 1L;
		private final static int THRESHOLD = 1000;
		private double[] list;
		private int min;
		private int max;

		public SumTask(double[] list, int min, int max) {
			this.list = list;
			this.min = min;
			this.max = max;
		}
		
		@Override
		protected Double compute() {
			if (max - min < THRESHOLD) {
				double sum = 0;
				for (int i = min; i < max; i++) {
					sum += list[i];
				}
				return sum;
			} else {
				int mid = (min + max) / 2;
				RecursiveTask<Double> left = new SumTask(list, min, mid);
				RecursiveTask<Double> right = new SumTask(list, mid, max);
				
				invokeAll(left,right);
				
				//right.fork();
				//left.fork();
				return left.join() + right.join();
			}
		}

	}
	
}
