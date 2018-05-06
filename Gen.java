import java.util.ArrayList;
import java.util.Random;

public class Gen
{
    Materia m; // same as position on the Genoma!
    Profesor p;
    Horario h;
    Salon s;

    public Gen(ArrayList<Profesor> profesores, ArrayList<Salon> salones, Materia m)
    {
        //Create a ramdom valid gen from profesor, horario, salon.
        Random rn = new Random();
        this.m = m;

        int randomp = Math.abs(rn.nextInt())%profesores.size();
        int randoms = Math.abs(rn.nextInt())%salones.size();

        this.p = profesores.get(randomp);
        this.s = salones.get(randoms);

        int randomh = Math.abs(rn.nextInt())%this.p.horarios.size();

        this.h = this.p.horarios.get(randomh);
    }

    public String toString()
    {
        return "(m:"+m+" -p:"+p+" -h:"+h+" -s:"+s+")";
    }

    public String smartView()
    {
        return "(m:"+m.smartView()+" p:"+p.smartView()+" h:"+h.smartView()+" s:"+s.smartView()+")";
    }

} 