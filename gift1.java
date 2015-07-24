/*
ID: kanhacoder
LANG: JAVA
TASK: gift1
*/
import java.io.*;
import java.util.*;

class gift1 { //classname = probname
  public static void main (String [] args) throws IOException {
    // Use BufferedReader rather than RandomAccessFile; it's much faster
    BufferedReader f = new BufferedReader(new FileReader("gift1.in"));
                                                  // input file name goes above
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));
    // Use StringTokenizer vs. readLine/split -- lots faster
    //StringTokenizer st = new StringTokenizer(f.readLine()); // Get line, break into tokens

    Map<String, Integer> bank = new LinkedHashMap<String, Integer>(); //LinkedHashMap preserves order of insertion
    int n = Integer.parseInt(f.readLine()); //number of people in group
    for(int i = 0; i < n; i++) { //initializing the bank to hold a value of 0 until modified
      bank.put(f.readLine(),0);
    }
    for(int j = 0; j < n; j++) {//main loop for groups of donations
      String name = f.readLine();
      StringTokenizer st = new StringTokenizer(f.readLine());
      int total = Integer.parseInt(st.nextToken());
      int people = Integer.parseInt(st.nextToken());
      if(!(total==0 && people==0)) {
        //deduct from donation bank
        Integer donPrev = bank.get(name);
        bank.put(name,donPrev-total);
        Integer donation = total/people;
        for(int k = 0; k < people; k++) {
          String rec = f.readLine();
          Integer recPrev = bank.get(rec);
          bank.put(rec, recPrev+donation);
        }
        if(total%people != 0) {
          Integer donPrev2 = bank.get(name);
          bank.put(name, donPrev2+(total%people));
        }
      }//if condition ends
    }//main input loop ends
    //output
    for(Map.Entry<String,Integer> e : bank.entrySet()) {
      out.println(e.getKey()+" "+e.getValue());
    }
    out.close();                                  // close the output file
    System.exit(0);                               // don't omit this!
  }
}
