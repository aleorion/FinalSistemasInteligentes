
public class Materia
{
    int id;
    public Materia(int id)
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