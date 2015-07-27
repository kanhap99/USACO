/*
ID: kanhapr1
LANG: JAVA
TASK: palsquare
*/
import java.io.*;
import java.util.*;
class palsquare{
  /*API*/
  public static boolean isPal(int x, int b) {
    String f = toBase(x,b);
    for(int i=f.length()-1,j=0; i >= 0; i--,j++)
      if(f.charAt(i) != f.charAt(j))
        return false;
    return true;
  }
  public static char digitToChar(int d){
    if(d < 10) {
      return (char)(d+'0'); //base is '0'
    }
    else
      return (char)(d-10+'A'); //subtract by 10 and then add to 'A'
  }
  public static String toBase(int x, int b) {
    StringBuilder s = new StringBuilder();
    while(x > 0) {
      s.insert(0,digitToChar(x%b));
      x = x/b;
    }
    return s.toString();
  }
  public static void main(String[] args) throws IOException {
    BufferedReader f = new BufferedReader(new FileReader("palsquare.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("palsquare.out")));
    int base = Integer.parseInt(f.readLine());
    //loop from 1 to 300 inclusive
    for(int i = 1; i <= 300; i++) {
      if(isPal(i*i, base))
        out.println(toBase(i,base)+" "+toBase(i*i,base));
    }

    out.close();
    System.exit(0);
  }
}
