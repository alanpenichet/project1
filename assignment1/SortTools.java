// SortTools.java 
/*
 * EE422C Project 1 submission by
 * Alan Penichet-Paul
 * Ap46378
 * Ap46378
 * Spring 2019
 * Slip days used: 0 
 */

package assignment1;

import java.util.Arrays;

public class SortTools {
	/**
	  * This method tests to see if the given array is sorted.
	  * @param x is the array
	  * @param n is the size of the input to be checked
	  * @return true if array is sorted
	  */
	public static boolean isSorted(int[] x, int n) {
		if(n==0 || x.length == 0) {
			return false;
		}
		for(int i = 1; i < n; i++) {
			if(x[i-1] > x[i]) {
				return false;
			}
		}
		return true;
	}

	/**
	 * This method returns the index of value v within array x.
	 * @param x is the array
	 * @param n is the size of the input to be checked
	 * @param v is the value to be searched for within x
	 * @return index of v if v is contained within x. -1 if v is not contained within x
	 */
	public static int find(int[] x, int n, int v) {
		int left  = 0;
		int right = n-1;
		while(left <= right) {
			int middle = (left+right)/2;
			if(left == right) {
				if(x[middle]!=v) {
					return -1;
				}
			}
			if(x[middle] == v) {
				return middle;
			}
			if(x[middle] > v) {
				right = middle;
			}
			if(x[middle] < v) {
				left = middle;
			}
		}
		return -1;
	
    }

	/**
	 * This method returns a newly created array containing the first n elements of x, and v.
	 * @param x is the array
	 * @param n is the number of elements to be copied from x
	 * @param v is the value to be added to the new array
	 * @return a new array containing the first n elements of x, and v
	 */
	public static int[] insertGeneral(int[] orig, int len, int val){
		int[] temp = new int[len+1];
		//flag indicates value was inserted.
		boolean flag = false;
		for(int i = 0; i < len ; i++) {
			if(!flag) {
				//if val not placed yet, continue normally
				if(orig[i] < val) {
					temp[i] = orig[i];
					//if still not found and at end, append.
					if(i == len-1) {
						temp[i+1] = val;
					}
				}
				if(orig[i] == val) {
					//if value found, return truncated array.
					return Arrays.copyOf(orig, len);
				}
				if(orig[i] > val) {
					temp [i] = val;
					flag = true;
				}
			}
			//if val found, offset by one.
			if(flag) {
				temp[i+1] = orig[i];
			}
		}
        return temp;
    }

	/**
	 * This method inserts a value into the array and ensures it's still sorted
	 * @param x is the array
	 * @param n is the number of elements in the array
	 * @param v is the value to be added
	 * @return n if v is already in x, otherwise returns n+1
	 */
	public static int insertInPlace(int[] x, int n, int v){
		return 0;
    }

	/**
	 * This method sorts a given array using insertion sort
	 * @param x is the array to be sorted
	 * @param n is the number of elements of the array to be sorted
	 */
	public static void insertSort(int[] x, int n){
    }
}
