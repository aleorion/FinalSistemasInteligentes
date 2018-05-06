
public class Horario
{
    int id;
    public Horario(int id)
    {
        this.id = id;
    }

    public String toString()
    {
        return id+"";
    }

    public String smartView()
    {
        return ""+id;
    }
    
}