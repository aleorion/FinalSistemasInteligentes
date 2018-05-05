import java.util.ArrayList;

public class Genoma
 {
    ArrayList<Gen> genes;

    public Genoma(ArrayList<Profesor> p, ArrayList<Salon> s, ArrayList<Materia> m)
    {
        genes = new ArrayList<Gen>();
        //FILL LIST WITH RANDOM GENES size of genome.
        for (int i = 0; i < m.size(); i++)
        {
            genes.add( new Gen( p, s, m.get(i) ) );    
        }
    }

    public String toString()
    {
        String str = "[ ";
        for (Gen g : genes)
        {
            str += g+", ";    
        }
        str += "]";
        return str;
    }

    public int colisions()
    {
        int c = 0;

        for (int i = 0; i < genes.size(); i++)
        {
            Gen actual = genes.get(i);
            boolean colph = false;
            boolean colhs = false;
            for (int j = i+1; j < genes.size(); j++)
            {
                Gen compare = genes.get(j);
                if(actual.p == compare.p && actual.h == compare.h)
                {
                    colph = true;
                }
                if(actual.s == compare.s && actual.h == compare.h)
                {
                    colhs = true;
                }
            }
            if(colph)c++; 
            if(colhs)c++;   
        }

        return c;
    }

    public int size()
    {
        return genes.size();
    }

 }