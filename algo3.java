public class Algo3 {
	
	private int locateLeftEnd(int[] list, int first, int last, int x) {
		int loc;
		
		// comparisonCounter++;
		if (first > last) loc = first;
		else {
			int mid = (first + last)/2;
			// comparisonCounter++;
			if (x <= list[mid])
				loc = locateLeftEnd(list, first, mid-1, x);
			else
				loc = locateLeftEnd(list, mid+1, last, x);
		}
		
		return loc;
	}
	
	private int locateRightEnd(int[] list, int first, int last, int x) {
		int loc;
		
		// comparisonCounter++;
		if (first > last) loc = last;
		else {
			int mid = (first + last)/2;
			// comparisonCounter++;
			if (x >= list[mid])
				loc = locateRightEnd(list, mid+1, last, x);
			else
				loc = locateRightEnd(list, first, mid-1, x);
		}
		
		return loc;
	}
	
	private int findBlockSize(int[] list, int x) {
		int leftBound = locateLeftEnd();
		int rightBound = locateRightEnd();
		int blockSize = rightBound - leftBound + 1;
		return blockSize;
	}
}