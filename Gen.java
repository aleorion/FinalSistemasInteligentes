import java.util.ArrayList;

public class Gen
{
    Materia m; // same as position on the Genoma!
    Profesor p;
    Horario h;
    Salon s;

    public Gen(ArrayList<Profesor> profesores, Salon salones, Materia m)
    {
        //Create a ramdom valid gen from profesor, horario, salon.
    }

    public String toString()
    {
        return "(m:"+m+" -p:"+p+" -h:"+h+" -s:"+s+")";
    }

} 