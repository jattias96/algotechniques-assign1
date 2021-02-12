public class Driver extends Algorithms {
  public static void main(String[] args) {
    Algorithms test = new Algorithms();
    int[] arr = new int[]{1,2,2,3};
    int answer = test.linearSearch(arr, 2);
    System.out.println(answer);
  }
}
