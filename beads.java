/*
ID: kanhapr1
LANG: JAVA
TASK: beads
*/
import java.io.*;
import java.util.*;

class beads { //classname = probname
  public static void main (String [] args) throws IOException {

    // Use BufferedReader rather than RandomAccessFile; it's much faster
    BufferedReader f = new BufferedReader(new FileReader("beads.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("beads.out")));
    int n =  Integer.parseInt(f.readLine());
    String beads = f.readLine();
    int sum = -1;
    for(int i = 0; i < n; i++) {
      String sub = beads.substring(i)+beads.substring(0,i); //method for dealing with the white characters
      //loop from the front
      int b = 0, c1=0;
      char c = sub.charAt(0),p=c; //first character
      while(p == c || c == 'w') {
        c1++;
        b++;
        if(b < n)
          c = sub.charAt(b);
        else
          break;
        if(p == 'w')
          p = c;
      }
      int o = n-1, c2 = 0;
      char d = sub.charAt(n-1),q=d;
      while(q == d || d=='w') {
        c2++;
        o--;
        if(o >= 0)
          d = sub.charAt(o);
        else
          break;
          if(q == 'w')
            q = d;
      }
      if((c1+c2) > sum)
        sum = c1+c2;
    }
    //check if greater than N
      if(sum > n)
      sum = n;

    out.println(sum);
    out.close();
    System.exit(0);
  }
}
