import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

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

    public boolean solved()
    {
        if(population.size() > 0)
        {
            if(population.get(0).performance < (1.0/10000000.0) || population.get(0).performance == 0.0)
            {
                return true;
            }
        }
        return false;
    }

    public Agent solution()
    {
        if(solved())
        {
            return population.get(0);
        }
        return null;
    }

    public Agent top()
    {
        if(population.size() > 0)
        {
            return population.get(0);
        }
        return null;
    }

    public void breed(ArrayList<Profesor> p, ArrayList<Salon> s, ArrayList<Materia> m)
    {
        Random rn = new Random();
        int popSize = size();

        // use function of probability: i/place.
        for (int i = 0; i < popSize; i++)
        {
            Agent current = population.get(i);
            for (int j = 0; j < popSize; j++)
            {
                Agent toBreed = population.get(j);
                if(Math.abs(rn.nextInt())%(i+1) == 0)
                {
                    Agent baby = current.breed(toBreed,p,s,m);
                    population.add(baby);
                }
            }
        }
        sort();
    }

    public void trimm(double percentage)
    {
        //percentage 0.0 - 1.0;
        int popSize = size();
        int trimmed = (int)Math.round(popSize*percentage);

        while(population.size() > trimmed)
        {
            population.remove(population.size()-1);
        }
    }

    public void trimmTo(int trimmed)
    {
        while(population.size() > trimmed)
        {
            population.remove(population.size()-1);
        }
    }

    public int size()
    {
        return population.size();
    }
}