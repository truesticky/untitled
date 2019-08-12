import java.util.Random;

/**
 * Created by Familie on 09.08.2019.
 */
public class Population
{
    int generation = 0;
    int size;
    Dot[] dots;


    public Population(int size)
    {
        this.size = size;
        dots = new Dot[size];

        for(int i = 0; i<size;i++)
        {
            dots[i] = new Dot();
        }
    }

    public void calculateFitness()
    {
        for (Dot dot : dots)
        {
            dot.calculateFitness();
        }
    }

    public boolean allDotsDead()
    {
        for (Dot dot : dots)
        {
            if(dot.alive)
            {
                return false;
            }
        }
        return true;
    }

    public float sumFitnesses()
    {
        float fitnessSum = 0;
        for (Dot dot : dots)
        {
            fitnessSum += Math.abs(dot.calculateFitness());

        }
        //System.out.println("Fitness sum: "+ fitnessSum);
        return fitnessSum;
    }

    public Dot selectParent()
    {
        float base = sumFitnesses();
        double random = 0 + Math.random() * (base - 0);
        float rSum = 0;
        int n = 0;
        for(Dot dot : dots)
        {
            rSum += dot.fitness;
            //System.out.println("rSum " +rSum);
            if(rSum > random)
            {
                return dot;
            }
        }
        return new Dot();
    }

    public void naturalsSelection()
    {
        Dot[] dotsForNextGen = new Dot[dots.length];
        for (int i = 0; i < dotsForNextGen.length; i++)
        {
            Dot parent = selectParent();
            dotsForNextGen[i] = parent.cloneParent();
            dotsForNextGen[i].generation = parent.generation +1;
        }

        dots = dotsForNextGen;
        generation++;
        System.out.println("Natural Selection Completed");
    }

    public void mutate()
    {
        for(Dot dot : dots)
        {
            dot.brain.mutate();
        }
        System.out.println("Mutation Completed");
    }

}
