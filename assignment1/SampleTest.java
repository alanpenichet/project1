package assignment1;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Random;

import org.junit.Test;


public class SampleTest {
	
	@Test(timeout = 2000)
	public void IsSortedZero(){
		int[] x = new int[]{-2, -1, 0, 1, 2, 3};
		assertEquals(false, SortTools.isSorted(x, 0));
	}
	@Test(timeout = 2000)
	public void IsSortedOne(){
		int[] x = new int[]{-2};
		assertEquals(true, SortTools.isSorted(x, 1));
	}
	
	@Test(timeout = 2000)
	public void testFindFoundFull(){
		int[] x = new int[]{-2, -1, 0, 1, 2, 3};
		assertEquals(3, SortTools.find(x, 6, 1));
	}
	@Test(timeout = 2000)
	public void testzerofind() {
		int[] zero = new int[] {0};
		assertEquals(0, SortTools.find(zero, 1, 0));
		assertEquals(-1, SortTools.find(zero, 1, 1));
	}
	
	@Test(timeout = 2000)
	public void testInsertGeneralPartialEnd(){
		int[] x = new int[]{10, 20, 30, 40, 50};
		int[] expected = new int[]{10, 20, 30, 35};
		assertArrayEquals(expected, SortTools.insertGeneral(x, 3, 35));
	}
	
	@Test(timeout = 2000)
	public void testInsertGeneralMiddle(){
		int[] x = new int[]{10, 20, 30, 40, 50};
		int[] expected = new int[]{10, 20, 30, 35, 40};
		assertArrayEquals(expected, SortTools.insertGeneral(x, 4, 35));
	}
	@Test(timeout = 2000)
	public void testInsertGeneralRedundant(){
		int[] x = new int[]{10, 20, 30, 35, 40, 50};
		int[] expected = new int[]{10, 20, 30, 35, 40};
		assertArrayEquals(expected, SortTools.insertGeneral(x, 5, 35));
	}
	@Test(timeout = 2000)
	public void testInsertGeneralfirst(){
		int[] x = new int[]{10, 20, 30, 35, 40, 50};
		int[] expected = new int[]{0,10, 20, 30, 35};
		assertArrayEquals(expected, SortTools.insertGeneral(x, 4, 0));
	}
	@Test(timeout = 2000)
	public void testInsertGeneralzero(){
		int[] x = new int[]{1, 2, 23 ,54 ,68};
		int[] expected = new int[]{};
		assertArrayEquals(expected, SortTools.insertGeneral(x, 0, 20));
	}
	@Test(timeout = 2000)
	public void testInsertPlaceMiddle(){
		//fails with out of bound if cant reach n+1
		int[] x = new int[]{1, 2, 23 ,54 ,68, 71};
		int[] expected = new int[]{1, 2, 3, 23, 54, 68};
		assertEquals(6, SortTools.insertInPlace(x, 5, 3));
		assertArrayEquals(expected, x);
	}
	@Test(timeout = 2000)
	public void testInsertPlaceFound(){
		int[] x = new int[]{1, 2, 3 ,23 ,54};
		int[] expected = new int[]{1, 2, 3, 23, 54};
		assertEquals(4, SortTools.insertInPlace(x, 4, 3));
		assertArrayEquals(expected, x);
	}
	@Test(timeout = 2000)
	public void testInsertPlacesmall(){
		int[] x = new int[]{1, 10};
		int[] expected = new int[]{1, 2};
		assertEquals(2, SortTools.insertInPlace(x, 1, 2));
		assertArrayEquals(expected, x);
	}
	@Test(timeout = 2000)
	public void testInsertPlaceLast(){
		int[] x = new int[]{1,2,3,4,5, 10};
		int[] expected = new int[]{1, 2,3,4,5,6};
		assertEquals(6, SortTools.insertInPlace(x, 5, 6));
		assertArrayEquals(expected, x);
	}
	@Test(timeout = 2000)
	public void testInsertSortGeneral(){
		int[] x = new int[]{7, 5, 1, 8, 3, 2, 6};
		int[] expected = new int[]{1, 2, 3, 5, 6, 7, 8};
		SortTools.insertSort(x, 7);
		assertArrayEquals(expected, x);
	}
	@Test(timeout = 2000)
	public void testInsertSortRandom() {
		//creates random numbers
		Random random= new Random();
		int length = random.nextInt(1000);
        int numbers[]= new int[length];
        for (int i = 0; i < length; i++) 
        {
        int number= random.nextInt(100);
        numbers[i]=number;
        }
        int copy[] = Arrays.copyOf(numbers, length);
        Arrays.sort(copy);
        SortTools.insertSort(numbers, length);
        assertArrayEquals(copy, numbers);
	}
	@Test(timeout = 100)
	public void testInsertSortSimple(){
		int length = 200000;
		int[] x = new int[length];
		for(int i=0; i < length; i++) {
			x[i] = i;
		}
		int[] expected = Arrays.copyOf(x, length);
		int temp = x[(length/2)];
		x[(length/2)] = x[(length/2)+1];
		x[(length/2)+1] = temp;
		SortTools.insertSort(x, length);
		assertArrayEquals(expected, x);
		assertEquals(true, SortTools.isSorted(x, length));
	}
	@Test(timeout = 2000)
	public void testInsertSortOne(){
		int[] x = new int[]{8, 4, 3, 6};
		int[] expected = new int[]{8, 4, 3, 6};
		SortTools.insertSort(x, 1);
		assertArrayEquals(expected, x);
	}
}
