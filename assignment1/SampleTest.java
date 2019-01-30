package assignment1;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class SampleTest {
	
	@Test(timeout = 2000)
	public void IsSortedZero(){
		int[] x = new int[]{-2, -1, 0, 1, 2, 3};
		assertEquals(false, SortTools.isSorted(x, 0));
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
		int[] x = new int[]{1, 2, 23 ,54 ,68};
		int[] expected = new int[]{1, 2, 3, 23, 54, 68};
		assertEquals(6, SortTools.insertInPlace(x, 5, 3));
		assertArrayEquals(x, expected);
	}
	
}
