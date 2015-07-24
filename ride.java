/*
ID: kanhacoder
LANG: JAVA
TASK: ride
*/
import java.io.*;
import java.util.*;

class ride{
  public static void main(String[] args) throws IOException {
    BufferedReader f = new BufferedReader(new FileReader("ride.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));
    String a = "0ABCDEFGHIJKLMNOPQRSTUVWXYZ", group="",comet="";
    group = f.readLine();
    comet = f.readLine();
    int mod1=1,mod2=1;
    for(int i = 0; i < group.length(); i++) {
      mod1 *= a.indexOf(Character.toString(group.charAt(i)));
    }
    for(int i = 0; i < comet.length(); i++) {
      mod2 *= a.indexOf(Character.toString(comet.charAt(i)));
    }
    if(mod1%47 == mod2%47)
        out.println("GO");
    else
        out.println("STAY");
    out.close();
    System.exit(0);
  }
}
