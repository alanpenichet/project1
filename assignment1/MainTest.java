package assignment1;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MainTest {
	int[] x = {1,2,3,4,5,6,7,8};
	@Test
	void test() {
		test_is_sorted();
		test_find();
	}
	
	void test_is_sorted() {
		boolean yeet = SortTools.isSorted(x, x.length);
		assert(yeet);
		}
	void test_find() {
		int req = 9;
		int yeet = SortTools.find(x, x.length, req);
		assert(yeet == req);
	}
}

