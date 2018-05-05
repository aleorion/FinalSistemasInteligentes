import java.util.ArrayList;
import java.util.Collections;

public class World
{
    ArrayList<Agent> population;

    public World(int size, ArrayList<Profesor> p, ArrayList<Salon> s, ArrayList<Materia> m)
    {
        population = new ArrayList<Agent>();
        for (int i = 0; i < size; i++) 
        {
            population.add(new Agent(p,s,m));
        }
        sort();
    }

    public String toString()
    {
        String str = "?START\n";
        for (Agent a : population)
        {
            str += a+"\n";    
        }
        str += "?END";
        return str;
    }

    public void sort()
    {
        Collections.sort(population);
    }
}