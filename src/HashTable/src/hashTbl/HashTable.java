package hashTbl;

import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class HashTable {

  static int collisions = 0;
  
  static int getHash(String word){
    char first = word.charAt(0);
    if (first < 'A') {
      return 0;
    }
    if (first < 'a') {
      return first - 'A' + 1;
    }
    return first - 'a' + 27;
  }

  private static int findSpot(String[] arr, int offset) {
    if (arr[offset] == null) {
      System.out.println("Spot found at " + offset);
      return offset;
    } else {
      return findSpot(arr, offset, 0);
    }
  }
  
  private static int findSpot(String[] arr, int offset, int n) {
    if (arr[(offset + n * n) % arr.length] == null) {
      System.out.println("Spot found at " + ((offset + n * n) % arr.length));
      return (offset + n * n) % arr.length;
    } else {
      collisions++;
      System.out.println("Collision " + collisions + " found.");
      System.out.println("At index " + ((offset + n * n) % arr.length));
      return findSpot(arr, offset, ++n);
    }
  }
  
  static String[] readWordsInFile(String[] arr) {
    int i = 0;
    try {
      File myObj = new File("words2.txt");
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
//        System.out.println("hash: " + getHash(data));
        System.out.println("data: " + data);
//        arr[i] = data;
        int offset = getHash(data) % arr.length;
        System.out.println("offset: " + offset);
        int spot = findSpot(arr, offset);
//        System.out.println("spot: " + spot);
        
        arr[spot] = data;
        i++;
        if (i > (arr.length / 2)) {
          arr = new String[arr.length * 2];
          System.out.println("arr length " + arr.length);
          System.out.println("NEW ARRAY:");
//          for (int k = 0; k < arr.length; k++) {
//            System.out.println(k + ": " + arr[k]);
//          }
          readWordsInFile(arr);
          break;
        }
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("Error: file not found.");
      e.printStackTrace();
    }
    return arr;
  }

  public static void main(String[] args) {
    String[] arr = new String[31];
    arr = readWordsInFile(arr);
    for (int i = 0; i < arr.length; i++) {
      System.out.println(i + ": " + arr[i]);
    }
    System.out.println("Number of collisions: " + collisions);
  }
}