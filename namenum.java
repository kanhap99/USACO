/*
ID: kanhapr1
LANG: JAVA
TASK: namenum
*/
import java.io.*;
import java.util.*;

class namenum {
  public static void main(String[]args)throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("namenum.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("namenum.out")));
    String tag = br.readLine();
    List<String> dict = readDict(); //read in the list of qualified names
    List<String> names = new ArrayList<String>(); //list of names to add to
    for(String s : dict) {
      if(s != null && convert(s).equals(tag))
        names.add(s);
    }
    if(names.size() > 0) {
      Collections.sort(names);
      for(String s: names)
        out.println(s);
    }
    else
        out.println("NONE");
    out.close();
    System.exit(0);
  }
  private static String convert(String s){
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < s.length(); i++){
			sb.append(map(s.charAt(i)));
		}
		return sb.toString();
	}
  public static char map(char c) {
    switch(c) {
      case 'A': case 'B' : case 'C': return '2';
      case 'D': case 'E' : case 'F': return '3';
      case 'G': case 'H' : case 'I': return '4';
      case 'J': case 'K' : case 'L': return '5';
      case 'M': case 'N' : case 'O': return '6';
      case 'P': case 'R' : case 'S': return '7';
      case 'T' : case 'U': case 'V': return '8';
      case 'W': case 'X' : case 'Y': return '9';
    }
    return 0;
  }
  public static List<String> readDict()throws IOException, FileNotFoundException {
    BufferedReader in = new BufferedReader(new FileReader("dict.txt"));
    List<String> back = new ArrayList<String>();
    String tmp;
    while((tmp = in.readLine()) != null)
      back.add(tmp);
    return back;
  }
}
