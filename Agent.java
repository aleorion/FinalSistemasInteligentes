import java.util.ArrayList;

public class Agent implements Comparable
{
    Genoma adn;
    double performance;

    public Agent(ArrayList<Profesor> p, ArrayList<Salon> s, ArrayList<Materia> m)
    {
        adn = new Genoma(p,s,m);
        performance = 0.0;
        calculatePerformance();
    }

    public String toString()
    {
        return ":"+performance+":"+adn+":";
    }

    public void calculatePerformance()
    {
        this.performance = ((double)adn.colisions())/((double)(adn.size()*2.0));
    }

    @Override
    public int compareTo(Object o)
    {
        Agent a = (Agent)o;
        if(a.performance > this.performance)
        {
            return -1;
        }
        if(a.performance < this.performance)
        {
            return 1;
        }
        return 0;    
    }

}

