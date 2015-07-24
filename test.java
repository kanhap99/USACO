import java.io.*;
import java.util.*;

class test { //classname = probname
  public static void main(String [] args) throws IOException {
    BufferedReader f = new BufferedReader(new FileReader("milk2.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk2.out")));
    int n = Integer.parseInt(f.readLine());
    int times[][] = new int[n][2];
    for(int i = 0; i < n; i++) {
      System.out.println(f.readLine());
      StringTokenizer st = new StringTokenizer(f.readLine());
      times[i][0] = Integer.parseInt(st.nextToken());
      times[i][1] = Integer.parseInt(st.nextToken());
    }
    int milk = 0,noMilk=0;
    int startTime = times[0][0], endTime = times[0][1],k;
    for(k = 1; k < n; k++) {
      if(times[k][0] <= endTime) {
        endTime = Math.max(times[k][1], endTime);
        startTime = Math.min(times[k][0], startTime);
      }
    }
    k--;
    milk = Math.max(milk, endTime-startTime);
    noMilk = Math.max(noMilk, times[k][0] - endTime);
    if(n <= 1)
      out.println(times[0][1]-times[0][0]+" "+0);
    else
      out.println(milk+" "+noMilk);
    out.close();
    System.exit(0);
  }
}
