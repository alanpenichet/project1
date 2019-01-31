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
	public static boolean isSorted(int[] x, int n)
	{
		if(n==0 || x.length == 0)
		{
			//special cases
			return false;
		}
		for(int i = 1; i < n; i++)
		{
			//return false if not sorted at any point
			//covers zero case by skipping completely if only one element
			if(x[i-1] > x[i])
			{
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
	public static int find(int[] x, int n, int v)
	{
		//set bounds to initial values
		int left  = 0;
		int right = n-1;
		//keep looping while bounds dont swap, indicating end.
		while(left <= right)
		{
			//pivot
			int middle = (left+right)/2;
			if(left == right)
			{
				//if bounds same and not found, value not in array. return -1
				if(x[middle]!=v)
				{
					return -1;
				}
			}
			if(x[middle] == v)
			{
				//value found
				return middle;
			}
			if(x[middle] > v)
			{
				//keep left half
				right = middle;
			}
			if(x[middle] < v)
			{
				//keep right half
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
	public static int[] insertGeneral(int[] x, int n, int v)
	{
		int[] temp = new int[n+1];
		//flag indicates value was inserted.
		boolean flag = false;
		if(n == 0)
		{
			return new int[] {};
		}
		for(int i = 0; i < n ; i++)
		{
			if(!flag)
			{
				//if val not placed yet, continue normally
				if(x[i] < v)
				{
					temp[i] = x[i];
					//if still not found and at end, append.
					if(i == n-1)
					{
						temp[i+1] = v;
					}
				}
				if(x[i] == v)
				{
					//if value found, return truncated array.
					return Arrays.copyOf(x, n);
				}
				if(x[i] > v)
				{
					temp [i] = v;
					flag = true;
				}
			}
			//if val found, offset by one.
			if(flag)
			{
				temp[i+1] = x[i];
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
	public static int insertInPlace(int[] x, int n, int v)
	{
		boolean missing = false;
		int[] temp = Arrays.copyOf(x, n+1);
		//first position case
		if(temp[0] > v)
		{
			x[0] = v;
			missing = true;
		}
		for(int i = 0; i < n; i++)
		{
				if(!missing)
				{
					//if value found, just return n and don't modify x
					if(temp[i] == v)
					{
						return n;
					}
					// keep same as long as value isnt missing, avoid out of bounds
					if(i>0) 
					{
						if(temp[i] > v && temp[i-1] < v)
						{
							//if value missing, set flag to true and temp i to value
							x[i] = v;
							missing = true;
						}
					}
					
				}
			
				if(missing)
				{
					//once missing, increment by one
					x[i+1] = temp[i];
				}
		}
		if(!missing)
		{
			//if still not missing by end, just append.
			x[n] = v;
		}
		return n+1;
    }

	/**
	 * This method sorts a given array using insertion sort
	 * @param x is the array to be sorted
	 * @param n is the number of elements of the array to be sorted
	 */
	public static void insertSort(int[] x, int n)
	{
		//flag for O(n) cases
		boolean sorted = true;
		for(int i =0; i < n; i++)
		{
			//reset to sorted to see if any are wrong
			sorted = true;
			//assumed top i values are sorted correctly
			for(int j = 0; j < n-i-1; j++)
			{
				if(x[j] > x[j+1])
				{
					//indicate array was wrong, try next loop
					sorted = false;
					//sort 2 at a time
					int temp = x[j];
					x[j] = x[j+1];
					x[j+1] = temp;
				}
			}
			//if sorted, skip remaining loops
			if(sorted) return;
		}
    }
}
