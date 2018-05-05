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
        //Main code
        //Code will use comparison by memory pointer not by value.
        parseFile(new File(args[0]));

        World muestra = new World(30, profesores, salones, materias);
        System.out.println(muestra);

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
