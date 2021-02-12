import java.util.Arrays;
import java.util.Random;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Algorithms {

  public int comparisonCounter;

  // constructor
  public Algorithms() {
    this.comparisonCounter = 0;
    Random rnd = new Random();
    String largeBlocksFilename = "largeBlocks.csv";
    String smallBlocksFilename = "smallBlocks.csv";
    PrintWriter largeBlocksOutput = null;
    PrintWriter smallBlocksOutput = null;
    
    
    //open output stream
    try {
      largeBlocksOutput = new PrintWriter(new FileWriter(largeBlocksFilename));
      smallBlocksOutput = new PrintWriter(new FileWriter(smallBlocksFilename));

      // large blocks
      for (int i = 1; i <= 10000; i++) {
        int arraySize = i * 10;
        int amountOfNums = arraySize / 4;
        int[] largeBlocksArray = new int[arraySize];
        fillArray(largeBlocksArray, amountOfNums);
        Arrays.sort(largeBlocksArray);
        int numToFind = rnd.nextInt(amountOfNums);
        int amountOfCmpLinear = linearSearch(largeBlocksArray, numToFind);
        int amountOfCmpAlgo2 = secondAlgo(largeBlocksArray, numToFind);
        int amountOfCmpAlgo3 = thirdAlgo(largeBlocksArray, numToFind);
        largeBlocksOutput.println(arraySize + "," + amountOfCmpLinear + "," + amountOfCmpAlgo2 + "," + amountOfCmpAlgo3);
      }
      
      // small blocks
      for (int i = 1; i <= 10000; i++) {
        int arraySize = i * 10;
        int amountOfNums = arraySize * 2;
        int[] largeBlocksArray = new int[arraySize];
        fillArray(largeBlocksArray, amountOfNums);
        Arrays.sort(largeBlocksArray);
        int numToFind = rnd.nextInt(amountOfNums);
        int amountOfCmpLinear = linearSearch(largeBlocksArray, numToFind);
        int amountOfCmpAlgo2 = secondAlgo(largeBlocksArray, numToFind);
        int amountOfCmpAlgo3 = thirdAlgo(largeBlocksArray, numToFind);
        smallBlocksOutput.println(arraySize + "," + amountOfCmpLinear + "," + amountOfCmpAlgo2 + "," + amountOfCmpAlgo3);
      }
    } catch (IOException ex) {
      System.exit(1);
    }
    
    //close output stream
    largeBlocksOutput.close();
    smallBlocksOutput.close();
  }

  public static void main(String[] args) {
    new Algorithms();
  }

  public void fillArray(int[] list, int amountOfNums) {
    Random rnd = new Random();
    for (int i = 0; i < list.length; i++) {
        list[i] = rnd.nextInt(amountOfNums);
    }
  }

  public void printArray(int[] list) {
    for (int i = 0; i < list.length; i++) {
        System.out.println(list[i] + " ");
    }
  }

  public int linearSearch(int[] array, int searchFor) {
    int timesFound = 0;
    comparisonCounter = 0;
    for (int i = 0; i < array.length; i++) {
        comparisonCounter++;
        if (array[i] == searchFor) {
            timesFound++;
        }
        comparisonCounter++;
    }
    return comparisonCounter;
  }

  public int binarySearch(int[] list, int x) {
    return binarySearch(list, 0, list.length-1, x);
  }
  
  public int binarySearch(int[] list, int first, int last, int x) {
    int foundIndex;
    
    comparisonCounter++;
    if(first > last) {
      return 0;
    }
    else {
      int mid = (first + last) / 2;
      comparisonCounter++;
      if(list[mid] == x) {
        foundIndex = mid;
        return foundIndex;
      }
      else {
        comparisonCounter++;
        if(x < list[mid]) {
          foundIndex = binarySearch(list, first, mid-1, x);
        }
        else {
          foundIndex = binarySearch(list, mid + 1, last, x);
        }
      }
    }
    return foundIndex;
  }
    
  public int leftAndRightFinder(int[] list, int searchFor, int foundIndex) {
    int count = foundIndex;
    int found = 0;
    
    comparisonCounter++;
    if (list.length == 0) {
      return found;
    } else {
      comparisonCounter += 2;
      while(count >= 0 && list[count] == searchFor) {
        found++;
        count--;
      }
      count = foundIndex + 1;
      comparisonCounter += 2;
      while(count < list.length && list[count] == searchFor) {
        found++;
        count++;
        comparisonCounter++;
        if(count >= list.length) {
          break;
        }
      }
    }
    return comparisonCounter;
  }

  public int secondAlgo(int[] list, int searchFor) {
    comparisonCounter = 0;
    int foundIndex = binarySearch(list, searchFor);
    return leftAndRightFinder(list, searchFor, foundIndex);
  }

  public int locateLeftEnd(int[] list, int first, int last, int searchFor) {
    int loc;
    
    comparisonCounter++;
    if (first > last) loc = first;
    else {
      int mid = (first + last)/2;
      comparisonCounter++;
      if (searchFor <= list[mid])
        loc = locateLeftEnd(list, first, mid-1, searchFor);
      else
        loc = locateLeftEnd(list, mid+1, last, searchFor);
    }
    
    return loc;
  }
  
  public int locateRightEnd(int[] list, int first, int last, int searchFor) {
    int loc;
      
    comparisonCounter++;
    if (first > last) loc = last;
    else {
      int mid = (first + last)/2;
      comparisonCounter++;
      if (searchFor >= list[mid])
        loc = locateRightEnd(list, mid+1, last, searchFor);
      else
        loc = locateRightEnd(list, first, mid-1, searchFor);
    }
    
    return loc;
  }
  
  public int thirdAlgo(int[] list, int searchFor) {
    comparisonCounter = 0;
    int leftBound = locateLeftEnd(list, 0, list.length-1, searchFor);
    int rightBound = locateRightEnd(list, 0, list.length-1, searchFor);
    int blockSize = rightBound - leftBound + 1;
    return comparisonCounter;
  }
}
