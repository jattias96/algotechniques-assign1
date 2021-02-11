/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Joseph Bermudez
 * @author Jonathan Attias Khoudari
 */
public class Prog14_01
{

    public static int found = 0;

    public static void main(String[] args)
    {
        new Prog14_01();
    }

    /**
     * @param args the command line arguments
     */
    public Prog14_01()
    {
        Random rnd = new Random();

        int[] list = new int[10];
        fillArray(list);
        //printArray(list);
        Arrays.sort(list);
        printArray(list);
        int x = rnd.nextInt(10);
        
        System.out.println("Linear Search to find " + x + ": " + linearSearch(list, x));
        found = 0;
        int foundInd = binarySearch(list, x);
        System.out.println("Binary Search to find " + x + ": " + searchBinary(list, x, foundInd));
        found = 0;
        //System.out.println("Binary Search #2 to find " + x + ": ");
    }

    public void fillArray(int[] list)
    {
        Random rnd = new Random();
        for (int i = 0; i < list.length; i++)
        {
            list[i] = rnd.nextInt(10);
        }
    }

    public void printArray(int[] list)
    {
        for (int i = 0; i < list.length; i++)
        {
            System.out.println(list[i] + " ");
        }
    }

    public static int linearSearch(int array[], int searchFor)
    {
        for (int i = 0; i < array.length; i++)
        {
            if (array[i] == searchFor)
            {
                found++;
            }
        }
        return found;
    }

    public static int binarySearch(int[] list, int x)
    {
        return binarySearch(list, 0, list.length-1, x);
    }
    
    public static int binarySearch(int list[], int first, int last, int x)
    {
         int found_index;
        
        if(first > last)
        {
            return 0;
        }
        else
        {
            int mid = (first + last) / 2;
            if(list[mid] == x)
            {
                found_index = mid;
                return found_index;
            }
            else
            {
                if(x < list[mid])
                {
                    found_index = binarySearch(list, first, mid-1, x);
                }
                else
                {
                    found_index = binarySearch(list, mid + 1, last, x);
                }
            }
        }
        return found_index;
    }
    
    public static int searchBinary(int[] list, int searchFor, int foundInd)
    {
        int count = foundInd;
        while(count >= 0 && list[count] == searchFor)
        {
            found++;
            count--;
        }
        count = foundInd + 1;
        while(count < list.length && list[count] == searchFor)
        {
            found++;
            count++;
            if(count >= list.length)
            {
                break;
            }
        }
        return found;
    }
    
    private int locateLeftEnd(int[] list, int first, int last, int x)
    {
		int loc;
		
		// comparisonCounter++;
		if (first > last) loc = first;
		else
                {
			int mid = (first + last)/2;
			// comparisonCounter++;
			if (x <= list[mid])
                        {
				loc = locateLeftEnd(list, first, mid-1, x);
                        }
			else
                        {
				loc = locateLeftEnd(list, mid+1, last, x);
                        }
		}
		
		return loc;
	}
	
	private int locateRightEnd(int[] list, int first, int last, int x)
        {
		int loc;
		
		// comparisonCounter++;
		if (first > last) loc = last;
		else
                {
			int mid = (first + last)/2;
			// comparisonCounter++;
			if (x >= list[mid])
                        {
				loc = locateRightEnd(list, mid+1, last, x);
                        }
			else
                        {
				loc = locateRightEnd(list, first, mid-1, x);
                        }
		}
		
		return loc;
	}
	
	/*private int findBlockSize(int[] list, int x)
        {
		int leftBound = locateLeftEnd();
		int rightBound = locateRightEnd();
		int blockSize = rightBound - leftBound + 1;
		return blockSize;
	}*/
    
}
