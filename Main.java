import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
    //Master containers.
    private static ArrayList<Profesor> profesores;
    private static ArrayList<Salon> salones;
    private static ArrayList<Horario> horarios;
    private static ArrayList<Materia> materias;

    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int mode = 0;
        String base = "";
        int num = 0;
        //Main code
        //Code will use comparison by memory pointer not by value.
        if(args.length == 1)
        {
            File f = new File(args[0]);
            solve(f);
            mode = 0;
        }else if(args.length == 2)
        {
            base = args[0];
            num = Integer.parseInt(args[1]);
            mode = 1;
        }else
        {
            System.out.println("Nombre del archivo de ejemplo:");
            solve(new File(scan.nextLine()));
        }

        if(mode == 1)
        {
            for (int i = 0; i < num; i++)
            {
                File f = new File(i+base);
                solve(f);    
            }
        }

        scan.close();
    }

    public static void solve(File f)
    {
        System.out.println("***********************************************");
        long startTime = System.currentTimeMillis();
        int poblacionInicial = 30;
        int generaciones = 0;
        parseFile(f);
        World muestra = new World(poblacionInicial, profesores, salones, materias);
        //System.out.println("Poblacion inicial:");
        //System.out.println(muestra);
        while(!muestra.solved())
        {
            generaciones++;
            muestra.breed(profesores, salones, materias);
            muestra.trimm(0.25);
            muestra.trimmTo(200);
            //System.out.println("Tamanio actual de poblacion: "+muestra.size()+" Generacion:"+(generaciones));
            long currentTime = System.currentTimeMillis();
            if(currentTime-startTime > 1000)
            {
                System.out.println("xx  xx  xx  xx  xx  xx  xx  xx  xx  xx  xx  xx  xx  xx  xx  xx  xx");
                System.out.println("MEJOR: "+muestra.top().smartView());
                System.out.println("TIMEOUT! Does solution exists?");
                System.out.println("ELAPSED TIME: "+(currentTime-startTime)+" miliseconds.");
                return;
            }
        }

        //System.out.println(muestra.solution());
        System.out.println("----------\nSMART VIEW SOLUTION:\n"+muestra.solution().smartView());

        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("ELAPSED TIME: "+elapsedTime+" miliseconds.");
    }

    public static void parseFile(File fname)
    {
        Scanner scan;
        try{
            scan = new Scanner(fname);

            String header = scan.nextLine();
            String[] values = header.split(",");
            int p = Integer.parseInt(values[0]);
            int m = Integer.parseInt(values[1]);
            int s = Integer.parseInt(values[2]);
            init(p,m,s);

            for (int i = 0; i < p; i++)
            {
                Profesor current = profesores.get(i);
                String data = scan.nextLine();
                String[] sections = data.split(",");
                String[] hours = sections[0].split("-");
                //Fill hours from master container.
                for (int j = Integer.parseInt(hours[0]); j < Integer.parseInt(hours[1]); j++) 
                {
                    current.horarios.add(horarios.get(j-1));
                }
                //Fill "materias" from master container.
                for (int j = 1; j < sections.length; j++)
                {
                    current.materias.add( materias.get( Integer.parseInt(sections[j])-1 ) );
                }
            }

            scan.close();

        }catch(Exception e)
        {
            System.out.println("ERROR: "+e);
            e.printStackTrace();
            System.exit(0);
        }
    }

    public static void init(int p, int m, int s)
    {
        int h = 8; // number of hours. Fixed number in document.
        System.out.println("profesores:"+p+", materias:"+m+", salones:"+s);

        profesores = new ArrayList<Profesor>();
        salones = new ArrayList<Salon>();
        materias = new ArrayList<Materia>();
        horarios = new ArrayList<Horario>();

        for (int i = 1; i <= p; i++)
        {
            profesores.add(new Profesor(i));    
        }

        for (int i = 1; i <= s; i++)
        {
            salones.add(new Salon(i));    
        }

        for (int i = 1; i <= m; i++)
        {
            materias.add(new Materia(i));    
        }

        for (int i = 1; i <= h; i++)
        {
            horarios.add(new Horario(i));    
        }
    }
}
