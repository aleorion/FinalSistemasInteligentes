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

    public String smartView()
    {
        return ":"+performance+"{"+adn.smartView()+"}";
    }

    public void calculatePerformance()
    {
        this.performance = ((double)adn.colisions())/((double)(adn.size()*2.0));
    }

    public Agent breed(Agent a, ArrayList<Profesor> p, ArrayList<Salon> s, ArrayList<Materia> m)
    {
        Agent baby = new Agent(p,s,m);
        baby.adn.reestructurateGenome(this.adn,a.adn,p,s,m);
        baby.calculatePerformance();
        return baby;
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

