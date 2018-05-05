import java.util.ArrayList;

public class Profesor
{
    int id;
    ArrayList<Horario> horarios;
    ArrayList<Materia> materias;
    
    public Profesor(int id)
    {
        this.id = id;
        horarios = new ArrayList<Horario>();
        materias = new ArrayList<Materia>();
    }

    public Profesor(int id, ArrayList<Horario> horarios, ArrayList<Materia> materias)
    {
        this.id = id;
        this.horarios = horarios;
        this.materias = materias;
    }

    public String toString()
    {
        String str = "<"+id+" H:";

        for (Horario h : horarios) 
        {
            str += h+",";
        }
        str += "M:";
        for (Materia m : materias)
        {
            str += m+",";
        }
        str += ">";

        return str;
    }

}