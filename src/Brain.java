import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Familie on 09.08.2019.
 */
public class Brain
{
    Random rnd = new Random();
    MVector[] steps;
    int step = 0;
    Dot dot;

    public Brain(int ste)
    {
        steps = new MVector[ste];
        for (int i = 0; i< ste; i++)
        {
            steps[i] = generateVelocity(rnd.nextInt(900));
        }
    }

    public MVector next()
    {
        MVector result = new MVector(0,0);
        if(step < steps.length)
        {
            result = steps[step];
            step++;
        }
        else
        {
            dot.die();
            return result;
        }
        return result;
    }

    public MVector generateVelocity(int seed)
    {
        int random = rnd.nextInt(4);
        MVector acceleration = new MVector(0,0);
        switch (random)
        {
            case 0:
                acceleration.set(-(rnd.nextFloat()),-(rnd.nextFloat()));
                break;
            case 1:
                acceleration.set((rnd.nextFloat()),-(rnd.nextFloat()));
                break;
            case 2:
                acceleration.set(-(rnd.nextFloat()),(rnd.nextFloat()));
                break;
            case 3:
                acceleration.set((rnd.nextFloat()),(rnd.nextFloat()));
                break;
        }
        return acceleration;
    }

    public Brain cloneBrain()
    {
        Brain clone = new Brain(steps.length);
        for(int i = 0; i < steps.length; i++)
        {
            clone.steps[i] = steps[i];
        }
        return clone;
    }

    public void setDot(Dot dot)
    {
        this.dot = dot;
    }

    public void mutate()
    {
        double mutationRate = 0.01;

        for(int i= 0;i<steps.length;i++)
        {
            double mutate = Math.random();
            if(mutate < mutationRate)
            {
                steps[i] = generateVelocity(360);
                //System.out.println("Done Mutating!");
            }
        }

    }



}
