import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Random;

public class TestGenerator
{
    public static void main(String[] args)
    {
        try{
            int exp = 50;
            if(args.length == 0 )
            {
                System.out.println("Needs number of files");
                System.exit(0);
            }

            int filenumber = Integer.parseInt(args[0]);

            for (int i = 0; i < filenumber; i++)
            {
                String fileName = i+"autoTest.test";
                FileWriter fileWriter = new FileWriter(fileName);
                PrintWriter printWriter = new PrintWriter(fileWriter);
                int p = random(exp)+5;
                int m = random(exp)+2;
                int s = random(exp)+5;
                printWriter.println(p+","+m+","+s);
                for (int j = 0; j < p; j++)
                {
                    int h1 = random(6)+1;
                    int h2 = h1+random(8-h1)+1;
                    printWriter.print(h1+"-"+h2+",1");
                    for (int k = 2; k < m; k++)
                    {
                        if(random(5) != 0)
                        {
                            printWriter.print(","+k);
                        }       
                    }   
                    printWriter.println(); 
                }
                printWriter.close();
            }
        }catch(Exception e){}

    }
    
    public static int random(int mod)
    {
        Random rn = new Random();
        return Math.abs(rn.nextInt()%mod);
    }
}
