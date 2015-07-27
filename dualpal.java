/*
ID: kanhapr1
LANG: JAVA
TASK: dualpal
*/
import java.io.*;
import java.util.*;
class dualpal {
  /*API*/
  public static boolean isDualPal(int x){
    int c = 0;
    for(int i = 2; i <= 10; i++) {
      if(isPal(x,i))
        c++;
    }
    return c>=2;
  }
  public static boolean isPal(int x, int b) {
    String cnv = toBase(x,b);
    for(int i = cnv.length()-1,j=0; i >= 0; i--,j++) {
      if(cnv.charAt(i) != cnv.charAt(j))
        return false;
    }
    return true;
  }
  public static char digitToChar(int x) {
    if(x < 10)
      return (char) (x+'0');
    return (char) (x-10+'A');
  }
  public static String toBase(int x, int b) {
    StringBuilder s = new StringBuilder();
    while(x > 0) {
      s.insert(0, digitToChar(x%b));
      x = x/b;
    }
    return s.toString();
  }
  public static void main(String[]args)throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("dualpal.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("dualpal.out")));
    StringTokenizer s = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(s.nextToken());
    int S = Integer.parseInt(s.nextToken());
    //client loop
    int i = 0,j=S+1;
    while(!(i == n)) {
      if(isDualPal(j)) {
        out.println(j);
        i++;
      }
      j++;
    }
    out.close();
    System.exit(0);
  }
}
