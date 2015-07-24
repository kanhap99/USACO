/*
ID: kanhapr1
LANG: JAVA
TASK: transform
*/
import java.io.*;
import java.util.*;

class transform { //classname = probname
  public static void main(String [] args) throws IOException {
    BufferedReader f = new BufferedReader(new FileReader("transform.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("transform.out")));
    int n = Integer.parseInt(f.readLine());
    char train[][]= new char[n][n];
    char test[][] = new char[n][n];
    for(int i = 0; i < n; i++) {
      String s = f.readLine();
      for(int j = 0; j < n; j++) {
        train[i][j] = s.charAt(j);
      }
    }
    for(int i = 0; i < n; i++) {
      String s = f.readLine();
      for(int j = 0; j < n; j++) {
        test[i][j] = s.charAt(j);
      }
    }

    if(Arrays.deepEquals(rotate(train,1),test))
      out.println(1);
    else if(Arrays.deepEquals(rotate(train,2),test))
      out.println(2);
    else if(Arrays.deepEquals(rotate(train,3),test))
      out.println(3);
    else if(Arrays.deepEquals(reflect(train),test))
      out.println(4);
    else if(Arrays.deepEquals(rotate(reflect(train),1),test) || Arrays.deepEquals(rotate(reflect(train),2),test) || Arrays.deepEquals(rotate(reflect(train),3),test))
      out.println(5);
    else if(Arrays.deepEquals(test,train))
      out.println(6);
    else
      out.println(7);

    out.close();
    System.exit(0);
  }
  private static void print(char[][] arr) {
    for(int i = 0; i < arr.length; i++) {
      for(int j = 0; j < arr.length; j++)
        System.out.print(arr[i][j]);
      System.out.println();
    }
    System.out.println();
  }
  static char[][] reflect(char[][] arr) {
    int n = arr.length;
    char[][] x = new char[n][n];
    for(int i = 0; i < n; i++) {
      for(int j = 0; j < n; j++){
        x[i][j] = arr[i][n-j-1];
      }
    }
    return x;
  }
  static char[][] rotate(char[][] arr, int r) {
    int n = arr.length;
    char[][] x = new char[n][n];
    if(r==1) { //90 degrees
      for(int i = 0; i < n; i++){
       for(int j = 0; j < n; j++) {
         x[i][j] = arr[n-j-1][i];
       }
      }
      return x;
    }
    if(r == 2) { //180 degrees
      return rotate(rotate(arr,1),1);
    }
    if(r == 3) { //270 degrees
      return rotate(rotate(rotate(arr,1),1),1);
    }
    return arr;
  }
}
