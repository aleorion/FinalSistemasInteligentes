import java.util.ArrayList;

public class Profesor
{
    int id;
    ArrayList<Horario> horarios;
    ArrayList<Materia> materias;
    
    public Profesor(int id, ArrayList<Horario> horarios, ArrayList<Materia> materias)
    {
        this.id = id;
        this.horarios = horarios;
        this.materias = materias;
    }

}