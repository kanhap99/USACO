/*
ID: kanhapr1
LANG: JAVA
TASK: milk2
*/



import java.io.*;
import java.util.*;
public class milk2
{
    public static boolean[] time = new boolean[1000000];
    public static void main (String[]args) throws IOException
    {
        BufferedReader f = new BufferedReader(new FileReader("milk2.in"));

        int runs = Integer.parseInt(f.readLine()); //number of data points
        int maxRange =0; //furtherest that the time goes
        int minRange =1000000; //closest time
        for (int i = 0; i<runs;i++)
        {
            String StrRange = f.readLine();

            int range[] = new int[2]; //range contains the start and the end time
            range[0] = Integer.parseInt(StrRange.substring(0,StrRange.indexOf(" ")));
            range[1] = Integer.parseInt(StrRange.substring(StrRange.indexOf(" ")+1));
            if (range[1]>maxRange)
                maxRange = range[1];
            if (range[0]<minRange)
                minRange = range[0];

            for (int c = range[0]; c<range[1]; c++)
            {
                time[c]=true;
            }

        }

        int maxWork=0;
        int maxRest=0;


        //count continuous trues
        boolean isWork =true;
        int w=0;
        int r=0;
        for (int i = minRange; i<maxRange;i++)
        {
            if (time[i])
            {
                r=0;
                w++;
                if (w>maxWork)
                    maxWork=w;
            }
            else
            {
                w=0;
                r++;
                if (r>maxRest)
                    maxRest=r;
            }

        }
        System.out.println("maxWork: " + maxWork + "    MaxRest: " + maxRest);
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk2.out")));
        out.println(maxWork + " " + maxRest);
        out.close();




    }


}
