import java.util.ArrayList;

public class Genoma
 {
    ArrayList<Gen> genes;

    public Genoma(int sizeOfGenome)
    {
        genes = new ArrayList<Gen>();
        //FILL LIST WITH RANDOM GENES size of genome.
    }

    public String toString()
    {
        String str = "[";
        for (Gen g : genes)
        {
            str += g+", ";    
        }
        str += "]";
        return str;
    }

 }